/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.controllers;

import database.DBConnection;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;
import series.views.Credentials;

/**
 *
 * @author Diego
 */
public class CredentialsController {
    private Credentials window;

    private static final String WINDOW_TITLE = "Ingrese las Credenciales";
    private static final String EXIT_CONFIRMATION = "¿Desea cerrar la sesión?";
    private static final String SERVER_REQUIRED = "Ingrese el servidor o host";
    private static final String PORT_REQUIRED = "Ingrese el puerto";
    private static final String DATABASE_REQUIRED = "Ingrese la base de datos";
    private static final String USERNAME_REQUIRED = "Ingrese el usuario";
    private static final String PASSWORD_REQUIRED = "Ingrese la contraseña";
    private static final String BAD_CONNECTION = "Conexión fallida, intente de nuevo";
    
    public CredentialsController() {
        this.window = new Credentials(this);
        this.window.setLocationRelativeTo(null);
        this.window.setTitle(WINDOW_TITLE);
        this.window.setResizable(false);
        this.window.setVisible(true);
    }
    
    public void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String server = this.window.getTxtServerHost().getText();
        String port = this.window.getTxtPort().getText();
        String database = this.window.getTxtDatabase().getText();
        String username = this.window.getTxtUsername().getText();
        String password = new String(this.window.getTxtPassword().getPassword());
        
        if(server.isBlank()){
            JOptionPane.showMessageDialog(this.window, SERVER_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(port.isBlank()){
            JOptionPane.showMessageDialog(this.window, PORT_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(database.isBlank()){
            JOptionPane.showMessageDialog(this.window, DATABASE_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(username.isBlank()){
            JOptionPane.showMessageDialog(this.window, USERNAME_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(password.isBlank()){
            JOptionPane.showMessageDialog(this.window, PASSWORD_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            DBConnection connection = DBConnection.configureConnection(server,port,database,username,password);
            DashboardController dashboardController = new DashboardController(connection);
            this.window.dispose();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this.window, BAD_CONNECTION, "Error", JOptionPane.ERROR_MESSAGE);
            DBConnection.resetConnection();
        }
    }                                          

    public void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        int option = JOptionPane.showOptionDialog(this.window, EXIT_CONFIRMATION, "Salir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Confirmar","Cancelar"}, "Cancelar");
        if(option==JOptionPane.OK_OPTION){
            System.exit(0);
        }
    }                                       

    public void txtServerHostKeyTyped(java.awt.event.KeyEvent evt) {                                       
        char c = evt.getKeyChar();
        if(c == KeyEvent.VK_ENTER) this.btnConnectActionPerformed(null);
    }                                      

    public void txtPortKeyTyped(java.awt.event.KeyEvent evt) {                                 
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            switch(c){
                case KeyEvent.VK_ENTER:
                    this.btnConnectActionPerformed(null);
                    break;
                default:
                    evt.consume();
                    break;
            }
        }
    }                                

    public void txtDatabaseKeyTyped(java.awt.event.KeyEvent evt) {                                     
        char c = evt.getKeyChar();
        if(c == KeyEvent.VK_ENTER) this.btnConnectActionPerformed(null);
    }                                    

    public void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {                                     
        char c = evt.getKeyChar();
        if(c == KeyEvent.VK_ENTER) this.btnConnectActionPerformed(null);
    }                                    

    public void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {                                     
        char c = evt.getKeyChar();
        if((!Character.isLetter(c))&&(!Character.isDigit(c))){
            switch(c){
                case KeyEvent.VK_ENTER:
                    this.btnConnectActionPerformed(null);
                    break;
                default:
                    evt.consume();
                    break;
            }
        }
    }  
}
