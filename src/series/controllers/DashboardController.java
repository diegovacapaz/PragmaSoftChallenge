/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.controllers;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import series.models.CustomTableCellRenderer;
import series.models.Series;
import series.models.SeriesManager;
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
    private static final String DELETE_CONFIRMATION = "¿Desea borrar la serie seleccionada?";
    private static final String ROW_NOT_SELECTED = "Primero debe seleccionar una fila";
    private static final String DELETE_EMPTY = "No hay series para borrar";
    private static final String SWITCH_STATE_EMPTY = "No hay series para anular o activar";
    private static final String ACTIVATE_STATE_CONFIRMATION = "¿Desea activar la serie seleccionada?";
    private static final String DEACTIVATE_STATE_CONFIRMATION = "¿Desea anular la serie seleccionada?";
    private static final String UPDATE_EMPTY = "No hay series para modificar";
    private static final String UPDATE_UNABLED = "No puede modificar una serie anulada";

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
        SeriesTable tableModel = (SeriesTable)this.window.getSeriesTable().getModel();
        
        SeriesFormController controller = new SeriesFormController(this.window, true, null);
        tableModel.refresh();
    }
    
    public void btnUpdateClick(ActionEvent evt){
        SeriesManager manager = SeriesManager.create();
        
        if(manager.listSeries().isEmpty()){
            JOptionPane.showMessageDialog(this.window, UPDATE_EMPTY, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int selectedRow = this.window.getSeriesTable().getSelectedRow();
        
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this.window, ROW_NOT_SELECTED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        SeriesTable tableModel = (SeriesTable)this.window.getSeriesTable().getModel();
        Series selectedSeries = tableModel.getSerie(selectedRow);
        if(selectedSeries.isActive()){
            SeriesFormController controller = new SeriesFormController(this.window, false, selectedSeries);
            tableModel.refresh();
        }
        else{
            JOptionPane.showMessageDialog(this.window, UPDATE_UNABLED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    public void btnDeleteClick(ActionEvent evt){
        SeriesManager manager = SeriesManager.create();
        
        if(manager.listSeries().isEmpty()){
            JOptionPane.showMessageDialog(this.window, DELETE_EMPTY, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int selectedRow = this.window.getSeriesTable().getSelectedRow();
        
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this.window, ROW_NOT_SELECTED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        SeriesTable tableModel = (SeriesTable)this.window.getSeriesTable().getModel();
        Series selectedSeries = tableModel.getSerie(selectedRow);
        
        int option = JOptionPane.showOptionDialog(this.window, DELETE_CONFIRMATION, "Eliminar Serie", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Eliminar","Volver"}, "Cancelar");
        if(option==JOptionPane.OK_OPTION){
            String message = manager.deleteSeries(selectedSeries.getIdSeries());
            JOptionPane.showMessageDialog(this.window, message, "Información", JOptionPane.INFORMATION_MESSAGE);
            tableModel.refresh();
        }
    }
    
    public void btnSwitchStateClick(ActionEvent evt){
        SeriesManager manager = SeriesManager.create();
        
        if(manager.listSeries().isEmpty()){
            JOptionPane.showMessageDialog(this.window, SWITCH_STATE_EMPTY, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int selectedRow = this.window.getSeriesTable().getSelectedRow();
        
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this.window, ROW_NOT_SELECTED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        SeriesTable tableModel = (SeriesTable)this.window.getSeriesTable().getModel();
        Series selectedSeries = tableModel.getSerie(selectedRow);
        
        if(selectedSeries.isActive()){
            int option = JOptionPane.showOptionDialog(this.window, DEACTIVATE_STATE_CONFIRMATION, "Anular Serie", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Anular","Volver"}, "Cancelar");
            if(option==JOptionPane.OK_OPTION){
                String message = manager.searchSerieById(selectedSeries.getIdSeries()).deactivate();
                JOptionPane.showMessageDialog(this.window, message, "Información", JOptionPane.INFORMATION_MESSAGE);
                tableModel.refresh();
            }
        }
        else{
            int option = JOptionPane.showOptionDialog(this.window, ACTIVATE_STATE_CONFIRMATION, "Activar Serie", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Activar","Volver"}, "Cancelar");
            if(option==JOptionPane.OK_OPTION){
                String message = manager.searchSerieById(selectedSeries.getIdSeries()).activate();
                JOptionPane.showMessageDialog(this.window, message, "Información", JOptionPane.INFORMATION_MESSAGE);
                tableModel.refresh();
            }
        }
    }
}
