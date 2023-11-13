/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.time.LocalDate;

/**
 *
 * @author Diego
 */
public class Validation {
    
    //It's an example of validation class, in this case they are simple
    
    public static boolean titleValidation(String title){
        return title != null && !title.isBlank() && title.length() <= 100;
    }
    
    public static boolean detailValidation(String detail){
        return detail != null && !detail.isBlank();
    }
    
    public static boolean releasedValidation(LocalDate released){
        return released != null;
    }
    
    public static boolean rateValidation(int rate){
        return rate >= 0 && rate <= 5;
    }
    
    public static boolean genreValidation(String genre){
        return genre != null && !genre.isBlank() && genre.length() <= 100;
    }
    
    public static boolean priceValidation(float price){
        return price >= 0.0 && price <= 9999999999.99; //SQL Series Administrator database max number for that field
    }
}
