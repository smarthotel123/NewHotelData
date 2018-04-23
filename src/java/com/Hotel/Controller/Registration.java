/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hotel.Controller;
import com.Hotel.Bean.EmployeeBean;
import com.Hotel.DAO.PassmakingDao;
import com.Hotel.Bean.LoginDataBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.Hotel.Bean.RegistrationBean;
import com.Hotel.Connection.DbConnection;
import com.Hotel.DAO.EmployeeDao;
import com.Hotel.DAO.LoginDataDao;
import com.Hotel.DAO.RegistrationDao;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author AFSAR
 */
public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String hName=req.getParameter("areaName");
        RegistrationBean registrationbean  = new RegistrationBean();
        registrationbean.sethName(req.getParameter("hName"));
        registrationbean.sethOwner(req.getParameter("oName"));
        registrationbean.sethNumber(Long.parseLong(req.getParameter("hPhone")));
        registrationbean.setoNumber(Long.parseLong(req.getParameter("oPhone")));
        registrationbean.sethEmail(req.getParameter("hEmail"));
        registrationbean.sethPincode(Integer.parseInt(req.getParameter("pin")));
        registrationbean.sethAreaName(req.getParameter("areaName"));
        registrationbean.sethState(req.getParameter("state"));
        registrationbean.sethDistrict(req.getParameter("district"));
        registrationbean.sethCity(req.getParameter("city"));
        
        out.print("hello");
        RegistrationDao registraiondao=new RegistrationDao(); 
        int regStatu=registraiondao.hotelID(registrationbean);
        //registraiondao.hotelID(registrationbean);
        out.print(regStatu);
        if(regStatu==1){
            EmployeeBean employeebean=new EmployeeBean();
            employeebean.setEmpFirtsName(registrationbean.gethName());
            employeebean.setEmpLastName(registrationbean.gethOwner());
            employeebean.setEmpPhone(registrationbean.gethNumber());
            employeebean.setPincode(registrationbean.gethPincode());
            employeebean.setCountry("INDIA");
            employeebean.setState(registrationbean.gethState());
            employeebean.setDistrict(registrationbean.gethDistrict());
            employeebean.setCity(registrationbean.gethCity());
            employeebean.setAreaName(registrationbean.gethAreaName());
            employeebean.setCreatedBy(0);
            employeebean.setEmpEmail(registrationbean.gethEmail());
            employeebean.setWebAccount(true);
            employeebean.setRole(9);
            
            LoginDataBean logindatabean=new LoginDataBean();
            //logindatabean.setPassword(req.getParameter("hpassword"));
            logindatabean.setEmpEmail(req.getParameter("hEmail"));
            logindatabean.setRole(9);
            LoginDataDao logindatadao=new LoginDataDao();
            
            logindatadao.getformReg(logindatabean);
            EmployeeDao employeedao=new EmployeeDao();
            employeebean.sethID(logindatabean.gethID());
            String status=employeedao.addEmployee(employeebean);
            
            logindatadao.getformEmp(logindatabean);
            //PassmakingDao passmakingdao=new PassmakingDao();
            //String sendmailstatus=passmakingdao.genratepass(logindatabean);
            String a=logindatadao.logindatatstatus(logindatabean);
            
            out.print(status);
            out.print(a);
            if(a=="fine"){
                //HttpSession session = req.getSession();
                //session.setMaxInactiveInterval(0);
                //session.setAttribute("status", "Please check your mail inbox for password");
                //RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
                //rd.forward(req, resp);
                
                resp.sendRedirect("Login.jsp");
            }
        }
        
        
        
        
    }
}