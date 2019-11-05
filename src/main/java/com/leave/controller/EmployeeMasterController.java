package com.leave.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leave.dao.EmployeeMasterDAO;
import com.leave.dto.EmployeeMaster;

@RestController
@RequestMapping("/employee_master")
public class EmployeeMasterController {

	@Autowired
	EmployeeMasterDAO employeeMasterDao;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@RequestBody EmployeeMaster employeeMaster) {

		String response = "";
		try {
			
			employeeMasterDao.save(employeeMaster);
			response = "success";

		} catch (Exception ex) {
			response = ex.getMessage();
		}
		return response;
	}
	
	@RequestMapping(value = "viewAll", method = RequestMethod.GET)
	public List<EmployeeMaster> viewAllMeetingReq() throws URISyntaxException {
		
		List<EmployeeMaster> employeeList = new ArrayList<EmployeeMaster>();
		employeeList =  employeeMasterDao.viewAllMeetingReq();

		if (employeeList != null) {
			return employeeList;
		} else {
			return null;
		}

	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@RequestBody EmployeeMaster employeeMaster) {

		String response = "";
		try {
			
			employeeMasterDao.update(employeeMaster);
			response = "success";
		} catch (Exception ex) {
			response = ex.getMessage();
		}
		return response;
	}

	
	@RequestMapping(value = "getEmployeeByid/{id}", method = RequestMethod.GET)
	public EmployeeMaster getEmployeeByid(@PathVariable int id) throws URISyntaxException {
		EmployeeMaster Employeedetail = new EmployeeMaster();

		Employeedetail = employeeMasterDao.getEmployeebyId(id);

		if (Employeedetail != null) {
			return Employeedetail;
		} else {
			return null;
		}

	}
	
	@RequestMapping(value = "getEmployeeByname/{name}", method = RequestMethod.GET)
	public List<EmployeeMaster> getEmployeeByname(@PathVariable String name) throws URISyntaxException {
		List<EmployeeMaster> EmployeedetailList = new ArrayList<EmployeeMaster>();

		EmployeedetailList = employeeMasterDao.getEmployeeByname(name);

		if (EmployeedetailList != null) {
			return EmployeedetailList;
		} else {
			return null;
		}

	}
	
	@RequestMapping(value = "getEmployeeByDepartment/{Department}", method = RequestMethod.GET)
	public List<EmployeeMaster> getEmployeeByDepartment(@PathVariable String Department) throws URISyntaxException {
		List<EmployeeMaster> EmployeeNameList = new ArrayList<EmployeeMaster>();

		EmployeeNameList = employeeMasterDao.getEmployeeByDepartment(Department);

		if (EmployeeNameList != null) {
			return EmployeeNameList;
		} else {
			return null;
		}

	}
	
	@RequestMapping(value = "/getmaxempid", method = RequestMethod.GET)
	public List<EmployeeMaster> getempid() throws URISyntaxException {
		
		//List<EmployeeMaster> Employeedetail = new EmployeeMaster();
		List<EmployeeMaster> Employeedetail = new ArrayList<EmployeeMaster>();

		Employeedetail = employeeMasterDao.getMaxEmpid();

		if (Employeedetail != null) {
			return Employeedetail;
		} else {
			return null;
		}
		
	}
	
	
	@RequestMapping(value = "/getReportingPersonsIDByRole/{reporting_personrole}", method = RequestMethod.GET)
	public List<EmployeeMaster> getReportingPersonsIDByRole(@PathVariable String reporting_personrole) throws URISyntaxException {
		
		List<EmployeeMaster> ReportingPersonsdetail = new ArrayList<EmployeeMaster>();

		ReportingPersonsdetail = employeeMasterDao.getReportingPersonsIDByRole(reporting_personrole);

		if (ReportingPersonsdetail != null) {
			return ReportingPersonsdetail;
		} else {
			return null;
		}
		
	}
	
	@RequestMapping(value = "/getReportingPersonIDbyempid/{empid}", method = RequestMethod.GET)
	public List<EmployeeMaster> getReportingPersonsIDbyempid(@PathVariable int empid) throws URISyntaxException {
		
		List<EmployeeMaster> ReportingPersonsdetail = new ArrayList<EmployeeMaster>();

		ReportingPersonsdetail = employeeMasterDao.getReportingPersonIDbyempid(empid);

		if (ReportingPersonsdetail != null) {
			return ReportingPersonsdetail;
		} else {
			return null;
		}
		
	}
	@RequestMapping(value = "/getEmp_Mailbyempid/{Rpid}", method = RequestMethod.GET)
	public List<EmployeeMaster> getEmp_Mailbyempid(@PathVariable int Rpid) throws URISyntaxException {
		
		List<EmployeeMaster> ReportingPersonsdetail = new ArrayList<EmployeeMaster>();

		ReportingPersonsdetail = employeeMasterDao.getEmp_Mailbyempid(Rpid);

		if (ReportingPersonsdetail != null) {
			return ReportingPersonsdetail;
		} else {
			return null;
		}
		
	}

}
