/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/**
 *
 * @author AFSAR
 */
public class TestController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
         StringBuilder sb = new StringBuilder();
         BufferedReader br = request.getReader();
         String str = null;
         while ((str = br.readLine()) != null) {
             sb.append(str);
         }
         JSONObject jObj = new JSONObject(sb.toString());
         String pincode = jObj.getString("pincode");
         
         response.setContentType("text/plain");
         response.setCharacterEncoding("UTF-8");
         response.getWriter().write("hello from java. you entered afsar: " + pincode);
     } catch (JSONException ex) {
         Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
     }
 
    }
        /*try (PrintWriter out=resp.getWriter()){
           // String pin1=req.getParameter("pincode");
            //out.print(pin1);
            HttpSession session=req.getSession();
            out.print(req.getServletPath());
            
            StringBuilder sb = new StringBuilder();
            BufferedReader br = req.getReader();
            String str = null;
            while ((str = br.readLine()) != null) {
                           sb.append(str);
            }
            JSONObject jObj = new JSONObject(sb.toString());
            String pincode = jObj.getString("pincode");
            
            
            
            
            
            DbConnection db=new DbConnection();
            Connection con=db.getConnection();
            Gson gsonBuilder = new GsonBuilder().create();
            ArrayList<String> al=new ArrayList<String>();
            try {
                String q="select AreaName from pincoderecordes where Pincode="+pincode;
                PreparedStatement ps=con.prepareStatement(q);
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()){
                    al.add(rs.getString(1));
                }
                String jsonFromJavaArrayList = gsonBuilder.toJson(al);
                resp.getWriter().write("YOUR DATA IS"+jsonFromJavaArrayList);
                
            } catch (Exception e) {
            }
            
            
        } catch (Exception e) {
        }

    }
*/
   
    
}
