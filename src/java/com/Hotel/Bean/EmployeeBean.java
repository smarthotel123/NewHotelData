/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hotel.Bean;

import java.util.Date;

/**
 *
 * @author Afsar
 */
public class EmployeeBean {
    private int hID;
    private int empID;
    private String empNo=null;
    private String empFirtsName=null;
    private String empLastName;
    private String empEmail;
    private long empPhone;
    private int pincode;
    private String country;
    private  String state;
    private String district;
    private String city;
    private String areaName;
    private String address;
    private boolean status;
    private int role;
    private Date createdTime;
    private Date modifyTime;
    private boolean webAccount;
    private int createdBy;
    private String joindate=null;
    private String empName;

    public EmployeeBean() {
    }
    
    public EmployeeBean(int empID, String empNo, String empEmail, long empPhone, int pincode, int role, String empName,boolean status) {
        this.empID = empID;
        this.empNo = empNo;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
        this.pincode = pincode;
        this.role = role;
        this.empName = empName;
        this.status=status;
    }
    
    
    
    public int gethID() {
        return hID;
    }

    public void sethID(int hID) {
        this.hID = hID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpFirtsName() {
        return empFirtsName;
    }

    public void setEmpFirtsName(String empFirtsName) {
        this.empFirtsName = empFirtsName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public long getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(long empPhone) {
        this.empPhone = empPhone;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public boolean isWebAccount() {
        return webAccount;
    }

    public void setWebAccount(boolean webAccount) {
        this.webAccount = webAccount;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }
    
    
    
}
