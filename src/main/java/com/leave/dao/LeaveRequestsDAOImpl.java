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

import com.leave.dto.*;

@Transactional
@Repository

public class LeaveRequestsDAOImpl implements LeaveRequestsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public LeaveRequestsDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<LeaveRequests> getLeaveRequestsDetails() {
		// String sql = "SELECT * FROM employee_leave_requests";
		String sql1 = "SELECT * from employee_leave_requests";
		List<LeaveRequests> leaveRequestsList = new ArrayList<LeaveRequests>();
		try {
			// leaveRequestsList = this.jdbcTemplate.query(sql,
			// new BeanPropertyRowMapper<LeaveRequests>(LeaveRequests.class));

			RowMapper<LeaveRequests> rowMapper = new LeaveRequestsMapper();
			leaveRequestsList = this.jdbcTemplate.query(sql1, rowMapper);

		} catch (Exception e) {
			return null;
		}
		return leaveRequestsList;

	}

	@Override
	public boolean save(LeaveRequests leaveRequests) throws Exception {
		boolean isUpdated = false;
		// String sql="INSERT INTO
		// employee_leave_requests(EmpID,Type,Reason,RequestStatus,CreditsController,CreatedBy,UpdatedBy,Status)
		// VALUES (1010,'abc','xyz','approved',1000,'vueuav','erubibv',0)";
		try {
			// String sql="INSERT INTO
			// employee_leave_requests(EmpID,Type,Reason,RequestStatus,CreditsController,CreatedBy,UpdatedBy,Status)
			// VALUES
			// (?,?,?,?,?,?,?,?),'"+leaveRequests.getEmpID()+"'"+leaveRequests.getType()+"'"+leaveRequests.getReason()+"'"+leaveRequests.getFrom()+"'"+leaveRequests.getTo()+"'"+leaveRequests.getRequestStatus()+"'"+leaveRequests.getCredits()+"'"+leaveRequests.getCreatedBy()+"'"+leaveRequests.getUpdatedBy()+"'"+leaveRequests.getStatus()+"";
			isUpdated = this.jdbcTemplate.update(
					"INSERT INTO employee_leave_requests(EmpID,Type,Reason,FromDate,ToDate,DeductableCredits,CreatedBy,UpdatedBy) VALUES(?,?,?,?,?,?,?,?)",
					leaveRequests.getEmpID(), leaveRequests.getType(), leaveRequests.getReason(),
					leaveRequests.getFromDate(), leaveRequests.getToDate(),leaveRequests.getDeductableCredits(),
					leaveRequests.getCreatedBy(), leaveRequests.getUpdatedBy()) > 0;
			// isUpdated = this.jdbcTemplate.update(sql) > 0;
			// String s=leaveRequests.getType();
			/*
			 * if(s.equals("1")) { isUpdated=this.jdbcTemplate.update("")>0; } else
			 * if(s.equals("2")) { isUpdated=this.jdbcTemplate.
			 * update("INSERT INTO type_of_leave(Type)VALUES('SL')")>0; }
			 */
		/*	isUpdated = this.jdbcTemplate.update(
					"UPDATE credits_table SET DeductibleCredits=? where EmpID=? and Type=?",
					leaveRequests.getDeductibleCredits(), leaveRequests.getEmpID(), leaveRequests.getType()) > 0;*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return isUpdated;

	}

	public boolean update( LeaveRequests leaveRequests) throws Exception{
		boolean isUpdated=false;
		//boolean isStatusUpdated=false;
	try {
			
			isUpdated=this.jdbcTemplate.update(
					"Update employee_leave_requests SET RequestStatus=? Where ReqId=?",leaveRequests.getRequestStatus(),leaveRequests.getReqID()
					)>0;
				/*	if(leaveRequests.getRequestStatus().equals("Approved")) {
					{isUpdated=this.jdbcTemplate.update("UPDATE `credits_table` AS ct2 SET ct2.`Credits`= (SELECT ct.credits - ct.deductiblecredits FROM (select * from `employee_leave_requests`) as lr JOIN (select * from `credits_table`) AS ct ON lr.EmpID = ct.empid AND lr.type = ct.type where lr.ReqID = ?),`DeductibleCredits`= ? where ct2.`EmpID`=? and ct2.`Type`=?",leaveRequests.getReqID(),leaveRequests.getDeductibleCredits(),leaveRequests.getEmpID(),leaveRequests.getType())>0;}
					if(isUpdated)
						isStatusUpdated = this.jdbcTemplate.update(	"Update employee_leave_requests SET RequestStatus=? Where ReqId=?",leaveRequests.getRequestStatus(),leaveRequests.getReqID())>0;
					}
					else
					{
						isUpdated=this.jdbcTemplate.update("UPDATE `credits_table` AS ct2 SET ct2.DeductibleCredits= 0 where ct2.`EmpID`=? and ct2.`Type`=?",leaveRequests.getReqID(),leaveRequests.getDeductibleCredits(),leaveRequests.getEmpID(),leaveRequests.getType())>0;
						if(isUpdated)
							isStatusUpdated = this.jdbcTemplate.update(	"Update employee_leave_requests SET RequestStatus=? Where ReqId=?",leaveRequests.getRequestStatus(),leaveRequests.getReqID())>0;
						}*/
					if(leaveRequests.getRequestStatus().equals("Approved")) {
						String sql2="SELECT Type from employee_leave_requests where ReqId='"+leaveRequests.getReqID()+"'";
						String type=this.jdbcTemplate.queryForObject(sql2 ,new Object[] {  },String.class);
					String sql="SELECT Credits from credits_table where EmpID='"+leaveRequests.getEmpID()+"'and Type='"+type+"'";	
					//	String sql="SELECT Credits from credits_table where EmpID=? and Type=?",leaveRequests.getEmpID(),leaveRequests.getType();	
				double credits= this.jdbcTemplate.queryForObject(sql ,new Object[] {  },double.class);
							double cred=credits-leaveRequests.getDeductableCredits();
				isUpdated=this.jdbcTemplate.update("UPDATE credits_table SET Credits=? where EmpID=? and Type=?",cred,leaveRequests.getEmpID(),type)>0;}
				  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	 
	 }

}
