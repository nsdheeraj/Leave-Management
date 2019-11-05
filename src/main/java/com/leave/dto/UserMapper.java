package com.leave.dto;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		user.setUserId(rs.getInt("EmpId"));
		//user.setUserName(rs.getString("Username"));
		user.setEmail(rs.getString("email"));
		/*
		 * user.setUserPassword(rs.getString("Password"));
		 * user.setActive(rs.getInt("Status"));
		 */
		return user;
	}

}
