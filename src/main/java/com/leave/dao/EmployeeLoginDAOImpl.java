package com.leave.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leave.dto.EmployeeLogin;
import com.leave.dto.EmployeeLoginMapper;
import com.leave.dto.EmployeeMaster;
import com.leave.dto.LeaveRequests;
import com.leave.dto.LeaveRequestsMapper;

@Transactional
@Repository

public class EmployeeLoginDAOImpl implements EmployeeLoginDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public EmployeeLoginDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<EmployeeLogin> getEmployeeLoginDetails() {
		String sql = "SELECT * FROM employee_login";
		
		List<EmployeeLogin> employeeLoginList = new ArrayList<EmployeeLogin>();
		try
		{
			//employeeLoginList  =  this.jdbcTemplate.query(sql,
				//	new BeanPropertyRowMapper<EmployeeLogin>(EmployeeLogin.class));
			   RowMapper<EmployeeLogin> rowMapper = new EmployeeLoginMapper();
		        employeeLoginList  = this.jdbcTemplate.query(sql, rowMapper);
		}
		catch (Exception e) {
			return null;
		}
		return employeeLoginList;
		
	}

	@Override
	public boolean save(EmployeeLogin employeeLogin) throws Exception {
		boolean isUpdated = false;
		try {
		isUpdated = this.jdbcTemplate.update(
				"INSERT INTO employee_login(EmpID,FirstName,LastName,Email,Username,Password,CreatedBy,UpdatedBy) VALUES(?,?,?,?,?,MD5(?),?,?)",employeeLogin.getEmpID(),employeeLogin.getFirstName(),employeeLogin.getLastName(),employeeLogin.getEmail(),employeeLogin.getUsername(),employeeLogin.getPassword(),employeeLogin.getCreatedBy(),employeeLogin.getUpdatedBy()) > 0;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	return isUpdated;
}
}
