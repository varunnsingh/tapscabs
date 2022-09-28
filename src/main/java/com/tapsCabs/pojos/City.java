package com.tapsCabs.pojos;




import javax.persistence.*;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote pojo representing the operational city
 */
@Entity
@Table
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;
    private String cityName;
    private String stateCode;
    private String state;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
