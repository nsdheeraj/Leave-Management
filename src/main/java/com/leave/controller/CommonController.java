package com.leave.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leave.dao.CommonDao;
import com.leave.dto.KeyValue;

@RestController
@RequestMapping("/common")
public class CommonController {

	@Autowired
	CommonDao commonDao;

 
	@RequestMapping(value = "getOptionbyType/{type}", method = RequestMethod.GET)
	public List<KeyValue> getOptionbyType(@PathVariable String type) throws URISyntaxException {
		List<KeyValue> keyValueList = new ArrayList<KeyValue>();
		 
		keyValueList = commonDao.getOptionsbyType(type);

		if (keyValueList != null) {
			return keyValueList;
		} else {
			return null;
		}

	}
	
	@RequestMapping(value = "getCurrentMonth", method = RequestMethod.GET)
	public String getCurrentMonth() throws URISyntaxException {
		String current_Month ="";
		current_Month = commonDao.getCurrentMonth();
		if(current_Month !=null)
		return current_Month;
		else
			return null;
		
	}

}
