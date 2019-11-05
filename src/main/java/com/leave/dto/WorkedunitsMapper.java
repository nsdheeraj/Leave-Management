package com.leave.dto;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.leave.dto.Workedunits;

public class WorkedunitsMapper implements RowMapper<Workedunits> {

	@Override
	public Workedunits mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Workedunits workedunits = new Workedunits();
		workedunits.setEmpID(rs.getInt("EmpID"));
		workedunits.setPeriod(rs.getString("Period"));
		workedunits.setMonth(rs.getString("Month"));
		workedunits.setTotalUnits(rs.getInt("TotalUnits"));
		workedunits.setWorkedUnits(rs.getInt("WorkedUnits"));
		workedunits.setLeaveUnits(rs.getInt("LeaveUnits"));
		
		return workedunits;
	}

}
