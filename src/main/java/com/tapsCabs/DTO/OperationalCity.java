package com.tapsCabs.DTO;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote DTO for City pojo
 */

public class OperationalCity {
    private String cityName;

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

    private String stateCode;
    private String state;
}
