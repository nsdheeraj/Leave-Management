package com.leave.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.leave.dao.CreditsDAO;
import com.leave.dto.Credits;
import com.leave.dto.EmployeeLogin;

@RestController
@RequestMapping("/credits")

public class CreditsController {
	@Autowired
	CreditsDAO CreditsDAO;
	
	@RequestMapping(value = "/updateCredits", method = RequestMethod.POST)
	public boolean updateCredits(@RequestBody Credits updateCredits) {

		boolean response=false;
		try {
			response=CreditsDAO.update(updateCredits);
		} catch (Exception ex) {
			
		}
		
		return response;
	}

	@RequestMapping(value = "/viewCredits", method = RequestMethod.GET)
	public List<Credits> viewLeaves() {

		List<Credits> LeavesList = new ArrayList<Credits>();
		try {
			
			LeavesList =CreditsDAO.viewLeaves();
		} catch (Exception ex) {
			
		}
		
		return LeavesList;
	}
	@RequestMapping(value = "/insertCredits", method = RequestMethod.POST)
	public boolean logindetails(@RequestBody Credits updateCredits) {

		boolean response=false;
		try {
			
		 response=CreditsDAO.save(updateCredits);
		 
		} catch (Exception ex) {
			//response = ex.getMessage();
		}
		return response;
	}
}

