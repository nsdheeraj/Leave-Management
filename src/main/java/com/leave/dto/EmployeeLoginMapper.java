package com.leave.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import java. sql. Timestamp;;
public class EmployeeLoginMapper  implements RowMapper<EmployeeLogin> {

	@Override
	public EmployeeLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		EmployeeLogin employeeLogin = new EmployeeLogin();
		employeeLogin.setEmpID(rs.getInt("EmpID"));
		employeeLogin.setUsername(rs.getString("Username"));
		employeeLogin.setFirstName(rs.getString("FirstName"));
		employeeLogin.setLastName(rs.getString("LastName"));
		employeeLogin.setPassword(rs.getString("Password"));
		employeeLogin.setCreatedBy(rs.getString("CreatedBy"));
		employeeLogin.setUpdatedBy(rs.getString("UpdatedBy"));
		employeeLogin.setCreatedAt(rs.getString("CreatedAt"));
		employeeLogin.setUpdatedAt(rs.getString("UpdatedAt"));
		employeeLogin.setStatus(rs.getBoolean("Status"));
		employeeLogin.setEmail(rs.getString("Email"));
		return employeeLogin;
	}
	

}
