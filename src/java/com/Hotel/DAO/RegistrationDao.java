/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hotel.DAO;

import com.Hotel.Bean.RegistrationBean;
import com.Hotel.Connection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class RegistrationDao {
    
    //RegistrationBean registrationbean=new RegistrationBean();
    DbConnection db=new DbConnection();
    Connection con=db.getConnection();
    //String q="insert into hotelregistrationdata(hName,oName,hPhone,hEmail,pincode,state,district,city,areaName) VALUES(?,?,?,?,?,?,?,?,?)";
    
    public int hotelID(RegistrationBean registrationbean){
        int a=0;
        try {
            String q="insert into hotelregistrationdata (hName,oName,hPhone,oPhone,hEmail,pincode,state,district,city,areaName) VALUES (?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, registrationbean.gethName());
            ps.setString(2, registrationbean.gethOwner());
            ps.setLong(3,  registrationbean.gethNumber());
            ps.setLong(4,  registrationbean.getoNumber());
            ps.setString(5, registrationbean.gethEmail());
            ps.setInt(6, registrationbean.gethPincode());
            ps.setString(7,registrationbean.gethState());
            ps.setString(8, registrationbean.gethDistrict());
            ps.setString(9, registrationbean.gethCity());
            ps.setString(10, registrationbean.gethAreaName());
            // a=(int) registrationbean.getoNumber();
             
            a=ps.executeUpdate();
            con.close();
            ps.close();
            
            
        } catch (Exception e) {
             
        }
        
        return a;
    }
    
}
