package com.leave.dao;
import com.leave.dto.EmployeeLogin;

import java.util.List;

public interface EmployeeLoginDAO {
	
	public List<EmployeeLogin> getEmployeeLoginDetails();
	public boolean save(EmployeeLogin employeeLogin) throws Exception;
}
