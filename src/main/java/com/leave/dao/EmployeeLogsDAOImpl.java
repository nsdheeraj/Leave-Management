package com.leave.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leave.dto.EmployeeLogs;

@Transactional
@Repository

public class EmployeeLogsDAOImpl implements EmployeeLogsDAO{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public EmployeeLogsDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<EmployeeLogs> getEmployeeLogs() {
		String sql = "SELECT * FROM employee_logs";
		
		List<EmployeeLogs> employeeLogsList = new ArrayList<EmployeeLogs>();
		try
		{
			employeeLogsList  =  this.jdbcTemplate.query(sql,
					new BeanPropertyRowMapper<EmployeeLogs>(EmployeeLogs.class));
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		return employeeLogsList;
		
	}
}
