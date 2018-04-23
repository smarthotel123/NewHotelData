/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hotel.DAO;

import com.Hotel.Bean.LoginDataBean;
import com.Hotel.Connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Afsar
 */
public class LoginDataDao {
    
    public void getformReg(LoginDataBean logindatabean){
        try {
            String q="select hID,oName,hEmail from hotelregistrationdata where hEmail=?";
            DbConnection db=new DbConnection();
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, logindatabean.getEmpEmail());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                //LoginDataBean logindatabean=new LoginDataBean();
                do {                    
                    logindatabean.sethID(rs.getInt(1));
                    //logindatabean.setEmpID(rs.getString(1));
                    logindatabean.setEmpName(rs.getString(2));
                    logindatabean.setEmpEmail(rs.getString(3));
                } while (rs.next());
                
            }
            con.close();
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
    }
    public void getformEmp(LoginDataBean logindatabean){
        try {
            String q="select empID from employees where empEmail=?";
            DbConnection db=new DbConnection();
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, logindatabean.getEmpEmail());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                //LoginDataBean logindatabean=new LoginDataBean();
                do {                    
                    //logindatabean.sethID(rs.getInt(1));
                    logindatabean.setEmpID(rs.getString(1));
                    //logindatabean.setEmpName(rs.getString(2));
                    //logindatabean.setEmpEmail(rs.getString(3));
                } while (rs.next());
                
            }
            con.close();
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
    }
    public String logindatatstatus(LoginDataBean logindatabean){
        int a=0;
        try {
            PassmakingDao passmakingdao=new PassmakingDao();
            String sendmailstatus=passmakingdao.genratepass(logindatabean);
            String q="insert into logindata (hID,empEmail,empName,password,empID,roleID)values(?,?,?,?,?,?)";
            DbConnection db=new DbConnection();
            Connection con=db.getConnection();
           // LoginDataBean logindatabean=new LoginDataBean();
           
            PreparedStatement ps=con.prepareStatement(q);
            ps.setInt(1,logindatabean.gethID());
            ps.setString(2, logindatabean.getEmpEmail());
            ps.setString(3, logindatabean.getEmpName());
            ps.setString(4, logindatabean.getPassword());
            ps.setString(5, logindatabean.getEmpID());
            ps.setInt(6, logindatabean.getRole());
            a=ps.executeUpdate();
            
        } catch (Exception e) {
            return "somthing happend"+e;
        }
    
    
    return "fine";
    }
}
