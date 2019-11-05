package com.leave.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leave.dto.SalaryTransaction;
import com.leave.dto.SalaryTransactionMapper;

@Transactional
@Repository
public class SalarytransactionDAOImpl implements SalarytransactionDao {
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public SalarytransactionDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public SalaryTransaction getsalarytransactionbyId(int id) {
		String sql = "SELECT * FROM salarytrans where EmpId="+id+"";
		SalaryTransaction salaryTransaction = new SalaryTransaction();
		try
		{
			salaryTransaction =  this.jdbcTemplate .queryForObject(
					sql, new Object[] {  }, new SalaryTransactionMapper());
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		return salaryTransaction;
	}

	@Override
	public boolean update(SalaryTransaction salaryTransaction) throws Exception {
		boolean isUpdated = false;
		//salaryTransaction.setActive("1");
		isUpdated = this.jdbcTemplate.update(
				"Update salarytrans SET Period = '"+ salaryTransaction.getPeriod()+"',BasicPay = '"+ salaryTransaction.getBasicPay()+"'"
				 + ",SpecialAllowance = '"+ salaryTransaction.getSpecialAllowance()+"',CTC = '"+ salaryTransaction.getCTC()+"',HRA = '"+ salaryTransaction.getHRA()+"',MedicalAllowance = '"+ salaryTransaction.getMedicalAllowance()+"',ConveyanceAllowance = '"+ salaryTransaction.getConveyanceAllowance()+"',Arrears = '"+ salaryTransaction.getArrears()+"'"
				 + ",Others = '"+ salaryTransaction.getOthers()+"',GrossSalary = '"+ salaryTransaction.getGrossSalary()+"',PFDeductions = '"+ salaryTransaction.getPFDeductions()+"',ESIDeductions = '"+ salaryTransaction.getESIDeductions()+"'"
				 + ",PTDeductions = '"+ salaryTransaction.getPTDeductions()+"',TDS = '"+ salaryTransaction.getTDS()+"',Advance = '"+ salaryTransaction.getAdvance()+"',LOP = '"+ salaryTransaction.getLOP()+"'"
				 + ",OtherDeductions = '"+ salaryTransaction.getOtherDeductions()+"',TotalDeductions = '"+ salaryTransaction.getTotalDeductions()+"',TotalEarnings = '"+ salaryTransaction.getTotalEarnings()+"',NetPay = '"+ salaryTransaction.getNetPay()+"',PFDeductions1 = '"+ salaryTransaction.getPFDeductions1()+"'"
				 + ",TelephoneAllowance = '"+ salaryTransaction.getTelephoneAllowance()+"',Freeze = '"+ salaryTransaction.getFreeze()+"'  where Empid ='"+salaryTransaction.getEmpID()+"'"
				)>0;
				
				return isUpdated;
	}
	
	

}
