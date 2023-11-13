/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.models;

import helpers.Validation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class SeriesManager {
    private static List<Series> series = new ArrayList<>();
    private static SeriesManager instance;
    private static final String CREATE_SUCCEED = "Serie creada con éxito";
    private static final String UPDATE_SUCCEED = "Serie actalizada con éxito";
    private static final String SERIES_NOT_FOUND = "La serie no se encontró";
    private static final String DELETED_SUCCEED = "Serie eliminada con éxito";
    private static final String TITLE_INVALID = "Ingrese un título válido";
    private static final String DETAIL_INVALID = "Ingrese una descripción válida";
    private static final String RELEASED_INVALID = "Ingrese una fecha de lanzamiento válida";
    private static final String RATE_INVALID = "Ingrese una cantidad de estrellas válida";
    private static final String GENRE_INVALID = "Ingrese un género válido";
    private static final String PRICE_INVALID = "Ingrese un precio válido";    
    
    
    public SeriesManager() {
    }
    
    public static SeriesManager create(){
        if(instance == null){
            instance = new SeriesManager();
        }
        return instance;
    }
    
    public List<Series> listSeries(){
        return series;
    }
    
    public String createSeries(String title, String detail, LocalDate released, int rate, String genre, float price, boolean ATP){
        int lastId = 1;
        if(series.size() > 0){
            lastId = series.get(series.size() - 1).getIdSeries() + 1;
        }
        
        if(!Validation.titleValidation(title)) return TITLE_INVALID;
        if(!Validation.detailValidation(detail)) return DETAIL_INVALID;
        if(!Validation.genreValidation(genre)) return GENRE_INVALID;
        if(!Validation.releasedValidation(released)) return RELEASED_INVALID;
        if(!Validation.priceValidation(price)) return PRICE_INVALID;
        if(!Validation.rateValidation(rate)) return RATE_INVALID;
        
        Series newSeries = new Series(lastId, title, detail, released, rate, genre, price, ATP);
        series.add(newSeries);
        return CREATE_SUCCEED;
    }
    
    public String updateSeries(int idSeries, String title, String detail, LocalDate released, int rate, String genre, float price, boolean ATP){
        Series updatedSeries = null;
        for(int i = 0; i < series.size(); i++){
            if(series.get(i).getIdSeries() == idSeries){
                updatedSeries = series.get(i);
            }
        }
        
        if(updatedSeries == null){
            return SERIES_NOT_FOUND;
        }
        
        if(!Validation.titleValidation(title)) return TITLE_INVALID;
        if(!Validation.detailValidation(detail)) return DETAIL_INVALID;
        if(!Validation.genreValidation(genre)) return GENRE_INVALID;
        if(!Validation.releasedValidation(released)) return RELEASED_INVALID;
        if(!Validation.priceValidation(price)) return PRICE_INVALID;
        if(!Validation.rateValidation(rate)) return RATE_INVALID;
        
        updatedSeries.setTitle(title);
        updatedSeries.setDetail(detail);
        updatedSeries.setReleased(released);
        updatedSeries.setRate(rate);
        updatedSeries.setGenre(genre);
        updatedSeries.setPrice(price);
        updatedSeries.setATP(ATP);
        
        return UPDATE_SUCCEED;
    }
    
    public String deleteSeries(int idSeries){
        boolean deleted = false;
        for(int i = 0; i < series.size(); i++){
            if(series.get(i).getIdSeries() == idSeries){
                series.remove(i);
                deleted = true;
            }
        }
        
        if(!deleted) return SERIES_NOT_FOUND;
        return DELETED_SUCCEED;
    }
    
    public Series searchSerieById(int idSeries){
        Series searchedSeries = null;
        
        for(int i = 0; i < series.size(); i++){
            if(series.get(i).getIdSeries() == idSeries){
                searchedSeries = series.get(i);
            }
        }
        
        return searchedSeries;
    }
}
