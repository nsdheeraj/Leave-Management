package com.leave.dao;

import com.leave.dto.Salarymaster;

public interface SalaryDAO {
	public Salarymaster getSalarybyId(int id);
	public boolean update(Salarymaster salaryMaster) throws Exception;
}
