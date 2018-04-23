/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hotel.DAO;

import com.Hotel.Bean.LoginBean;
import com.Hotel.Connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDao {
    
    public String loginDataCheck(LoginBean loginbean){
        try {
            String q="select hID,empEmail,empName,empID,roleID from logindata where empEmail=? and password=?";
            DbConnection db=new DbConnection();
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, loginbean.getEmpEmail());
            ps.setString(2, loginbean.getPassword());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                do {                    
                    loginbean.sethID(rs.getInt(1));
                    loginbean.setEmpEmail(rs.getString(2));
                    loginbean.setEmpName(rs.getString(3));
                    loginbean.setEmpID(rs.getInt(4));
                    loginbean.setRole(rs.getInt(5));
                } while (rs.next());
                 return "success";
                
            }
            else{
                return "Username and password is wrong";
            }
                 
        } catch (Exception e) {
             return "Somthing wents wrong";
        }
        
        
       
    }
    
}
