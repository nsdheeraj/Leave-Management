package com.leave.dto;

public class EmployeeMaster {

	private int EmpID;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String FatherName;
	private String Initials;
	private String SpouseName;
	private String DOB;
	private String CompanyID;
	private String Department;
	private String BusinessTitle;
	private String EmploymentType;
	private String JobBand;
	private String JoiningDate;
	private String MobileNo;
	private String AlternateContactNo;
	private String PAN;
	private String AADHAAR;
	private String PF_UAN;
	private String PassportNo;
	private String Active;
	private String ResignationDate;
	private String LeavingDate;
	private int Lastempid;
	private String ReportingPerson;
	private String email;
	

	public int getLastempid() {
		return Lastempid;
	}

	public void setLastempid(int lastempid) {
		this.Lastempid = lastempid;
	}

	public int getEmpID() {
		return EmpID;
	}

	public void setEmpID(int empID) {
		EmpID = empID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	public String getInitials() {
		return Initials;
	}

	public void setInitials(String initials) {
		Initials = initials;
	}

	public String getSpouseName() {
		return SpouseName;
	}

	public void setSpouseName(String spouseName) {
		SpouseName = spouseName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getCompanyID() {
		return CompanyID;
	}

	public void setCompanyID(String companyID) {
		CompanyID = companyID;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getBusinessTitle() {
		return BusinessTitle;
	}

	public void setBusinessTitle(String businessTitle) {
		BusinessTitle = businessTitle;
	}

	public String getEmploymentType() {
		return EmploymentType;
	}

	public void setEmploymentType(String employmentType) {
		EmploymentType = employmentType;
	}

	public String getJobBand() {
		return JobBand;
	}

	public void setJobBand(String jobBand) {
		JobBand = jobBand;
	}

	public String getJoiningDate() {
		return JoiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		JoiningDate = joiningDate;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public String getAlternateContactNo() {
		return AlternateContactNo;
	}

	public void setAlternateContactNo(String alternateContactNo) {
		AlternateContactNo = alternateContactNo;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public String getAADHAAR() {
		return AADHAAR;
	}

	public void setAADHAAR(String aADHAAR) {
		AADHAAR = aADHAAR;
	}

	public String getPF_UAN() {
		return PF_UAN;
	}

	public void setPF_UAN(String pF_UAN) {
		PF_UAN = pF_UAN;
	}

	public String getPassportNo() {
		return PassportNo;
	}

	public void setPassportNo(String passportNo) {
		PassportNo = passportNo;
	}

	public String getActive() {
		return Active;
	}

	public void setActive(String active) {
		Active = active;
	}

	public String getResignationDate() {
		return ResignationDate;
	}

	public void setResignationDate(String resignationDate) {
		if (resignationDate == "")
			ResignationDate = null;
		else
			ResignationDate = resignationDate;
	}

	public String getLeavingDate() {
		return LeavingDate;
	}

	public void setLeavingDate(String leavingDate) {
		 
		if (leavingDate == "")
			LeavingDate = null;
		else
			LeavingDate = leavingDate;
	}
	
	public String getReportingPerson() {
		return ReportingPerson;
	}

	public void setReportingPerson(String reportingPerson) {
		ReportingPerson = reportingPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
