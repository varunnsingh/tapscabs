package com.tapsCabs.DTO;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote DTO for TaxiFare pojo
 */

public class CabCategory {
    private String carCategory;
    private String sampleCarName;
    private float price;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    private String distance;
    private String duration;



    public String getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(String carCategory) {
        this.carCategory = carCategory;
    }

    public String getSampleCarName() {
        return sampleCarName;
    }

    public void setSampleCarName(String sampleCarName) {
        this.sampleCarName = sampleCarName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
