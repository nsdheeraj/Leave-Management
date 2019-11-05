package com.leave.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CreditsMapper implements RowMapper<Credits> {

	@Override
	public Credits mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Credits credits = new Credits();
		credits.setEmpID(rs.getInt("EmpID"));
		credits.setType(rs.getString("Type"));
		credits.setCredits(rs.getDouble("Credits"));
		credits.setDeductibleCredits(rs.getDouble("DeductibleCredits"));

		return credits;
	}

}
