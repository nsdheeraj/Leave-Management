package com.leave.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leave.dao.EmployeeLoginDAO;
import com.leave.dto.EmployeeLogin;
//import com.leave.dto.LeaveRequests;

@RestController
@RequestMapping("/employee_login")

public class EmployeeLoginController {
	
	@Autowired
	EmployeeLoginDAO employeeLoginDAO;
	
	@RequestMapping(value = "/viewEmployees", method = RequestMethod.GET)
	public List<EmployeeLogin> viewEmployees() {

		List<EmployeeLogin> EmployeeLoginList = new ArrayList<EmployeeLogin>();
		try {
			
			EmployeeLoginList = employeeLoginDAO.getEmployeeLoginDetails();
		} catch (Exception ex) {
			
		}
		
		return EmployeeLoginList;
	}
	@RequestMapping(value = "/logindetails", method = RequestMethod.POST)
	public boolean logindetails(@RequestBody EmployeeLogin employeeLogin) {

		boolean response=false;
		try {
			
		 response=employeeLoginDAO.save(employeeLogin);
		 
		} catch (Exception ex) {
			//response = ex.getMessage();
		}
		return response;
	}

}

