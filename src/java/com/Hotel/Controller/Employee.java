/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hotel.Controller;

import com.Hotel.Bean.EmployeeBean;
import com.Hotel.Bean.LoginDataBean;
import com.Hotel.DAO.EmployeeDao;
import com.Hotel.DAO.LoginDataDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.inject.Produces;
import javax.ws.rs.core.MediaType;
import jxl.Workbook;
import jxl.format.CellFormat;
import static jxl.format.Colour.BLUE;
import static jxl.format.Colour.DARK_YELLOW;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Afsar
 */
public class Employee extends HttpServlet {

    @Override
    public void init() throws ServletException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    

   
    
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
            try {
                all(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
               break;
            case "import":
                empImport(req, resp);
                
                break;
            case "demodownload":
                demoDownload(req, resp);
                break;
             
       }
    }
    public  void save(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
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
            } catch (Exception e) {
                e.printStackTrace();
                resp.getWriter().write("somthing wents wrong"+e);
            }
            //resp.getWriter().write("this is from save method"+joUser);
            EmployeeBean employeebean=new EmployeeBean();
            JSONObject employedata=(JSONObject)joUser.get("employeesavedata");
            boolean loginaccess=(boolean)employedata.get("loginaccess");
            //resp.getWriter().write("this is from save method"+loginaccess);
            employeebean.setJoindate((String)employedata.get("joindate"));
            
                employeebean.setEmpFirtsName((String)employedata.get("firstName"));
                employeebean.setEmpLastName((String)employedata.get("lastName"));
                employeebean.setEmpNo((String)employedata.get("empNo"));
                //employeebean.setEmpPhone((long)employedata.get("empPhone"));
                employeebean.setEmpPhone(Long.parseLong((String) employedata.get("empPhone")));
                
                employeebean.setWebAccount(loginaccess);
                employeebean.setEmpEmail((String)employedata.get("empEmail"));
                String role=(String) employedata.get("role");
                employeebean.setRole(Integer.parseInt(role));
                //employeebean.setRole((String)employedata.get("role"));
                //long pin=(long) employedata.get("pincode");
                long pin=Long.parseLong((String) employedata.get("pincode"));
                employeebean.setPincode((int)pin);
                employeebean.setCountry((String)employedata.get("country"));
                employeebean.setState((String)employedata.get("state"));
                employeebean.setDistrict((String)employedata.get("district"));
                employeebean.setCity((String)employedata.get("city"));
                employeebean.setAreaName((String)employedata.get("areaName"));
                employeebean.setAddress((String)employedata.get("address"));
                //resp.getWriter().write("this is from save method"+employeebean.getPincode());
                int hid=(int) session.getAttribute("hID");
                employeebean.sethID(hid);
                int cratedby=(int)session.getAttribute("empID");
                employeebean.setCreatedBy((int) session.getAttribute("empID"));
                //resp.getWriter().write("this is from save method"+employeebean.getCreatedBy());
                
            if(loginaccess == true){
                EmployeeDao employeedao=new EmployeeDao();
                String sts=employeedao.addEmployee(employeebean);
                
                if("Status1".equals(sts)){
                    LoginDataBean logindatabean=new LoginDataBean();
                    logindatabean.setEmpEmail(employeebean.getEmpEmail());
                    logindatabean.sethID(employeebean.gethID());
                    logindatabean.setRole(employeebean.getRole());
                    String empName=employeebean.getEmpFirtsName()+" "+employeebean.getEmpLastName();
                    logindatabean.setEmpName(empName);
                    LoginDataDao logindatadao=new LoginDataDao();
                    logindatadao.getformEmp(logindatabean);
                    String a=logindatadao.logindatatstatus(logindatabean);
                    resp.getWriter().write(sts);
                }
                
                
            }
            else{
                EmployeeDao employeedao=new EmployeeDao();
                String sts=employeedao.addEmployee(employeebean);
                resp.getWriter().write(sts);
                
            }
            
        } catch (Exception e) {
        }
    }
    public void all(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException, SQLException{
        
        HttpSession session=req.getSession();
        String action1=req.getParameter("action");
        StringBuffer sb=new StringBuffer();
        //resp.getWriter().write(action1);
        int hid=(int) session.getAttribute("hID");
        //List<EmployeeBean> employeelist=EmployeeDao.listAllEmployee(hid);
        List<EmployeeBean> listEmployees = EmployeeDao.listAllEmployee(hid);
        PrintWriter out=resp.getWriter();
        
        //JSONArray arr_strJson = new JSONArray(Arrays.asList(listEmployees));
        //out.print(arr_strJson.toString());
        //System.out.println(arr_strJson.toString());
        //resp.getWriter().write(arr_strJson.toString());
        Gson gson=new Gson();
        Type type=new TypeToken <List<EmployeeBean>>() {}.getType();
        String json=gson.toJson(listEmployees, type);
        resp.getWriter().write(json);
        
    }
    
    public void empImport(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        String action1=req.getParameter("action");
        //String fileName=file.getOriginalFilename();
        System.out.println("com.Hotel.Controller.Employee.empImport()");
        resp.getWriter().write("this is from save................. method"+action1);
        
    }
    public void demoDownload(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
       
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        BufferedReader reader = req.getReader();
        
        //resp.getWriter().write("this is  "+reader);
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
        String strDate= formatter.format(date); 
        resp.setContentType("application/vnd.ms-excel");
        resp.setHeader("Content-Disposition", "inline; filename="+ "Employee "+strDate+".xls");
        WritableWorkbook w=Workbook.createWorkbook(resp.getOutputStream());
        WritableCellFormat cFormat = new WritableCellFormat();
        WritableFont times10ptBoldUnderline = new WritableFont(
                WritableFont.TIMES, 10, WritableFont.BOLD);
        cFormat.setFont(times10ptBoldUnderline);
        try {
            cFormat.setBackground(DARK_YELLOW);
        } catch (WriteException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        WritableSheet s=w.createSheet("Employee", 0);
        try {
            
            s.addCell(new Label(0, 0, "empFirstName *", cFormat));
            s.addCell(new Label(1, 0, "empLastName *", cFormat));
            s.addCell(new Label(2, 0, "empNo", cFormat));
            s.addCell(new Label(3, 0, "webAccount", cFormat));
            s.addCell(new Label(4, 0, "empEmail", cFormat));
            s.addCell(new Label(5, 0, "empPhone *", cFormat));
            s.addCell(new Label(6, 0, "pincode or Zipcode *", cFormat));
            s.addCell(new Label(7, 0, "country *", cFormat));
            s.addCell(new Label(8, 0, "state", cFormat));
            s.addCell(new Label(9, 0, "district", cFormat));
            s.addCell(new Label(10, 0, "city", cFormat));
            s.addCell(new Label(11, 0, "areaName *", cFormat));
            s.addCell(new Label(12, 0, "address", cFormat));
            s.addCell(new Label(13, 0, "role *", cFormat));
            s.addCell(new Label(14, 0, "joindate", cFormat));
            
        } catch (WriteException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        w.write();
        try {
            w.close();
        } catch (WriteException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
} 
    

}
