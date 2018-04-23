/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hotel.DAO;

import com.Hotel.Bean.RoomBean;
import com.Hotel.Connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Afsar
 */
public class RoomDao {
    static Connection con=DbConnection.getConnection();
    public String roomCheck(List<RoomBean> roomlistadd){
        try {
            ArrayList<String> duplicateroom=new ArrayList();
            String q="select * from rooms where rNumber=? and hID=?";
            DbConnection dbConnection=new DbConnection();
            PreparedStatement ps=con.prepareStatement(q);
            for(RoomBean roomb:roomlistadd){
                ps.setString(1, roomb.getrNumber());
                ps.setInt(2, roomb.gethID());
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    
                    duplicateroom.add(roomb.getrNumber());
                }
            }
            if(duplicateroom.size()>=1){
                String errorData="There already availabe data for room number "+duplicateroom.toString();
               return errorData;
            }
            else{
                return "fine";
            }
            
        } catch (Exception e) {
            return "error"+e;
        }
        
    }

    public String roomAdd(List<RoomBean> roomlistadd) {
        try {
            String q="insert into rooms (hID,rNumber,rType,rPrice,badCount,createdBy)values (?,?,?,?,?,?)";
            DbConnection dbConnection=new DbConnection();
            PreparedStatement ps=con.prepareStatement(q);
            
            int i = 0;
            {                
                for(RoomBean roomb:roomlistadd){
                ps.setInt(1, roomb.gethID());
                ps.setString(2, roomb.getrNumber());
                ps.setString(3, roomb.getrType());
                ps.setFloat(4, roomb.getrPrice());
                ps.setInt(5, roomb.getBadCount());
                ps.setInt(6, roomb.getCreatedBy());
                
                i=ps.executeUpdate();
            }
            } 
            if(i==1){
                return "Saved";
            }
            else{
                return "Somthing wents wrong";
            }
            
        } catch (Exception e) {
            return "error"+e;
        }
        
    }
    
}
