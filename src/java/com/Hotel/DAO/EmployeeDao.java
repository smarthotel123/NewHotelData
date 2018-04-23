/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hotel.DAO;

import com.Hotel.Bean.EmployeeBean;
import com.Hotel.Connection.DbConnection;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Afsar
 */
public class EmployeeDao {
    //DbConnection db=new DbConnection();
    static Connection con=DbConnection.getConnection();
    public String addEmployee(EmployeeBean employeebean){
        String q="insert into employees (hID,empNo,empFirtsName,empLastName,empEmail,empPhone,pincode,country,state,district,city,areaName,address,role,webAccount,createdBy,joindate) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(q);
            ps.setInt(1, employeebean.gethID());
            ps.setString(2, employeebean.getEmpNo());
            ps.setString(3, employeebean.getEmpFirtsName());
            ps.setString(4, employeebean.getEmpLastName());
            ps.setString(5, employeebean.getEmpEmail());
            ps.setLong(6, employeebean.getEmpPhone());
            ps.setInt(7, employeebean.getPincode());
            ps.setString(8, employeebean.getCountry());
            ps.setString(9, employeebean.getState());
            ps.setString(10, employeebean.getDistrict());
            ps.setString(11, employeebean.getCity());
            ps.setString(12, employeebean.getAreaName());
            ps.setString(13, employeebean.getAddress());
            ps.setInt(14, employeebean.getRole());
            ps.setBoolean(15, employeebean.isWebAccount());
            ps.setInt(16, employeebean.getCreatedBy());
            ps.setString(17, employeebean.getJoindate());
            int status=ps.executeUpdate();
            
            return "Status"+status;
            
        } catch (Exception e) {
            
            return "Somthing wents wrong"+e;
            
        }
        
        
        //return "fine";
    }
    public static List<EmployeeBean> listAllEmployee(int hid)throws SQLException {
        List<EmployeeBean> listEmployee = new ArrayList<>();
        String q="select empId,empNo,CONCAT(empFirtsName,' ',empLastName)AS empName,empEmail,empPhone,pincode,role,status from employees where hID=?";
        PreparedStatement ps=con.prepareStatement(q);
        ps.setInt(1, hid);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            int Id=rs.getInt("empId");
            String empNo=rs.getString("empNo");
            String empName=rs.getString("empName");
            String empEmail=rs.getString("empEmail");
            long empPhone=rs.getLong("empPhone");
            int pincode=rs.getInt("pincode");
            int role=rs.getInt("role");
            boolean status=rs.getBoolean("status");
            EmployeeBean employeebean=new EmployeeBean(Id,empNo,empEmail,empPhone,pincode,role,empName,status);
            //Gson gsonBuilder = new GsonBuilder().create();
            //String jsonFromJavaArrayList = gsonBuilder.toJson(employeebean);
            //ObjectMapper mapper = new ObjectMapper();
            listEmployee.add(employeebean);
            
        }
        
        
        return listEmployee;
    }
    
}
