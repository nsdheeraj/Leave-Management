package com.leave.dao;

import java.util.List;

import com.leave.dto.EmployeeMaster;

public interface EmployeeMasterDAO {
	 
	public EmployeeMaster getEmployeebyId(int id);
	public boolean update(EmployeeMaster employeeMaster) throws Exception;
	boolean save(EmployeeMaster employeeMaster) throws Exception;
	public List<EmployeeMaster> getMaxEmpid();
	public List<EmployeeMaster> getEmployeeByname(String name);
	public List<EmployeeMaster> getReportingPersonsIDByRole(String reporting_person);
	public List<EmployeeMaster> viewAllMeetingReq();
	public List<EmployeeMaster> getEmployeeByDepartment(String department);
	public List<EmployeeMaster> getReportingPersonIDbyempid(int empid);
	public List<EmployeeMaster> getEmp_Mailbyempid(int rpid);
	

}
