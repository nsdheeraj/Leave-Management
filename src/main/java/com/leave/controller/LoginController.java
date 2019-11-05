package com.leave.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leave.dao.UserDao;
import com.leave.dto.User;

@RestController
@RequestMapping("/login")
public class LoginController {
	 private static final Logger logger = Logger.getLogger(LoginController.class.getCanonicalName());
	 @Autowired
	  UserDao userDao;
	 
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	 public String login() {
	       return "login.html";
	    }
	  
	
	/* public List<User> loginProcess(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
		List<User> validUser= new ArrayList<User>();
		try {
			logger.info("login validate checking start");
			//User user1 = userDao.validateUser(user);
			User user1 = userDao.validateUser(user);
			if (null != user1) {
				validUser.add(user1);
			logger.info("login user success");
//			List<User> user2= new ArrayList<User>();
//			user2 = (List<User>) userDao.getUserdetails(user);
//		    validUser.addAll(user2);
//		    logger.info("login user success after get user details --"+user2.get(0).getUserName());
			}else {
				logger.severe("login user failed");
				//throw new Exception("User Does not exists");
			}
		 
	 }catch (Exception e) {
		 logger.severe("login validate checking exception"+e);
		//return (List<User>) e;
		 // TODO: handle exception
	}
		 return validUser; 
	}*/
	/* @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	 public boolean loginProcess(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
	boolean response1=false;
	try {
		logger.info("login validate checking start");
		response1 = (userDao.validateUser(user)) != null;
		if (response1) {
		logger.info("login user success");
		}else {
			logger.severe("login user failed");
		}
	 
 }catch (Exception e) {
	 logger.severe("login validate checking exception"+e);

}
	return response1;
}*/
		 @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	 public User loginProcess(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
			// List<User> validUserEmail= new ArrayList<User>();
			 User response1 = null;
	try {
		logger.info("login validate checking start");
		response1=userDao.validateUser(user);
		if (response1 != null) {
		logger.info("login user success");
		}else {
			logger.severe("login user failed");
		}
	 
 }catch (Exception e) {
	 logger.severe("login validate checking exception"+e);

}
	return response1;
}
	
	@RequestMapping(value = "/validMail", method = RequestMethod.POST)
	 public List<User> validMail(HttpServletRequest request, HttpServletResponse response,@RequestBody User user) {
		List<User> validUserEmail= new ArrayList<User>();
		try {
			logger.info("email validate checking start");
			User vuser = userDao.validateEmail(user);
			if (null != vuser) {
			logger.info("email valid");
			List<User> vuser2= new ArrayList<User>();
			vuser2 = (List<User>) userDao.getUserdetails(vuser);
			validUserEmail.addAll(vuser2);
			}else {
				logger.severe("email not valid");
			}
		 
	 }catch (Exception e) {
		 logger.severe("forget password exception part"+e);
		return (List<User>) e;
		 // TODO: handle exception
	}
		 return validUserEmail; 
	}
	
	
	
	@RequestMapping(value = "/changePass", method = RequestMethod.PUT)
	 public String changePass(@RequestBody User user) {
		String newPass="";
		try {
			logger.info("change password initiating");
			int user1 = userDao.changePassword(user);
			if (user1 > 0) {
				newPass= "Updated";
				logger.info("password updated successfully");
			}else {
				logger.severe("password not updated");
				newPass= "Not Updated";
			}
		}catch (Exception e) {
			logger.severe("Change password exception"+e);
			newPass= "Not Updated";
		 // TODO: handle exception
		}
		return newPass;
	}
}
	
