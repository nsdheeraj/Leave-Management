package com.leave.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leave.dao.SalaryDAO;
import com.leave.dto.Salarymaster;


@RestController
@RequestMapping("/SalaryMaster")
public class SalarymasterController {

	@Autowired
	SalaryDAO salaryDAO;
		
	@RequestMapping(value = "getSalary/{id}", method = RequestMethod.GET)
	public Salarymaster getClientById(@PathVariable int id) throws URISyntaxException {
		Salarymaster Salarydetail = new Salarymaster ();

		Salarydetail = salaryDAO.getSalarybyId(id);

		if (Salarydetail  != null) {
			return Salarydetail ;
		} else {
			return null;
		}
	}
	
	
	@RequestMapping(value = "/updateSalary", method = RequestMethod.POST)
	public String updateSalary(@RequestBody Salarymaster salaryMaster) {

		String response = "";
		try {
			
			salaryDAO.update(salaryMaster);
			response = "success";
		} catch (Exception ex) {
			response = ex.getMessage();
		}
		return response;
		
		
	}

	
	
	
	
	
	
}
