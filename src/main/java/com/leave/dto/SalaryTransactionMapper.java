package com.leave.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SalaryTransactionMapper implements RowMapper<SalaryTransaction> {

	@Override
	public SalaryTransaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		SalaryTransaction salaryTransaction = new SalaryTransaction();
		salaryTransaction.setEmpID(rs.getInt("EmpID"));
		salaryTransaction.setPeriod(rs.getString("Period"));
		salaryTransaction.setBasicPay(rs.getInt("BasicPay"));
		salaryTransaction.setSpecialAllowance(rs.getInt("SpecialAllowance"));
		salaryTransaction.setHRA(rs.getInt("HRA"));
		salaryTransaction.setMedicalAllowance(rs.getInt("MedicalAllowance"));
		salaryTransaction.setConveyanceAllowance(rs.getInt("ConveyanceAllowance"));
		salaryTransaction.setArrears(rs.getInt("Arrears"));
		salaryTransaction.setOthers(rs.getInt("Others"));
		salaryTransaction.setGrossSalary(rs.getInt("GrossSalary"));
		salaryTransaction.setPFDeductions(rs.getInt("PFDeductions"));
		salaryTransaction.setESIDeductions(rs.getInt("ESIDeductions"));
		salaryTransaction.setPTDeductions(rs.getInt("PTDeductions"));
		salaryTransaction.setTDS(rs.getInt("TDS"));
		salaryTransaction.setAdvance(rs.getInt("Advance"));
		salaryTransaction.setLOP(rs.getInt("LOP"));
		salaryTransaction.setOtherDeductions(rs.getInt("OtherDeductions"));
		salaryTransaction.setTotalDeductions(rs.getInt("TotalDeductions"));
		salaryTransaction.setTotalEarnings(rs.getInt("TotalEarnings"));
		salaryTransaction.setNetPay(rs.getInt("NetPay"));
		salaryTransaction.setPFDeductions1(rs.getInt("PFDeductions1"));
		salaryTransaction.setTelephoneAllowance(rs.getInt("TelephoneAllowance"));
		salaryTransaction.setCTC(rs.getInt("CTC"));
		salaryTransaction.setFreeze(rs.getString("Freeze"));
		return salaryTransaction;
	}

}
