package com.leave.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leave.dao.WorkedunitsDAO;
import com.leave.dto.Workedunits;

@RestController
@RequestMapping("/WorkedUnits")
public class WorkedunitsController {
  
	
	@Autowired
	WorkedunitsDAO workedunitsDAO;
		
	@RequestMapping(value = "getWorkedunits/{id}/{currentmonth}", method = RequestMethod.GET)
	public Workedunits getClientById(@PathVariable int id ,@PathVariable String currentmonth) throws URISyntaxException {
		Workedunits Workedunitsdetail = new Workedunits();

		Workedunitsdetail = workedunitsDAO.getWorkedunitsbyId(id,currentmonth);

		if (Workedunitsdetail  != null) {
			return Workedunitsdetail ;
		} else {
			return null;
		}
	}
	
}
