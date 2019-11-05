package com.leave.dao;

import java.util.List;


import com.leave.dto.LeaveRequests;

public interface LeaveRequestsDAO 
{
	public List<LeaveRequests> getLeaveRequestsDetails();
    public boolean save(LeaveRequests leaveRequests) throws Exception;

	public boolean update(LeaveRequests leaveRequests) throws Exception;
	
}
