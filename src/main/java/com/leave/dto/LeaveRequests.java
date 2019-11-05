package com.leave.dto;

//import java.sql.Timestamp;

//import java.util.Date;
//import java.util.Calendar;

public class LeaveRequests
{
	private int ReqID;
	private int EmpID;
	private String Type;
	//private String Duration;
	private String Reason;
	private String FromDate;
	private String ToDate;
	private String RequestStatus;
	private String CreatedBy;
	private String UpdatedBy; 
	private double Credits;
	private String CreatedAt;
	private String UpdatedAt;
	private boolean Status;
	private double DeductableCredits;
	public int getReqID() {
		return ReqID;
	}
	public void setReqID(int reqID) {
		ReqID = reqID;
	}
	public int getEmpID() {
		return EmpID;
	}
	public void setEmpID(int empID) {
		EmpID = empID;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	 
	public String getRequestStatus() {
		return RequestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		RequestStatus = requestStatus;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public String getUpdatedBy() {
		return UpdatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}
 
	public boolean getStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public String getFromDate() {
		return FromDate;
	}
	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}
	public String getToDate() {
		return ToDate;
	}
	public void setToDate(String toDate) {
		ToDate = toDate;
	}
	public String getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(String createdAt) {
		CreatedAt = createdAt;
	}
	public String getUpdatedAt() {
		return UpdatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		UpdatedAt = updatedAt;
	}
	/*public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}*/
	public double getDeductableCredits() {
		return DeductableCredits;
	}
	public void setDeductableCredits(double deductableCredits) {
		DeductableCredits = deductableCredits;
	}
	public double getCredits() {
		return Credits;
	}
	public void setCredits(double credits) {
		Credits = credits;
	}


}

