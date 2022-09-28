package com.tapsCabs.pojos;

import javax.persistence.*;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote Pojo representing booking info provided by user
 */
@Entity
@Table
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private int userId;
    private String passengerName;
    private String passengerNumber;
    private String pickUpAddress;
    private String dropAddress;
    private int price;
    private int distance;
    private String tripStatus;
    private String pickupDateTime;
    private String tripType;
    private String cabType;
    private String paymentStatus;
    private String bookingDate;

    public Booking() {
    }

   public Booking(Builder bookingBuilder){
        this.userId = bookingBuilder.userId;
        this.passengerName = bookingBuilder.passengerName;
        this.passengerNumber = bookingBuilder.passengerNumber;
        this.pickUpAddress = bookingBuilder.pickUpAddress;
        this.dropAddress = bookingBuilder.dropAddress;
        this.price = bookingBuilder.price;
        this.distance = bookingBuilder.distance;
        this.tripStatus = bookingBuilder.tripStatus;
        this.pickupDateTime = bookingBuilder.pickupDateTime;
        this.tripType = bookingBuilder.tripType;
        this.cabType = bookingBuilder.cabType;
        this.paymentStatus = bookingBuilder.paymentStatus;
        this.bookingDate = bookingBuilder.bookingDate;
    }


    public int getBookingId() {
        return bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public String getDropAddress() {
        return dropAddress;
    }

    public int getPrice() {
        return price;
    }

    public int getDistance() {
        return distance;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public String getPickupDateTime() {
        return pickupDateTime;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getTripType() {
        return tripType;
    }

    public String getCabType() {
        return cabType;
    }

    public String isPaymentStatus() {
        return paymentStatus;
    }

    public String getBookingDate() {
        return bookingDate;
    }


    public static class Builder{
        private int userId;
        private String passengerName;
        private String passengerNumber;
        private String pickUpAddress;
        private String dropAddress;
        private int price;
        private int distance;
        private String tripStatus;
        private String pickupDateTime;
        private String tripType;
        private String cabType;
        private String paymentStatus;
        private String bookingDate;

        public Builder(String passengerNumber, String pickAddress,String dropAddress){
            this.passengerNumber = passengerNumber;
            this.pickUpAddress = pickAddress;
            this.dropAddress = dropAddress;
        }



        public Builder userId(int userId){
            this.userId = userId;
            return this;
        }
        public Builder passengerName(String passengerName){
            this.passengerName = passengerName;
            return this;
        }
        public Builder price(int price){
            this.price = price;
            return this;
        }

        public Builder distance(int distance){
            this.distance = distance;
            return this;
        }
        public Builder tripStatus(String tripStatus){
            this.tripStatus = tripStatus;
            return this;
        }
        public Builder pickupDateTime(String pickupDateTime){
            this.pickupDateTime = pickupDateTime;
            return this;
        }
        public Builder tripType(String tripType){
            this.tripType = tripType;
            return this;
        }
        public Builder cabType(String cabType){
            this.cabType = cabType;
            return this;
        }
        public Builder paymentStatus(String paymentStatus){
            this.paymentStatus = paymentStatus;
            return this;
        }
        public Builder bookingDate(String bookingDate){
            this.bookingDate = bookingDate;
            return this;
        }
         public Booking build(){
          return new Booking(this);
                  }

    }


}
