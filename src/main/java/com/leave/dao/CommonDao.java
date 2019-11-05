package com.leave.dao;
 
import java.util.List;

import com.leave.dto.KeyValue;

public interface CommonDao {
	 
	public List<KeyValue> getOptionsbyType(String type);
	public String getCurrentMonth();

}
