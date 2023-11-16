/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.models;

import database.DBConnection;
import helpers.Validation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import series.models.GenreComboModel.Genre;

/**
 *
 * @author Diego
 */
public class SeriesManager {
    private List<Series> series = new ArrayList<>();
    private static SeriesManager instance;
    private DBConnection connection;
    public static final String CREATE_SUCCEED = "Serie creada con éxito";
    public static final String UPDATE_SUCCEED = "Serie actualizada con éxito";
    public static final String SERIES_NOT_FOUND = "La serie no se encontró";
    public static final String DELETED_SUCCEED = "Serie eliminada con éxito";
    public static final String TITLE_INVALID = "Ingrese un título válido";
    public static final String DETAIL_INVALID = "Ingrese una descripción válida";
    public static final String RELEASED_INVALID = "Ingrese una fecha de lanzamiento válida";
    public static final String RATE_INVALID = "Ingrese una cantidad de estrellas válida";
    public static final String GENRE_INVALID = "Ingrese un género válido";
    public static final String PRICE_INVALID = "Ingrese un precio válido";
    public static final String UNKNOWN_ERROR = "Ocurrió un error, intente nuevamente";
    public static final String REFRESH_SUCCEED = "La tabla fue refrescada con éxito";
    public static final String REFRESH_ERROR = "La tabla no se pudo refrescar";
    
    
    public SeriesManager() {
        this.connection = DBConnection.getCreatedConnection();
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
    
    public String createSeries(String title, String detail, LocalDate released, int rate, Genre genre, float price, boolean ATP){    
        if(!Validation.titleValidation(title)) return TITLE_INVALID;
        if(!Validation.detailValidation(detail)) return DETAIL_INVALID;
        if(!Validation.genreValidation(genre)) return GENRE_INVALID;
        if(!Validation.releasedValidation(released)) return RELEASED_INVALID;
        if(!Validation.priceValidation(price)) return PRICE_INVALID;
        if(!Validation.rateValidation(rate)) return RATE_INVALID;
        
        SeriesDAO seriesDAO = new SeriesDAO(this.connection);
        if(this.connection != null){
            Series createdSeries = seriesDAO.createSeries(title, detail, released, rate, genre, price, ATP);
            if(createdSeries == null) return UNKNOWN_ERROR;
            this.series.add(createdSeries);
        }
        return CREATE_SUCCEED;
    }
    
    public String updateSeries(int idSeries, String title, String detail, LocalDate released, int rate, Genre genre, float price, boolean ATP){
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
        SeriesDAO seriesDAO = new SeriesDAO(this.connection);
        boolean deleted = false;
        if(this.connection != null){
            int deletedId = seriesDAO.deleteSeries(idSeries);
            if(deletedId == -1){
                return SERIES_NOT_FOUND;
            }   
        }
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
    
    public String refreshSeries(){
        SeriesDAO seriesDAO = new SeriesDAO(this.connection);
        if(this.connection != null){
            List<Series> refreshedSeries = seriesDAO.getAllSeries();
            if(refreshedSeries != null){
                this.series = refreshedSeries;
                return REFRESH_SUCCEED;
            }
        }
        return REFRESH_ERROR;
    }
    
    public String deactivateSearchedSeries(int idSerie){
        SeriesDAO seriesDAO = new SeriesDAO(this.connection);
        if(this.connection != null){
            int idDeactivated = seriesDAO.deactivateSeries(idSerie);
            if(idDeactivated == -1){
                return UNKNOWN_ERROR;
            }   
        }
        return this.searchSerieById(idSerie).deactivate();
    }
    
        public String activateSearchedSeries(int idSerie){
        SeriesDAO seriesDAO = new SeriesDAO(this.connection);
        if(this.connection != null){
            int idActivated = seriesDAO.activateSeries(idSerie);
            if(idActivated == -1){
                return UNKNOWN_ERROR;
            }   
        }
        return this.searchSerieById(idSerie).activate();
    }
}
