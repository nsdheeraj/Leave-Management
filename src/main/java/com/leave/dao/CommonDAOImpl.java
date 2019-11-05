package com.leave.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leave.dto.KeyValue;


@Transactional
@Repository

public class CommonDAOImpl implements CommonDao  {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public CommonDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	@Override
	public List<KeyValue> getOptionsbyType(String type) {
		String sql = "SELECT  OptionValue from configtable where OptionType='"+type+"'";
		List<KeyValue> keyValueList = new ArrayList(); 
		try
		{ 
			
			List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql);
			for (Map row : rows) {
				KeyValue keyValue = new KeyValue(); 
				keyValue.setKey(row.get("OptionValue").toString());
				keyValue.setValue(row.get("OptionValue").toString()); 
				keyValueList.add(keyValue);
			}
			 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		return keyValueList; 
	}
	
	@Override
	public String getCurrentMonth() {
		String sql = "SELECT Month from currentmonthprocess";
		String Current_Month = jdbcTemplate.queryForObject(
						sql, String.class);
		return Current_Month;
	}

}
