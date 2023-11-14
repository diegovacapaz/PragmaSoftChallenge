/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series.models;

import java.time.LocalDate;

/**
 *
 * @author Diego
 */
public class Series {
    private int idSeries;
    private String title;
    private String detail;
    private LocalDate released;
    private int rate;
    private String genre;
    private float price;
    private boolean ATP;
    private String state;

    public Series(int idSeries, String title, String detail, LocalDate released, int rate, String genre, float price, boolean ATP) {
        this.idSeries = idSeries;
        this.title = title.trim();
        this.detail = detail.trim();
        this.released = released;
        this.rate = rate;
        this.genre = genre.trim();
        this.price = price;
        this.ATP = ATP;
        this.state = "AC";
    }

    public int getIdSeries() {
        return this.idSeries;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDetail() {
        return this.detail;
    }

    public LocalDate getReleased() {
        return this.released;
    }

    public int getRate() {
        return this.rate;
    }

    public String getGenre() {
        return this.genre;
    }

    public float getPrice() {
        return this.price;
    }

    public boolean isATP() {
        return this.ATP;
    }

    public String getState() {
        return this.state;
    }
    
    public boolean isActive(){
        return this.state.equals("AC");
    }

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public void setDetail(String detail) {
        this.detail = detail.trim();
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setGenre(String genre) {
        this.genre = genre.trim();
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setATP(boolean ATP) {
        this.ATP = ATP;
    }
    
    public void activate(){
        this.state = "AC";
    }
    
    public void deactivate(){
        this.state = "AN";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idSeries;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Series other = (Series) obj;
        if (this.idSeries != other.idSeries) {
            return false;
        }
        return true;
    }
    
    
}
