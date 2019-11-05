package com.leave.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leave.dto.SalaryMasterMapper;
import com.leave.dto.Salarymaster;


@Transactional
@Repository


public class SalarymasterDAOImpl implements SalaryDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public SalarymasterDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	@Override
	public Salarymaster getSalarybyId(int id) {
		String sql = "SELECT * FROM salarymaster where EmpId="+id+"";
		Salarymaster salaryMaster = new Salarymaster();
		try
		{
			salaryMaster  =  this.jdbcTemplate .queryForObject(
					sql, new Object[] {  }, new SalaryMasterMapper());
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		return salaryMaster;
	
		
	}


	@Override
	public boolean update(Salarymaster salaryMaster) throws Exception {
		
		 boolean isUpdated = false;
			//employeeMaster.setActive("1");
			isUpdated = this.jdbcTemplate.update(
					"Update salarymaster SET BasicPay = '"+ salaryMaster.getBasicPay()+"',MedicalAllowance = '"+ salaryMaster.getMedicalAllowance()+"'"
					 + ",HRA = '"+ salaryMaster.getHRA()+"',SpecialAllowance = '"+ salaryMaster.getSpecialAllowance()+"',ConveyanceAllowance = '"+ salaryMaster.getConveyanceAllowance()+"',TelephoneAllowance = '"+ salaryMaster.getTelephoneAllowance()+"',PFDeductionEmployer = '"+ salaryMaster.getPFDeductionEmployer()+"'"
					 + ",PFDeductionEmployee = '"+ salaryMaster.getPFDeductionEmployee()+"',PayPeriodType = '"+ salaryMaster.getPayPeriodType()+"',CTC = '"+ salaryMaster.getCTC()+"'  where Empid ='"+salaryMaster.getEmpID()+"'"
					)>0;
					
					return isUpdated;
		}
		
		
	}


