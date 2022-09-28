package com.tapsCabs.pojos;




import javax.persistence.*;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote pojo representing the vehicle registered with company as cabs
 */

@Entity
@Table
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabId;
    private String regisNo;
    private String make;
    private String model;
    private String city;
    private String driverName;
    private String driverAddress;
    private String driverPhoneNumber;
    private String alternateDriverPhoneNumber;
    private String cabType;
    private String permit;
    private String status;



    public int getCabId() {
        return cabId;
    }

    public String getRegisNo() {
        return regisNo;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getCity() {
        return city;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public String getAlternateDriverPhoneNumber() {
        return alternateDriverPhoneNumber;
    }

    public String getCabType() {
        return cabType;
    }

    public String getPermit() {
        return permit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public void setRegisNo(String regisNo) {
        this.regisNo = regisNo;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    public void setAlternateDriverPhoneNumber(String alternateDriverPhoneNumber) {
        this.alternateDriverPhoneNumber = alternateDriverPhoneNumber;
    }

    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }
}
