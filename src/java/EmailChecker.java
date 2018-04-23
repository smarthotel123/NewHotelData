/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Afsar
 */
public class EmailChecker extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
         StringBuilder sb = new StringBuilder();
         BufferedReader br = req.getReader();
         String str = null;
         while ((str = br.readLine()) != null) {
             sb.append(str);
         }
         JSONObject jObj = new JSONObject(sb.toString());
         String email = jObj.getString("name");
         //String email = jObj.getString("email");
        // String state = null;
         //resp.getWriter().write("hello error"+sb);
         DbConnection db=new DbConnection();
         Connection con=db.getConnection();
         //str="afsar bhai ";
         if(email!=null){
             String q="select hID from logindata where empEmail=?";
             
             try {
                PreparedStatement ps = con.prepareStatement(q);
                 ps.setString(1, email);
                 ResultSet rs=ps.executeQuery();
                 if(rs.next()){
                     resp.getWriter().write("Entered Email ID already used,Please use anoher one");
                 }
                 else{
                     resp.getWriter().write("Fine");
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
             }
            
             
         }
         else{
             resp.getWriter().write("please enter email id from server");
         }
        
         
         
     } catch (JSONException ex) {
         Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
         resp.setContentType("text/plain");
         resp.setCharacterEncoding("UTF-8");
         resp.getWriter().write("hello error " +ex);
     }
 
    }
}
