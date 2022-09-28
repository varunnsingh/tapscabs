package com.tapsCabs.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;



/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote DTO for Cab pojo
 */
public class Taxi {

    private int id;
    @NotBlank
    private String regisNo;
    private String make;
    private String model;
    private String city;
    @NotBlank
    private String driverName;
    @NotBlank
    private String driverAddress;
    @NotBlank
    private String driverPhoneNumber;
    private String alternateDriverPhoneNumber;
    private String cabType;
    private String permit;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegisNo() {
        return regisNo;
    }

    public void setRegisNo(String regisNo) {
        this.regisNo = regisNo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    public String getAlternateDriverPhoneNumber() {
        return alternateDriverPhoneNumber;
    }

    public void setAlternateDriverPhoneNumber(String alternateDriverPhoneNumber) {
        this.alternateDriverPhoneNumber = alternateDriverPhoneNumber;
    }

    public String getCabType() {
        return cabType;
    }

    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }


}
