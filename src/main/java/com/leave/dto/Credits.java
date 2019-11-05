package com.leave.dto;

public class Credits {
	private int EmpID;
	private String Type;
	private double Credits;
	//private String TypeName;
	private double DeductibleCredits;
	//private String Duration;
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
	public double getCredits() {
		return Credits;
	}
	public void setCredits(double credits) {
		Credits = credits;
	}

//	public String getTypeName() {
//		return TypeName;
//	}
//	public void setTypeName(String typeName) {
//		TypeName = typeName;
//	}
	/*public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}*/
	public double getDeductibleCredits() {
		return DeductibleCredits;
	}
	public void setDeductibleCredits(double deductibleCredits) {
		DeductibleCredits = deductibleCredits;
	}
	

}
