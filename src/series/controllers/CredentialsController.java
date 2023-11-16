/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.controllers;

import database.DBConnection;
import series.views.Credentials;

/**
 *
 * @author Diego
 */
public class CredentialsController {
    private Credentials window;

    private static final String WINDOW_TITLE = "Ingrese las Credenciales";
    
    public CredentialsController() {
        //DBConnection.configureConnection("localhost","3306","seriesadministrator","root","river123")
        this.window = new Credentials(this);
        this.window.setLocationRelativeTo(null);
        this.window.setTitle(WINDOW_TITLE);
        this.window.setResizable(false);
        this.window.setVisible(true);
    }
    
    public void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    public void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    public void txtServerHostKeyTyped(java.awt.event.KeyEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    public void txtPortKeyTyped(java.awt.event.KeyEvent evt) {                                 
        // TODO add your handling code here:
    }                                

    public void txtDatabaseKeyTyped(java.awt.event.KeyEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    public void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    public void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {                                     
        // TODO add your handling code here:
    }  
}
