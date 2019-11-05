package com.leave.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class KeyValueMapper implements RowMapper<KeyValue> {

	@Override
	public KeyValue mapRow(ResultSet rs, int rowNum) throws SQLException {
		KeyValue keyValue = new KeyValue();
		keyValue.setKey(rs.getString("OptionValue"));
		keyValue.setValue(rs.getString("OptionValue")); 
		return keyValue;
	}

}
