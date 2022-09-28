package com.tapsCabs.pojos;




import javax.persistence.*;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote pojo representing the types of cab available and their standard rates
 */
@Entity
@Table
public class TaxiFare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String carCategory;
    private String sampleCarName;
    private float price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
