package com.leave.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leave.dao.EmployeeLogsDAO;
import com.leave.dto.EmployeeLogs;

@RestController
@RequestMapping("/employee_logs")

public class EmployeeLogsController {
	
	@Autowired
	EmployeeLogsDAO employeeLogsDAO;
	
	@RequestMapping(value = "/viewLogs", method = RequestMethod.GET)
	public List<EmployeeLogs> viewEmployeeLogs() {

		List<EmployeeLogs> EmployeeLogsList = new ArrayList<EmployeeLogs>();
		try {
			
			EmployeeLogsList = employeeLogsDAO.getEmployeeLogs();
		} catch (Exception ex) {
			
		}
		return EmployeeLogsList;
	}
}
