package com.leave.dao;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import com.leave.dto.Credits;
import com.leave.dto.CreditsMapper;
import com.leave.dto.EmployeeLogin;
import com.leave.dto.EmployeeLoginMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository

//import com.leave.controller.CreditsController;

public class CreditsDAOImpl implements CreditsDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public CreditsDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
//	public boolean update(CreditsController credits) throws Exception{
//		boolean isUpdated=false;
//		try {
//			isUpdated=this.jdbcTemplate.update("UPDATE credits_table SET CreditsController=? where EmpID=? and Type=?",credits.getCredits())
//					
//		}
//		return isUpdated;
//		
//	}

	@Override
	public boolean update(Credits updateCredits) throws Exception {
		// TODO Auto-generated method stub
		boolean isUpdated=false;
		//String day=updateCredits.getDuration();
		try {
			if(updateCredits.getCredits()<=0)
			{return isUpdated;}
			else
			{
			//if(day.equals("Full Day"))
			{
				double cred=updateCredits.getCredits()-updateCredits.getDeductibleCredits();
			isUpdated=this.jdbcTemplate.update("UPDATE credits_table SET Credits=? where EmpID=? and Type=?",cred,updateCredits.getEmpID(),updateCredits.getType())>0;
			//	isUpdated=this.jdbcTemplate.update("UPDATE `credits_table` AS ct2 SET ct2.`Credits`= (SELECT ct.credits - ct.deductiblecredits FROM (select * from `employee_leave_requests`) as lr JOIN (select * from `credits_table`) AS ct ON lr.EmpID = ct.empid AND lr.type = ct.type where lr.ReqID = 1),`DeductibleCredits`= 0 where ct2.`EmpID`=? and ct2.`Type`=?",updateCredits.getEmpID(),updateCredits.getType())>0;
			}//
			/*else if(day.equals("Half Day"))
			{
				double cred=updateCredits.getCredits()-0.5;
				isUpdated=this.jdbcTemplate.update("UPDATE credits_table SET Credits=? where EmpID=? and Type=?",cred,updateCredits.getEmpID(),updateCredits.getType())>0;
			}*/
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	return isUpdated;
		
	}
	@Override
	public List<Credits> viewLeaves() {
		//String sql = "SELECT A.EmpID,B.TypeName,A.Credits FROM credits_table as A INNER JOIN type_of_leave as B on B.Type=A.Type";
		String sql = "SELECT * FROM credits_table";
		
		List<Credits> LeaveList = new ArrayList<Credits>();
		try
		{
			//employeeLoginList  =  this.jdbcTemplate.query(sql,
				//	new BeanPropertyRowMapper<EmployeeLogin>(EmployeeLogin.class));
			   RowMapper<Credits> rowMapper = new CreditsMapper();
		       LeaveList  = this.jdbcTemplate.query(sql, rowMapper);
		}
		catch (Exception e) {
			return null;
		}
		return LeaveList;
		
	}

	@Override
	public boolean save(Credits updateCredits) throws Exception {
		boolean isUpdated = false;
		try {
		isUpdated = this.jdbcTemplate.update(
				"INSERT INTO credits_table(EmpID,Type,Credits) VALUES(?,'Sick Leave',2)",updateCredits.getEmpID()) > 0;
				isUpdated = this.jdbcTemplate.update(
						"INSERT INTO credits_table(EmpID,Type,Credits) VALUES(?,'Casual Leave',3)",updateCredits.getEmpID()) > 0;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	return isUpdated;
}


}
