/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hotel.Controller;

import com.Hotel.Bean.EmployeeBean;
import com.Hotel.Bean.RoomBean;
import com.Hotel.DAO.RoomDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Afsar
 */
public class Rooms extends HttpServlet {
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action1=req.getParameter("action");
        //resp.getWriter().write("this is "+action1);
       switch(action1){
           case "save":
               //resp.getWriter().write("this is  save"+action1);
               save(req, resp);
               break;
           case "all":
        {
            all(req, resp);
        }
               break;
       }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session=req.getSession();
        String action1=req.getParameter("action");
        StringBuffer sb=new StringBuffer();
        
        try {
            BufferedReader reader = req.getReader();
            String line=null;
            while ((line=reader.readLine())!=null) {
                sb.append(line);
                
            }
            //resp.getWriter().write("this is from save method"+sb);
            JSONParser parser = new JSONParser();
            JSONObject joUser = null;
            try {
                joUser = (JSONObject) parser.parse(sb.toString());
                
                //out.print("hell");
                
                //resp.getWriter().write("this is "+joUser);
            } catch (Exception e) {
                e.printStackTrace();
                resp.getWriter().write("somthing wents wrong"+e);
            }
            //["roomsavedata":{"name":"sandeep"}, "roomsavedata":{"name":"afsar"}]
            JSONObject ob = new JSONObject(joUser);
            JSONArray roomjsonarray=(JSONArray) ob.get("roomsavedata");
            //JSONObject roomdata=(JSONObject)joUser.get("roomsavedata");
            //resp.getWriter().write("this is "+roomjsonarray.get(1));
            List<RoomBean> roomlistadd=new ArrayList<>();
            /*for(int i=0;i<=roomjsonarray.size();i++){
                JSONObject oo=(JSONObject) roomjsonarray.get(i);
                RoomBean roombean=new RoomBean();
                roombean.setrType((String) oo.get("rType"));
                roombean.setrNumber((String) oo.get("rNumber"));
                
                long badCount=(long) oo.get("badCount");
                roombean.setBadCount((int) badCount);
                {
                long rprice=(long) oo.get("rPrice");
                roombean.setrPrice((float) rprice);
                }
                roomlistadd.add(roombean);
            }*/
            int j=0;
            //HttpSession session=req.getSession();
            while (j<roomjsonarray.size()) {                
                JSONObject oo=(JSONObject) roomjsonarray.get(j);
                RoomBean roombean=new RoomBean();
                roombean.setrType((String) oo.get("rType"));
                roombean.setrNumber((String) oo.get("rNumber"));
                
                long badCount=(long) oo.get("badCount");
                roombean.setBadCount((int) badCount);
                {
                    
                if((Object)oo.get("rPrice") instanceof Long){
                    long rprice=(long) oo.get("rPrice");
                    roombean.setrPrice((float) rprice);
                }
                else if((Object)oo.get("rPrice") instanceof Double){
                    double rprice=(Double) oo.get("rPrice");
                    roombean.setrPrice((float) rprice);
                }
                
                
                }
                int hid=(int) session.getAttribute("hID");
                roombean.sethID(hid);
                int cratedby=(int)session.getAttribute("empID");
                roombean.setCreatedBy(cratedby);
                
                roomlistadd.add(roombean);
                j++;
                
            }
            RoomDao roomdao=new RoomDao();
            String status=roomdao.roomCheck(roomlistadd);
            if(status=="fine"){
                String addStatus=roomdao.roomAdd(roomlistadd);
                resp.getWriter().write(addStatus);
            }
            else{
                resp.getWriter().write(status);
            }
            
            try {
                
            } catch (Exception e) {
                resp.getWriter().write("hello______"+e);
            }
        } catch (Exception e) {
            resp.getWriter().write("hello"+e);
        }
        
    }

    private void all(HttpServletRequest req, HttpServletResponse resp) {
        
    }
}
