package com.Hotel.DAO;


import GenPackage.MyStringRandomGen;
import com.Hotel.Bean.LoginDataBean;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afsar
 */
public class PassmakingDao {
    
   public String genratepass(LoginDataBean logindatabean){
       final String username = "mailt724@gmail.com";
		final String password = "mailt724@";
                String tomail=logindatabean.getEmpEmail();
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			MyStringRandomGen msr = new MyStringRandomGen();
                        String password1=msr.generateRandomString();
                        logindatabean.setPassword(password1);
                        int hotel_id=logindatabean.gethID();
                        String login_id=logindatabean.getEmpEmail();
                        //String password1="hellobhaipasswordhey";
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("mailt724@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(tomail));
			message.setSubject("Welcome to Smart Hotel");
			/*message.setText("your Hotel Id is "+hotel_id+
                                "\n\n"+
                                "\n\n Your login password is "
				+"<h1>" +password1+"</h1>");*/
                        message.setContent("<h3>Dear User, This mail for your email verification,Please find below password and your Hotel_ID</h3><p>Hotel_ID:-<b>"
                                +hotel_id+"</b><p><p>Login ID:-<b>"+login_id+"</b><p><p>Password:-<b>"+password1+"</b><p>","text/html" );
			Transport.send(message);

			System.out.println("Done");
                        return "Done";
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
       
   }
    
}
