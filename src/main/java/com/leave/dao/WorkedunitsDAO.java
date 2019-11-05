package com.leave.dao;

import com.leave.dto.Workedunits;

public interface WorkedunitsDAO {
	//public boolean update(Workedunits workedunits) throws Exception;

	public Workedunits getWorkedunitsbyId(int id, String current_Month);

	//public List<Workedunits> getWorkedunitsbyId(int id, String current_Month);
	
	
}
