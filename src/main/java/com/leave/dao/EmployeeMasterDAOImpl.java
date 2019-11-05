package com.leave.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.leave.dto.EmployeeMaster;
import com.leave.dto.EmployeeMasterMapper;


@Transactional
@Repository

public class EmployeeMasterDAOImpl implements EmployeeMasterDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public EmployeeMasterDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean save(EmployeeMaster employeeMaster) throws Exception {
		boolean isUpdated = false;
		
		isUpdated = this.jdbcTemplate.update(
				"INSERT INTO employee_master(EmpID,FirstName,MiddleName,LastName,FatherName,Initials,SpouseName,DOB,CompanyID,Department,BusinessTitle,ReportingPerson,EmploymentType,JobBand,JoiningDate,MobileNo,AlternateContactNo,PAN,AADHAAR,PF_UAN,PassportNo,Active,ResignationDate,LeavingDate,email) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				employeeMaster.getEmpID(),employeeMaster.getFirstName(),employeeMaster.getMiddleName(),employeeMaster.getLastName(),employeeMaster.getFatherName(),employeeMaster.getInitials(),employeeMaster.getSpouseName(),employeeMaster.getDOB(),
				employeeMaster.getCompanyID(),employeeMaster.getDepartment(),employeeMaster.getBusinessTitle(),employeeMaster.getReportingPerson(),employeeMaster.getEmploymentType(),employeeMaster.getJobBand(),employeeMaster.getJoiningDate(),employeeMaster.getMobileNo(),employeeMaster.getAlternateContactNo(),
				employeeMaster.getPAN(),employeeMaster.getAADHAAR(),employeeMaster.getPF_UAN(),employeeMaster.getPassportNo(),employeeMaster.getActive(),employeeMaster.getResignationDate(),employeeMaster.getLeavingDate(),employeeMaster.getEmail()) > 0;
			 
			 return isUpdated;
	}
	
	@Override
	public List<EmployeeMaster> viewAllMeetingReq() {
		String sql = "SELECT * FROM employee_master Where active='yes' order by EmpID";
		
		List<EmployeeMaster> employeeList = new ArrayList<EmployeeMaster>();
		try
		{
			employeeList  =  this.jdbcTemplate.query(sql,
					new BeanPropertyRowMapper<EmployeeMaster>(EmployeeMaster.class));
			
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		return employeeList;
	}
	
	@Override
	public boolean update(EmployeeMaster employeeMaster) throws Exception {
		boolean isUpdated = false;
		//employeeMaster.setActive("1");
		isUpdated = this.jdbcTemplate.update(
				"Update EmployeeMaster SET FirstName = '"+ employeeMaster.getFirstName()+"',MiddleName = '"+ employeeMaster.getMiddleName()+"'"
				 + ",LastName = '"+ employeeMaster.getLastName()+"',Initials = '"+ employeeMaster.getInitials()+"',FatherName = '"+ employeeMaster.getFatherName()+"',SpouseName = '"+ employeeMaster.getSpouseName()+"',DOB = '"+ employeeMaster.getDOB()+"'"
				 + ",CompanyID = '"+ employeeMaster.getCompanyID()+"',Department = '"+ employeeMaster.getDepartment()+"',BusinessTitle = '"+ employeeMaster.getBusinessTitle()+"',ReportingPerson = '"+ employeeMaster.getReportingPerson()+"',EmploymentType = '"+ employeeMaster.getEmploymentType()+"'"
				 + ",JobBand = '"+ employeeMaster.getJobBand()+"',JoiningDate = '"+ employeeMaster.getJoiningDate()+"',MobileNo = '"+ employeeMaster.getMobileNo()+"',AlternateContactNo = '"+ employeeMaster.getAlternateContactNo()+"'"
				 + ",PAN = '"+ employeeMaster.getPAN()+"',AADHAAR = '"+ employeeMaster.getAADHAAR()+"',PF_UAN = '"+ employeeMaster.getPF_UAN()+"',PassportNo = '"+ employeeMaster.getPassportNo()+"',Active = '"+ employeeMaster.getActive()+"'"
				 + ",ResignationDate = '"+ employeeMaster.getResignationDate()+"',LeavingDate = '"+ employeeMaster.getLeavingDate()+"',email='"+employeeMaster.getEmail()+"'  where Empid ='"+employeeMaster.getEmpID()+"'"
				)>0;
				
				return isUpdated;
	}
	


	@Override
	public EmployeeMaster getEmployeebyId(int id) {
		String sql = "SELECT * FROM employee_master where EmpId="+id+"";
		EmployeeMaster employeeMaster = new EmployeeMaster();
		try
		{
			employeeMaster =  this.jdbcTemplate .queryForObject(
					sql, new Object[] {  }, new EmployeeMasterMapper());
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		return employeeMaster;
	}
	
	@Override
	public List<EmployeeMaster> getMaxEmpid() {
		String sql = "select max(EmpID)+1 as EmpID from employee_master";

		List<EmployeeMaster> employeeList = jdbcTemplate.query(sql, new RowMapper<EmployeeMaster>() {

			public EmployeeMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeMaster EmployeeMaster = new EmployeeMaster(); 
				EmployeeMaster.setEmpID(rs.getInt("EmpID"));
				return EmployeeMaster;
			}

		});

		return employeeList;
	}

	@Override
	public List<EmployeeMaster> getEmployeeByname(String name) {
		
		String sql = "SELECT * FROM employee_master WHERE FirstName LIKE '"+name+"%' OR LastName LIKE '"+name+"%'";
		
		List<EmployeeMaster> employeeList = new ArrayList<EmployeeMaster>();
		try
		{
			employeeList  =  this.jdbcTemplate.query(sql,
					new BeanPropertyRowMapper<EmployeeMaster>(EmployeeMaster.class));
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		return employeeList;
	}
	
	@Override
	public List<EmployeeMaster> getReportingPersonsIDByRole(String reporting_personrole) {
		
		String sql = "SELECT EmpID,FirstName FROM employee_master WHERE BusinessTitle='"+reporting_personrole+"'";
		
		List<EmployeeMaster> ReportingPersonsList = new ArrayList<EmployeeMaster>();
		try
		{
			ReportingPersonsList  =  this.jdbcTemplate.query(sql,
					new BeanPropertyRowMapper<EmployeeMaster>(EmployeeMaster.class));
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		return ReportingPersonsList;
	}

	@Override
	public List<EmployeeMaster> getEmployeeByDepartment(String department) {
		String sql = "SELECT * FROM employee_master where Department='"+department+"'";
		
		List<EmployeeMaster> employeeNameList = new ArrayList<EmployeeMaster>();
		try
		{
			employeeNameList  =  this.jdbcTemplate.query(sql,
					new BeanPropertyRowMapper<EmployeeMaster>(EmployeeMaster.class));
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		return employeeNameList;
	}

	@Override
	public List<EmployeeMaster> getReportingPersonIDbyempid(int empid) {
		String sql = "SELECT ReportingPerson FROM employee_master WHERE EmpID='"+empid+"'";
		
		List<EmployeeMaster> ReportingPersonsList = new ArrayList<EmployeeMaster>();
		try
		{
			ReportingPersonsList  =  this.jdbcTemplate.query(sql,
					new BeanPropertyRowMapper<EmployeeMaster>(EmployeeMaster.class));
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		return ReportingPersonsList;
	}

	@Override
	public List<EmployeeMaster> getEmp_Mailbyempid(int rpid) {
		String sql = "SELECT email FROM employee_master WHERE EmpID='"+rpid+"'";
		
		List<EmployeeMaster> ReportingPersonsList = new ArrayList<EmployeeMaster>();
		try
		{
			ReportingPersonsList  =  this.jdbcTemplate.query(sql,
					new BeanPropertyRowMapper<EmployeeMaster>(EmployeeMaster.class));
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		return ReportingPersonsList;
	}

	


}
