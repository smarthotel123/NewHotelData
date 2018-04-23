/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author AFSAR
 */
public class DbConnection {
    
    public static Connection getConnection(){
    Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/uat","root","root123");
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Connection error");
        }
    return con;
    }
    
}
