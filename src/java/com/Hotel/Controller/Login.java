/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hotel.Controller;

import com.Hotel.Bean.LoginBean;
import com.Hotel.DAO.LoginDao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Afsar
 */
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //PrintWriter out=resp.getWriter();
        StringBuffer sb=new StringBuffer();
        try {
            BufferedReader reader = req.getReader();
            String line=null;
            while ((line=reader.readLine())!=null) {
                sb.append(line);
                
            }
            //out.print(sb);
            JSONParser parser = new JSONParser();
            JSONObject joUser = null;
            try {
                
                joUser = (JSONObject) parser.parse(sb.toString());
                //out.print("hell");
            } catch (Exception e) {
                e.printStackTrace();
                resp.getWriter().write("somthing wents wrong"+e);
            }
            JSONObject user=(JSONObject)joUser.get("loginData");
            String empEmail=(String)user.get("username");
            String pass=(String)user.get("password");
            
            //out.print("your input is  "+data+"  and  "+data1);
            LoginBean loginbean=new LoginBean();
            loginbean.setEmpEmail(empEmail);
            loginbean.setPassword(pass);
            LoginDao logindao=new LoginDao();
            String status=logindao.loginDataCheck(loginbean);
            if(status=="success"){
                //out.print("success");
                
                HttpSession session=req.getSession();
                session.setAttribute("hID", loginbean.gethID());
                session.setAttribute("empName", loginbean.getEmpName());
                session.setAttribute("empID", loginbean.getEmpID());
                session.setAttribute("LoginStatus", status);
                session.setAttribute("role", loginbean.getRole());
                //RequestDispatcher rd=req.getRequestDispatcher("DashboardController");
                //rd.include(req, resp);
                //resp.sendRedirect("DashboardController");
                //out.print(status);
                //out.flush();
                //out.close();
                resp.getWriter().write(status);
            }
            else{
                resp.getWriter().write(status);
                //out.print(status);
            }
            
            
        } catch (Exception e) {
            resp.getWriter().write("somthing wents wrong"+e);
            //out.print("somthing wents wrong bbb  "+e);
        }
        
    }

}
