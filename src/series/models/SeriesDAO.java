/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.models;

import java.sql.CallableStatement;
import database.DBConnection;
import java.math.BigDecimal;
import series.models.GenreComboModel.Genre;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Types;

/**
 *
 * @author Diego
 */
public class SeriesDAO {
    private DBConnection connectionData;

    public SeriesDAO(DBConnection connectionData) {
        this.connectionData = connectionData;
    }
    
    public Series createSeries(String title, String detail, LocalDate released, int rate, Genre genre, float price, boolean atp) {
        Series returnedSeries = null;
        try {
            Connection connection = this.connectionData.connect();
            CallableStatement cstmt = connection.prepareCall("{CALL createSeries(?, ?, ?, ?, ?, ?, ?)}");

            cstmt.setString(1, title);
            cstmt.setString(2, detail);
            
            Date releasedDated = Date.from(released.atStartOfDay(ZoneId.systemDefault()).toInstant());

            cstmt.setDate(3, java.sql.Date.valueOf(released));
            cstmt.setInt(4, rate);
            cstmt.setString(5, genre.toString());
            cstmt.setBigDecimal(6, BigDecimal.valueOf(price));
            cstmt.setBoolean(7, atp);

            boolean result = cstmt.execute();
            if(result){
                ResultSet resultSet = cstmt.getResultSet();
                if (resultSet.next()) {
                    int seriesIdReturned = resultSet.getInt("idSeries");
                    String titleReturned = resultSet.getString("title");
                    String detailReturned = resultSet.getString("detail");
                    LocalDate releasedReturned = resultSet.getDate("released").toLocalDate();
                    int rateReturned = resultSet.getInt("rate");
                    Genre genreReturned = Genre.toGenre(resultSet.getString("genre"));
                    float priceReturned = resultSet.getBigDecimal("price").floatValue();
                    boolean ATPReturned = resultSet.getBoolean("ATP");
                    String stateReturned = resultSet.getString("state");
                    Series series = new Series(seriesIdReturned, titleReturned, detailReturned, releasedReturned, rateReturned, genreReturned, priceReturned, ATPReturned, stateReturned);                
                    returnedSeries = series;
                }
            }               
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            this.connectionData.disconnect();
        }
        return returnedSeries;
    }
    
    public List<Series> getAllSeries() {
    List<Series> seriesList = new ArrayList<>();
    try {
        Connection connection = this.connectionData.connect();
        CallableStatement cstmt = connection.prepareCall("{CALL getAllSeries()}");
        ResultSet resultSet = cstmt.executeQuery();

        while (resultSet.next()) {
            
            int seriesId = resultSet.getInt("idSeries");
            String title = resultSet.getString("title");
            String detail = resultSet.getString("detail");
            LocalDate released = resultSet.getDate("released").toLocalDate();
            int rate = resultSet.getInt("rate");
            Genre genre = Genre.toGenre(resultSet.getString("genre"));
            float price = resultSet.getBigDecimal("price").floatValue();
            boolean ATP = resultSet.getBoolean("ATP");
            String state = resultSet.getString("state");
            
            Series series = new Series(seriesId, title, detail, released, rate, genre, price, ATP, state);

            seriesList.add(series);
        }
        } catch (SQLException e) {
            System.out.println(e);
            seriesList = null;
        } finally {
            this.connectionData.disconnect();
        }
        return seriesList;
    }
    
    public int deleteSeries(int seriesId) {
        int deletedId = -1;
        try {
            Connection connection = this.connectionData.connect();
            CallableStatement cstmt = connection.prepareCall("{CALL deleteSeries(?, ?)}");

            cstmt.setInt(1, seriesId);
            cstmt.registerOutParameter(2, Types.INTEGER);

            cstmt.executeUpdate();
            
            deletedId = cstmt.getInt(2);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            this.connectionData.disconnect();
        }
        return deletedId;
    }
    
    public int deactivateSeries(int idSeries){
        int deactivatedSeriesId = -1;
        try{
            Connection connection = this.connectionData.connect();
            CallableStatement cstmt = connection.prepareCall("{CALL deactivateSeries(?, ?)}");
            
            cstmt.setInt(1, idSeries);
            cstmt.registerOutParameter(2, Types.INTEGER);
            
            cstmt.executeUpdate();
            
            deactivatedSeriesId = cstmt.getInt(2);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            this.connectionData.disconnect();
        }
        return deactivatedSeriesId;
    }
    
        public int activateSeries(int idSeries){
        int activatedSeriesId = -1;
        try{
            Connection connection = this.connectionData.connect();
            CallableStatement cstmt = connection.prepareCall("{CALL activateSeries(?, ?)}");
            
            cstmt.setInt(1, idSeries);
            cstmt.registerOutParameter(2, Types.INTEGER);
            
            cstmt.executeUpdate();
            
            activatedSeriesId = cstmt.getInt(2);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            this.connectionData.disconnect();
        }
        return activatedSeriesId;
    }
        
    public Series updateSeries(int idToUpdate, String newTitle, String newDetail, LocalDate newReleased, int newRate, Genre newGenre, float newPrice, boolean newATP) {
        Series updatedSeries = null;

        try {
            Connection connection = connectionData.connect();
            CallableStatement cstmt = connection.prepareCall("{CALL updateSeries(?, ?, ?, ?, ?, ?, ?, ?)}");

            cstmt.setInt(1, idToUpdate);
            cstmt.setString(2, newTitle);
            cstmt.setString(3, newDetail);
            cstmt.setDate(4, java.sql.Date.valueOf(newReleased));
            cstmt.setInt(5, newRate);
            cstmt.setString(6, newGenre.toString());
            cstmt.setBigDecimal(7, BigDecimal.valueOf(newPrice));
            cstmt.setBoolean(8, newATP);

            boolean results = cstmt.execute();

            if (results) {
                ResultSet resultSet = cstmt.getResultSet();
                if (resultSet.next()) {
                    int seriesIdReturned = resultSet.getInt("idSeries");
                    String titleReturned = resultSet.getString("title");
                    String detailReturned = resultSet.getString("detail");
                    LocalDate releasedReturned = resultSet.getDate("released").toLocalDate();
                    int rateReturned = resultSet.getInt("rate");
                    Genre genreReturned = Genre.toGenre(resultSet.getString("genre"));
                    float priceReturned = resultSet.getBigDecimal("price").floatValue();
                    boolean ATPReturned = resultSet.getBoolean("ATP");
                    String stateReturned = resultSet.getString("state");

                    updatedSeries = new Series(seriesIdReturned, titleReturned, detailReturned, releasedReturned,
                            rateReturned, genreReturned, priceReturned, ATPReturned, stateReturned);
            }
        }   
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            connectionData.disconnect();
        }

        return updatedSeries;
    }
}
