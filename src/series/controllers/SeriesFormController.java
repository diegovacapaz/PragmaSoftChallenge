/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import series.models.GenreComboModel;
import series.models.GenreComboModel.Genre;
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
    private boolean isCreateWindow;
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
        this.window.getComboGenre().setModel(new GenreComboModel());
        if(serie == null && isCreateWindow){
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
            this.window.getComboGenre().setSelectedItem(serie.getGenre());
            this.window.getCheckATP().setSelected(serie.isATP());
            Date released = Date.from(serie.getReleased().atStartOfDay(ZoneId.systemDefault()).toInstant());
            this.window.getDatePickerReleased().setDate(released);
        }
        this.window.setResizable(false);
        this.window.setVisible(true);
        this.isCreateWindow = isCreateWindow;
    }
    
    public void btnAcceptClick(ActionEvent evt){
        String title;
        String detail;
        int rate = -1;
        Genre genre;
        float price = -1;
        LocalDate released;
        boolean ATP;
        SeriesManager manager = SeriesManager.create();
        
        String txtRate = this.window.getTxtRate().getText();
        String txtPrice = this.window.getTxtPrice().getText();
        
        if(!txtRate.isBlank()) rate = Integer.parseInt(txtRate);
        if(!txtPrice.isBlank()) price = Float.parseFloat(txtPrice);
        ATP = this.window.getCheckATP().isSelected();
        title = this.window.getTxtTitle().getText();
        detail = this.window.getTxtAreaDetail().getText();
        genre = ((GenreComboModel)this.window.getComboGenre().getModel()).getGenre();
        try{
            Date date = this.window.getDatePickerReleased().getCalendar().getTime();
            released = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();               
        }
        catch(NullPointerException e){
            released = null;
        }
        
        if(serie == null || this.isCreateWindow){            
            int previousSeriesSize = manager.listSeries().size();
            String message = manager.createSeries(title, detail, released, rate, genre, price, ATP);
            
            if(manager.listSeries().size() > previousSeriesSize){
                JOptionPane.showMessageDialog(this.window, message, "Información", JOptionPane.INFORMATION_MESSAGE);
                this.window.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this.window, message, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            String message = manager.updateSeries(serie.getIdSeries(), title, detail, released, rate, genre, price, ATP);
            if(message == SeriesManager.UPDATE_SUCCEED){
                JOptionPane.showMessageDialog(this.window, message, "Información", JOptionPane.INFORMATION_MESSAGE);
                this.window.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this.window, message, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void btnCancelClick(ActionEvent evt){
        this.window.dispose();
    }
    
    public void txtTitleKeyTyped(KeyEvent evt) {                                  
        char c = evt.getKeyChar();
        if(c == KeyEvent.VK_ENTER) this.btnAcceptClick(null);
    }                                    

    public void txtRateKeyTyped(KeyEvent evt) {                                 
        char c = evt.getKeyChar();
        if(this.window.getTxtRate().getText().length() == 1) evt.consume();
        if(!Character.isDigit(c)){
            switch(c){
                case KeyEvent.VK_ENTER:
                    this.btnAcceptClick(null);
                    break;
                default:
                    evt.consume();
                    break;
            }
        }
    }                                

    public void txtPriceKeyTyped(KeyEvent evt) {                                  
        char c = evt.getKeyChar();
        if(this.window.getTxtPrice().getText().contains(".") && c == KeyEvent.VK_PERIOD) evt.consume();        
        if(!Character.isDigit(c) && c != KeyEvent.VK_PERIOD){
            switch(c){
                case KeyEvent.VK_ENTER:
                    this.btnAcceptClick(null);
                    break;
                default:
                    evt.consume();
                    break;
            }
        }
    }     
}
