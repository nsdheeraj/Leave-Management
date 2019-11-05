package com.leave.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMasterMapper implements RowMapper<EmployeeMaster> {

	@Override
	public EmployeeMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeMaster employeeMaster = new EmployeeMaster();
		employeeMaster.setEmpID(rs.getInt("EmpID"));
		employeeMaster.setFirstName(rs.getString("FirstName"));
		employeeMaster.setMiddleName(rs.getString("MiddleName"));
		employeeMaster.setLastName(rs.getString("LastName"));
		employeeMaster.setFatherName(rs.getString("FatherName"));
		employeeMaster.setInitials(rs.getString("Initials"));
		employeeMaster.setSpouseName(rs.getString("SpouseName"));
		employeeMaster.setDOB(rs.getString("DOB"));
		employeeMaster.setCompanyID(rs.getString("CompanyID"));
		employeeMaster.setDepartment(rs.getString("Department"));
		employeeMaster.setBusinessTitle(rs.getString("BusinessTitle"));
		employeeMaster.setEmploymentType(rs.getString("EmploymentType"));
		employeeMaster.setJobBand(rs.getString("JobBand"));
		employeeMaster.setJoiningDate(rs.getString("JoiningDate"));
		employeeMaster.setMobileNo(rs.getString("MobileNo"));
		employeeMaster.setAlternateContactNo(rs.getString("AlternateContactNo"));
		employeeMaster.setPAN(rs.getString("PAN"));
		employeeMaster.setAADHAAR(rs.getString("AADHAAR"));
		employeeMaster.setPF_UAN(rs.getString("PF_UAN"));
		employeeMaster.setPassportNo(rs.getString("PassportNo"));
		employeeMaster.setActive(rs.getString("Active"));
		employeeMaster.setResignationDate(rs.getString("ResignationDate"));
		employeeMaster.setLeavingDate(rs.getString("LeavingDate"));
		employeeMaster.setReportingPerson(rs.getString("ReportingPerson"));
		return employeeMaster;
	}

}
