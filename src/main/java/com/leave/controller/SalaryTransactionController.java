package com.leave.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leave.dao.SalarytransactionDao;
import com.leave.dto.SalaryTransaction;

@RestController
@RequestMapping("/salaryTransaction")
public class SalaryTransactionController {
	
	@Autowired
	SalarytransactionDao salarytransactionDao;
	
	@RequestMapping(value = "getSalaryTransaction/{id}", method = RequestMethod.GET)
	public SalaryTransaction getClientById(@PathVariable int id) throws URISyntaxException {
		SalaryTransaction salarytransactiondetail = new SalaryTransaction();

		salarytransactiondetail = salarytransactionDao.getsalarytransactionbyId(id);

		if (salarytransactiondetail != null) {
			return salarytransactiondetail;
		} else {
			return null;
		}

	}
	
	@RequestMapping(value = "/updateSalaryTransaction", method = RequestMethod.POST)
	public String updateEmployee(@RequestBody SalaryTransaction salaryTransaction) {

		String response = "";
		try {
			
			salarytransactionDao.update(salaryTransaction);
			response = "success";
		} catch (Exception ex) {
			response = ex.getMessage();
		}
		return response;
	}
	

}
