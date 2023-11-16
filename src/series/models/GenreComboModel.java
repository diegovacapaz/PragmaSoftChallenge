/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.models;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Diego
 */
public class GenreComboModel extends DefaultComboBoxModel{

    public GenreComboModel() {
        for(Genre genre : Genre.values()){
            this.addElement(genre);
        }
    }
    
    public Genre getGenre(){
        return (Genre)this.getSelectedItem();
    }
    
    public enum Genre {
        ACTION("Acción"),
        HORROR("Terror"),
        COMEDY("Comedia"),
        DRAMA("Drama"),
        FANTASY("Fantasía"),
        MYSTERY("Misterio"),
        SCI_FI("Ciencia Ficción");

        private String value;

        private Genre(String value){
            this.value=value;
        }

        public String toString() {
            return this.value;
        }
        
        public static Genre toGenre(String value){
            Genre genre = null;
            switch(value){
                case "Acción":
                    genre = ACTION;
                    break;
                case "Terror":
                    genre = HORROR;
                    break;
                case "Comedia":
                    genre = COMEDY;
                    break;
                case "Drama":
                    genre = DRAMA;
                    break;
                case "Fantasía":
                    genre = FANTASY;
                    break;
                case "Misterio":
                    genre = MYSTERY;
                    break;
                case "Ciencia Ficción":
                    genre = SCI_FI;
                    break;
                default:
                    break;
            }
            return genre;
        }
    }
}
