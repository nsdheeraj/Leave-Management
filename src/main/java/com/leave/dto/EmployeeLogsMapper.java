package com.leave.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeLogsMapper implements RowMapper<EmployeeLogs> {
	
	@Override
	public EmployeeLogs mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeLogs employeeLogs = new EmployeeLogs();
		employeeLogs.setId(rs.getInt("Id"));
		employeeLogs.setLog(rs.getString("Log"));
		employeeLogs.setEmpID(rs.getInt("EmpID"));
		employeeLogs.setCreatedBy(rs.getString("CreatedBy"));
		employeeLogs.setUpdatedBy(rs.getString("UpdatedBy"));
		employeeLogs.setCreatedAt(rs.getString("CreatedAt"));
		employeeLogs.setUpdatedAt(rs.getString("UpdatedAt"));
		return employeeLogs;
	}

}
