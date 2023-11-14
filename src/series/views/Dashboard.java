/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.views;

import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JTable;
import series.controllers.DashboardController;
import series.models.CustomTableCellRenderer;
import series.models.SeriesManager;
import series.models.SeriesTable;

/**
 *
 * @author Diego
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    private DashboardController controller;
    
    public Dashboard(DashboardController controller) {
        initComponents();
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRefresh = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSwitchState = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();
        seriesTable = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Series Administrator");
        setName("Dashboard"); // NOI18N
        setResizable(false);

        btnRefresh.setText("Consultar");
        btnRefresh.setActionCommand("refresh");
        btnRefresh.setPreferredSize(new java.awt.Dimension(77, 30));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnExit.setText("Salir");
        btnExit.setActionCommand("exit");
        btnExit.setPreferredSize(new java.awt.Dimension(77, 30));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnUpdate.setText("Modificar");
        btnUpdate.setActionCommand("update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(77, 30));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSwitchState.setText("Anular / Activar");
        btnSwitchState.setActionCommand("switchState");
        btnSwitchState.setPreferredSize(new java.awt.Dimension(100, 30));
        btnSwitchState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchStateActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.setActionCommand("delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(77, 30));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        seriesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        seriesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPanel.setViewportView(seriesTable);

        btnCreate.setText("Nuevo");
        btnCreate.setActionCommand("update");
        btnCreate.setPreferredSize(new java.awt.Dimension(77, 30));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSwitchState, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSwitchState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(72, Short.MAX_VALUE)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE)))
        );

        btnRefresh.getAccessibleContext().setAccessibleName("refresh");
        btnExit.getAccessibleContext().setAccessibleName("exit");
        btnUpdate.getAccessibleContext().setAccessibleName("update");
        btnSwitchState.getAccessibleContext().setAccessibleName("switchState");
        btnDelete.getAccessibleContext().setAccessibleName("delete");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        this.controller.btnRefreshClick(evt);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        this.controller.btnUpdateClick(evt);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSwitchStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchStateActionPerformed
        this.controller.btnSwitchStateClick(evt);
    }//GEN-LAST:event_btnSwitchStateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        this.controller.btnDeleteClick(evt);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.controller.btnExitClick(evt);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        this.controller.btnCreateClick(evt);
    }//GEN-LAST:event_btnCreateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SeriesManager manager= SeriesManager.create();
        
        manager.createSeries("Peter Pan", "Descripcion simple", LocalDate.of(2020, 1, 25), 2, "Drama", 2000.01f, true);
        manager.createSeries("Peter Pan", "Descripcion simple", LocalDate.of(2020, 1, 25), 2, "Drama", 2050.10f, true);
        manager.createSeries("Peter Pan", "Descripcion simple", LocalDate.of(2020, 1, 25), 2, "Drama", 2000.152f, true);
        
        String message = manager.deleteSeries(2);
        System.out.println(message);
        
        manager.createSeries("Peter Pan", "Descripcion simple", LocalDate.of(2020, 1, 25), 2, "Drama", 2000.152f, true);
        
        for(int i = 0; i < manager.listSeries().size(); i++){
            System.out.println(manager.listSeries().get(i).getDetail());        
        }
        
        String message2 = manager.updateSeries(3, "Peter Pan 2", "Descripcion simple 2", LocalDate.of(2020, 1, 25), 2, "Drama", 2000.01f, true);
        System.out.println(message2);
        
        for(int i = 0; i < manager.listSeries().size(); i++){
            System.out.println(manager.listSeries().get(i).getDetail());     
        }
        
        System.out.println(manager.searchSerieById(1).getIdSeries());
        
        String message3 = manager.createSeries("Peter Pan", "  D 2   2 ", LocalDate.of(2020, 1, 25), 0, "Drama", 2000.01f, true);
        System.out.println(message3);
        
        
        DashboardController controller = new DashboardController();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSwitchState;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTable seriesTable;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnCreate() {
        return btnCreate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public JButton getBtnRefresh() {
        return btnRefresh;
    }

    public JTable getSeriesTable() {
        return seriesTable;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }
    
}
