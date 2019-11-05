package com.leave.dao;
import java.util.List;

//import com.leave.controller.CreditsController;
import com.leave.dto.Credits;
import com.leave.dto.EmployeeLogin;

public interface CreditsDAO {
	public boolean update(Credits updateCredits) throws Exception;
	public List<Credits> viewLeaves();
	public boolean save(Credits updateCredits) throws Exception;
}
