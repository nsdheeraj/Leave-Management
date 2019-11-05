package com.leave.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leave.dao.LeaveRequestsDAO;
import com.leave.dto.LeaveRequests;

@RestController
@RequestMapping("/employee_leave_requests")

public class LeaveRequestsController 
{
	@Autowired
	LeaveRequestsDAO leaveRequestsDAO;
	
	@RequestMapping(value = "/viewLeaveRequests", method = RequestMethod.GET)
	public List<LeaveRequests> viewLeaveRequests(){

		List<LeaveRequests> leaveRequestsList = new ArrayList<LeaveRequests>();
		try {
			
			leaveRequestsList = leaveRequestsDAO.getLeaveRequestsDetails();
		} catch (Exception ex) {
			
		}
		if ( leaveRequestsList != null) {
			return  leaveRequestsList;
		} else {
			return null;
		}
		//return leaveRequestsList;
	}

	@RequestMapping(value = "/addLeaveRequests", method = RequestMethod.POST)
	public boolean addLeaveRequests(@RequestBody LeaveRequests leaveRequests) {

		boolean response=false;
		try {
			
			response = leaveRequestsDAO.save(leaveRequests);
		 
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/updateLeaveRequests", method = RequestMethod.POST)
	public boolean updateLeaveRequests( @RequestBody LeaveRequests leaveRequests) {

		boolean response=false;
		try {	
		 response = leaveRequestsDAO.update(leaveRequests);
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		return response;
	}

	/*@RequestMapping(value = "/updateTypeOfLeave", method = RequestMethod.POST)
	public boolean updateTypeOfLeave( @RequestBody LeaveRequests leave) {

		boolean response=false;
		try {	
		 response = leaveRequestsDAO.update(leave);
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		return response;
	}*/
}
