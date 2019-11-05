package com.leave.dao;

import com.leave.dto.SalaryTransaction;

public interface SalarytransactionDao {
	
	public SalaryTransaction getsalarytransactionbyId(int id);
	boolean update(SalaryTransaction salaryTransaction) throws Exception;

}
