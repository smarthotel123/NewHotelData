package com.Hotel.Bean;


import java.util.ArrayList;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AFSAR
 */
public class RefAddress {

    public RefAddress() {
    }
    HashSet<String> areaName=new HashSet<String>();
    HashSet<String> city=new HashSet<>();
    HashSet<String> district=new HashSet<>();
    HashSet<String> state=new HashSet<>();

    public HashSet<String> getCity() {
        return city;
    }

    public void setCity(HashSet<String> city) {
        this.city = city;
    }

    public HashSet<String> getDistrict() {
        return district;
    }

    public void setDistrict(HashSet<String> district) {
        this.district = district;
    }

    public HashSet<String> getState() {
        return state;
    }

    public void setState(HashSet<String> state) {
        this.state = state;
    }
    
    

    public HashSet<String> getAreaName() {
        return areaName;
    }

    public void setAreaName(HashSet<String> areaName) {
        this.areaName = areaName;
    }
    
    
    
}
