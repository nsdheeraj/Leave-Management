package com.leave.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SalaryMasterMapper implements RowMapper<Salarymaster> {

	@Override
	public Salarymaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		Salarymaster salarymaster = new Salarymaster();
		salarymaster.setEmpID(rs.getInt("EmpID"));
		salarymaster.setBasicPay(rs.getInt("BasicPay"));
		salarymaster.setSpecialAllowance(rs.getInt("SpecialAllowance"));
		salarymaster.setHRA(rs.getInt("HRA"));
		salarymaster.setMedicalAllowance(rs.getInt("MedicalAllowance"));
		salarymaster.setConveyanceAllowance(rs.getInt("ConveyanceAllowance"));
		salarymaster.setTelephoneAllowance(rs.getInt("TelephoneAllowance"));
		salarymaster.setPFDeductionEmployee(rs.getInt("PFDeductionEmployee"));
		salarymaster.setPFDeductionEmployer(rs.getInt("PFDeductionEmployer"));
		salarymaster.setCTC(rs.getInt("CTC"));
		salarymaster.setPayPeriodType(rs.getString("PayPeriodType"));
		
		return salarymaster;
	}

}
