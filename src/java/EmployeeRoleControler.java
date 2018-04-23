/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Afsar
 */
public class EmployeeRoleControler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<EmployeeRoleBean> roledata=new ArrayList<EmployeeRoleBean>();
            //
            
            try {
                DbConnection db=new DbConnection();
                Connection con=db.getConnection();
                String q="select roleID,roleName from roledeatails";
                PreparedStatement ps=con.prepareStatement(q);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    EmployeeRoleBean emplyeerolebean=new EmployeeRoleBean();
                    emplyeerolebean.setRoleId(rs.getInt(1));
                    emplyeerolebean.setRoleName(rs.getString(2));
                    roledata.add(emplyeerolebean);
                     
          
                }
                Gson gsonBuilder = new GsonBuilder().create();
         String roledatainjson = gsonBuilder.toJson(roledata);
         //String area1=new Gson().toJson(areaName);
         //String sts=state;
         //JSONObject tomJsonObj = new JSONObject(areaName);
         resp.setContentType("text/plain");
         resp.setCharacterEncoding("UTF-8");
         resp.getWriter().write(roledatainjson);
         //resp.getWriter().write("Entered Email ID already used,Please use anoher one");
            } catch (Exception e) {
                //resp.getWriter().write(e);
            }
            
            
        } catch (Exception e) {
        }
    }


}
