/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.models;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Diego
 */
public class SeriesTable extends AbstractTableModel{
    private final List<String> columnsNames = new ArrayList<>();
    private List<Series> series = new ArrayList<>();
    public static final int TITLE_COL_INDEX = 0;
    public static final int DETAIL_COL_INDEX = 1;
    public static final int RELEASED_COL_INDEX = 2;
    public static final int RATE_COL_INDEX = 3;
    public static final int GENRE_COL_INDEX = 4;
    public static final int PRICE_COL_INDEX = 5;
    public static final int ATP_COL_INDEX = 6;
    public static final int STATE_COL_INDEX = 7;
    
    

    public SeriesTable() {
        this.columnsNames.add("Título");
        this.columnsNames.add("Descripción");
        this.columnsNames.add("Fecha Estreno");
        this.columnsNames.add("Estrellas");
        this.columnsNames.add("Género");
        this.columnsNames.add("Precio Alquiler");
        this.columnsNames.add("ATP");
        this.columnsNames.add("Estado");
        SeriesManager manager = SeriesManager.create();
        this.series = manager.listSeries();
    }
    
    @Override
    public int getRowCount(){
        return this.series.size();
    }
    
    @Override
    public int getColumnCount() {
        return this.columnsNames.size();
    }
    
        @Override
    public Object getValueAt(int row, int col) {
        Series serie = this.series.get(row);
        switch(col){
            case TITLE_COL_INDEX:
                return serie.getTitle();
            case DETAIL_COL_INDEX:
                return serie.getDetail();
            case RELEASED_COL_INDEX:
                return serie.getReleased().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            case RATE_COL_INDEX:
                return serie.getRate();
            case GENRE_COL_INDEX:
                return serie.getGenre().toString();
            case PRICE_COL_INDEX:
                return serie.getPrice();
            case ATP_COL_INDEX:
                return serie.isATP();
            case STATE_COL_INDEX:
                return serie.getState();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int col) {
        return this.columnsNames.get(col);
    }
    
    public Series getSerie(int row) {
        return this.series.get(row);
    }
    
    public List<Series> getSeries(){
        return this.series;
    }
    
    public void setSeries(List<Series> series){
        this.series = series;
    }
    
    public void refresh(){
        SeriesManager manager = SeriesManager.create();
        this.series = manager.listSeries();
        this.fireTableDataChanged();
    }
}
