/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.controllers;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import series.models.CustomTableCellRenderer;
import series.models.SeriesTable;
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
        this.window.setTitle(WINDOW_TITLE);
        this.window.getSeriesTable().setModel(new SeriesTable());
        
        String rateColumnName = this.window.getSeriesTable().getColumnName(SeriesTable.RATE_COL_INDEX);
        String priceColumnName = this.window.getSeriesTable().getColumnName(SeriesTable.PRICE_COL_INDEX);
        String atpColumnName = this.window.getSeriesTable().getColumnName(SeriesTable.ATP_COL_INDEX);
        String stateColumnName = this.window.getSeriesTable().getColumnName(SeriesTable.STATE_COL_INDEX);

        
        this.window.getSeriesTable().getColumn(rateColumnName).setCellRenderer(new CustomTableCellRenderer());
        this.window.getSeriesTable().getColumn(priceColumnName).setCellRenderer(new CustomTableCellRenderer());
        this.window.getSeriesTable().getColumn(atpColumnName).setCellRenderer(new CustomTableCellRenderer());
        
        this.window.getSeriesTable().getColumn(atpColumnName).setPreferredWidth(10);
        this.window.getSeriesTable().getColumn(stateColumnName).setPreferredWidth(16);
        this.window.getSeriesTable().getColumn(rateColumnName).setPreferredWidth(22);

        
        this.window.setVisible(true);
    }
    
    public void btnRefreshClick(ActionEvent evt){
        //option pane de confirmar si quiere refrescar
    }
    
    public void btnExitClick(ActionEvent evt){
        int option = JOptionPane.showOptionDialog(this.window, EXIT_CONFIRMATION, "Salir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Confirmar","Cancelar"}, "Cancelar");
        if(option==JOptionPane.OK_OPTION){
            //Close connection?
            System.exit(0);
        }
    }
    
    public void btnCreateClick(ActionEvent evt){
        //Abirir una nueva ventana jdialog
    }
    
    public void btnUpdateClick(ActionEvent evt){
        //abrir una nueva ventana jdialog
        //si no hay series tiene que aparecer una joptionpane
    }
    
    public void btnDeleteClick(ActionEvent evt){
        //abrir una option pane para ocnfirmar
        //si no hay series tiene que aparecer una joptionpane
    }
    
    public void btnSwitchStateClick(ActionEvent evt){
        //abrir una option pane para ocnfirmar diferenciando los estados y mensajes
        //si no hay series tiene que aparecer una joptionpane
    }
}
