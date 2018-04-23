/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonArray;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
 
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.json.JSONObject;

/**
 *
 * @author AFSAR
 */
public class Test1 extends HttpServlet {
    
    //private static final long serialVersionUID = 1L;
  //  private static final Logger logger = LogManager.getLogger(Test1.class);
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     try {
         StringBuilder sb = new StringBuilder();
         BufferedReader br = request.getReader();
         String str = null;
         while ((str = br.readLine()) != null) {
             sb.append(str);
         }
         JSONObject jObj = new JSONObject(sb.toString());
         int Pincode = jObj.getInt("name");
         //String email = jObj.getString("email");
        // String state = null;
         //response.getWriter().write("hello error data bhai"+Pincode);
         DbConnection db=new DbConnection();
         Connection con=db.getConnection();
         //str="afsar bhai ";
                     HashSet<String> areaName=new HashSet<>();
         HashSet<String> city=new HashSet<>();
         HashSet<String> district=new HashSet<>();
         HashSet<String> state=new HashSet<>();
         //HashMap<String,String> areaName=new HashMap<>();
         try {
                String q="select  AreaName,City,District,State from pincodedata where Pincode=?";
                PreparedStatement ps=con.prepareStatement(q);
                ps.setInt(1, Pincode);
                ResultSet rs=ps.executeQuery();
                RefAddress refAddress=new RefAddress();
                if(rs.next()){
                do{
                    areaName.add(rs.getString(1));
                    city.add(rs.getString(2));
                    district.add(rs.getString(3));
                    state.add(rs.getString(4));
                    
                }while(rs.next());}
                
                
                refAddress.setAreaName(areaName);
                refAddress.setCity(city);
                refAddress.setDistrict(district);
                refAddress.setState(state);
                Gson gsonBuilder = new GsonBuilder().create();
         String jsonFromJavaArrayList = gsonBuilder.toJson(refAddress);
         //String area1=new Gson().toJson(areaName);
         //String sts=state;
         //JSONObject tomJsonObj = new JSONObject(areaName);
         response.setContentType("text/plain");
         response.setCharacterEncoding("UTF-8");
         response.getWriter().write(jsonFromJavaArrayList);
         } catch (Exception e) {
             response.setContentType("text/plain");
         response.setCharacterEncoding("UTF-8");
         response.getWriter().write("hello error data " +e);
         }
         
         
         
         
         
     } catch (JSONException ex) {
         Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
         response.setContentType("text/plain");
         response.setCharacterEncoding("UTF-8");
         response.getWriter().write("hello error .........." +ex);
     }
 
    }

    
}
