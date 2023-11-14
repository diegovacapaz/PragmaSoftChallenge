/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.ZoneId;
import java.util.Date;
import series.models.Series;
import series.models.SeriesManager;
import series.views.Dashboard;
import series.views.SeriesForm;

/**
 *
 * @author Diego
 */
public class SeriesFormController {
    private SeriesForm window;
    private Series serie;
    public static final String CREATE_WINDOW_TITLE = "Nueva Serie";
    public static final String UPDATE_WINDOW_TITLE = "Modificar Serie";
    
    public SeriesFormController(Dashboard parent, boolean isCreateWindow, Series serie) {
        SeriesManager manager = SeriesManager.create();
        
        this.window = new SeriesForm(this, parent, true);
        this.window.setLocationRelativeTo(null);
        if(isCreateWindow){
            this.window.setTitle(CREATE_WINDOW_TITLE);
        }
        else {
            this.window.setTitle(UPDATE_WINDOW_TITLE);
        }
        this.serie = serie;
        this.window.getDatePickerReleased().setDateFormatString("dd/MM/yyyy");
        //this.window.getComboGenre().setModel();
        if(serie == null){
            this.window.getTxtTitle().setText(null);
            this.window.getTxtAreaDetail().setText(null);
            this.window.getTxtRate().setText(null);
            this.window.getTxtPrice().setText(null);
            this.window.getComboGenre().setSelectedIndex(-1);
            this.window.getCheckATP().setSelected(false);
        }
        else{
            this.window.getTxtTitle().setText(serie.getTitle());
            this.window.getTxtAreaDetail().setText(serie.getDetail());
            this.window.getTxtRate().setText(Integer.toString(serie.getRate()));
            this.window.getTxtPrice().setText(Float.toString(serie.getPrice()));
            //Este combo debe selecionar la opcion
            this.window.getComboGenre().setSelectedIndex(-1);
            this.window.getCheckATP().setSelected(serie.isATP());
            Date released = Date.from(serie.getReleased().atStartOfDay(ZoneId.systemDefault()).toInstant());
            this.window.getDatePickerReleased().setDate(released);
        }
        this.window.setResizable(false);
        this.window.setVisible(true);
    }
    
    public void btnAcceptClick(ActionEvent evt){
        
    }
    
    public void btnCancelClick(ActionEvent evt){
        
    }
    
    public void txtTitleKeyTyped(KeyEvent evt) {                                  
        
    }                                 

    public void txtAreaDetailKeyTyped(KeyEvent evt) {                                       
        
    }                                      

    public void txtRateKeyTyped(KeyEvent evt) {                                 
        
    }                                

    public void txtPriceKeyTyped(KeyEvent evt) {                                  
        
    }     
}
