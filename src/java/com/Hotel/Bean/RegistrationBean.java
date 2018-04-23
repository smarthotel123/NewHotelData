/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hotel.Bean;

import java.util.Date;

/**
 *
 * @author AFSAR
 */
public class RegistrationBean {
   private int hID;
   private String hName;
   private String hEmail;
   private String hOwner;
   private long hNumber;
   private long oNumber;
   private String hAreaName;
   private String hCity;
   private String hDistrict;
   private String hState;
   private int hPincode;
   private Date createdTime;

    public RegistrationBean() {
    }

    

    public int gethID() {
        return hID;
    }

    public void sethID(int hID) {
        this.hID = hID;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public String gethEmail() {
        return hEmail;
    }

    public void sethEmail(String hEmail) {
        this.hEmail = hEmail;
    }

    public String gethOwner() {
        return hOwner;
    }

    public void sethOwner(String hOwner) {
        this.hOwner = hOwner;
    }

    public long gethNumber() {
        return hNumber;
    }

    public void sethNumber(long hNumber) {
        this.hNumber = hNumber;
    }

    public long getoNumber() {
        return oNumber;
    }

    public void setoNumber(long oNumber) {
        this.oNumber = oNumber;
    }

    public String gethAreaName() {
        return hAreaName;
    }

    public void sethAreaName(String hAreaName) {
        this.hAreaName = hAreaName;
    }

    public String gethCity() {
        return hCity;
    }

    public void sethCity(String hCity) {
        this.hCity = hCity;
    }

    public String gethDistrict() {
        return hDistrict;
    }

    public void sethDistrict(String hDistrict) {
        this.hDistrict = hDistrict;
    }

    public String gethState() {
        return hState;
    }

    public void sethState(String hState) {
        this.hState = hState;
    }

    public int gethPincode() {
        return hPincode;
    }

    public void sethPincode(int hPincode) {
        this.hPincode = hPincode;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
   
    
}
