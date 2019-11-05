package com.leave.dto;

import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LeaveRequestsMapper implements RowMapper<LeaveRequests>
{

	@Override
	public LeaveRequests mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		// TODO Auto-generated method stub
LeaveRequests leaveRequests = new LeaveRequests();
		
		leaveRequests.setReqID(rs.getInt("ReqID"));
		leaveRequests.setEmpID(rs.getInt("EmpID"));
		leaveRequests.setType(rs.getString("Type"));
		leaveRequests.setReason(rs.getString("Reason"));
		leaveRequests.setFromDate(rs.getString("FromDate"));
		leaveRequests.setToDate(rs.getString("ToDate"));
		leaveRequests.setRequestStatus(rs.getString("RequestStatus"));
		leaveRequests.setCreatedBy(rs.getString("CreatedBy"));
		leaveRequests.setUpdatedBy(rs.getString("UpdatedBy")); 
		leaveRequests.setCreatedAt(rs.getString("CreatedAt"));
		leaveRequests.setUpdatedAt(rs.getString("UpdatedAt")); 
		leaveRequests.setStatus(rs.getBoolean("Status"));
		leaveRequests.setDeductableCredits(rs.getDouble("DeductableCredits"));
		
		return leaveRequests;
		
	}

}
