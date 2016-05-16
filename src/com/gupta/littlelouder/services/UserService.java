package com.gupta.littlelouder.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gupta.littlelouder.services.bean.User;
import com.gupta.littlelouder.services.json.ConfirmationJSON;
import com.gupta.littlelouder.services.json.LoginJSON;
import com.gupta.littlelouder.services.mail.EmailSendingServlet;
import com.gupta.littlelouder.services.mail.MailThread;
import com.gupta.littlelouder.services.model.UserData;

@Path("user")
public class UserService {
	
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response login(
			@QueryParam("email") String email, 
			@QueryParam("password") String password) {
		
		String send = "";
		
		User user = null;
		user = new UserData().checkLogin(email, password);
		
		if(user == null) {
			user = new User();
			user.setUserId(0);
			send = new LoginJSON().constructJSON(user, false);
		}
		else {
			send = new LoginJSON().constructJSON(user, true);
		}
		
		return Response.ok(send).header("Access-Control-Allow-Origin", "*").build();
		
	}
	
	@POST
	@Path("signup")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response signUp(
			@QueryParam("name") String name, 
			@QueryParam("email") String email, 
			@QueryParam("phone") String phone, 
			@QueryParam("password") String password) {
		
		String send = "";
		User user = new User(name, email, phone, password);
		int userId = new UserData().validateUser(user.getEmail());		
		
		if(userId != 0) {
			user.setUserId(0);
			send = new LoginJSON().constructJSON(user, false);
			//send = new ConfirmationJSON().contructJSON("SignUp", "true");
		}
		else {
			new UserData().newUser(user);
			user = new UserData().checkLogin(email, password);
			send = new LoginJSON().constructJSON(user, true);
			//send = new ConfirmationJSON().contructJSON("SignUp", "false");			
		}
		
		return Response.ok(send).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@POST
	@Path("forget")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response forget(
			@QueryParam("email") String email) {
		String send = "";
		String password = "";
		EmailSendingServlet mail =new EmailSendingServlet();
		
		int userId = new UserData().validateUser(email);
		
		if(userId != 0) {
			//new UserData().newUser(user);
			password = new UserData().validatePassword(userId);

			String recipient = email;
			String subject = "Password Recovered";
			String content = "Dear User,\n\nYour password has been recovered\nEmail : "+email+"\nPassword : "+password;
			
			mail.setRecipient(recipient);
			mail.setSubject(subject);
			mail.setContent(content);
			
			MailThread sendMail = new MailThread(mail);
			sendMail.start();
								
			send = new ConfirmationJSON().contructJSON("Forget", "true");
		}
		else {
			send = new ConfirmationJSON().contructJSON("Forget", "false");			
		}
		
		return Response.ok(send).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@POST
	@Path("changepassword")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response changePassword(
			@QueryParam("userid") String uid,
			@QueryParam("password") String password) {
		
		String send = "";
		int userId = Integer.parseInt(uid);
		
		if(userId != 0) {
			
			new UserData().changeOldPassword(userId, password);
								
			send = new ConfirmationJSON().contructJSON("Change", "true");
		}
		else {
			send = new ConfirmationJSON().contructJSON("Change", "false");			
		}
		
		return Response.ok(send).header("Access-Control-Allow-Origin", "*").build();
	}
	

}
