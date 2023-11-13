/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.controllers;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import series.views.Dashboard;

/**
 *
 * @author Diego
 */


public class DashboardController {
    private Dashboard window;
    private static final String WINDOW_TITLE = "Administrador de Series";
    private static final String EXIT_CONFIRMATION = "¿Desea cerrar la sesión?";
    
    public DashboardController() {
        this.window = new Dashboard(this);
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);
        this.window.setTitle(WINDOW_TITLE);
    }
    
    public void btnRefreshClick(ActionEvent evt){
        
    }
    
    public void btnExitClick(ActionEvent evt){
        int option = JOptionPane.showOptionDialog(this.window, EXIT_CONFIRMATION, "Salir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Confirmar","Cancelar"}, "Cancelar");
        if(option==JOptionPane.OK_OPTION){
            //Close connection?
            System.exit(0);
        }
    }
    
    public void btnCreateClick(ActionEvent evt){
        
    }
    
    public void btnUpdateClick(ActionEvent evt){
        
    }
    
    public void btnDeleteClick(ActionEvent evt){
        
    }
    
    public void btnSwitchStateClick(ActionEvent evt){
        
    }
}
