/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.views;

import java.time.LocalDate;
import series.models.SeriesManager;

/**
 *
 * @author Diego
 */
public class MainWindow {
    public static void main(String[] args) {
        //I have not deleted de comments in main branch because this is a test
        
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
        
        String message3 = manager.createSeries("Peter Pan", "  D", LocalDate.of(2020, 1, 25), 0, "Drama", 2000.01f, true);
        System.out.println(message3);
    }
}
