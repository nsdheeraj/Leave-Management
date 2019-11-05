package com.leave.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leave.dto.Workedunits;
import com.leave.dto.WorkedunitsMapper;

@Transactional
@Repository

public class WorkedunitsDAOImpl implements WorkedunitsDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public WorkedunitsDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

}
	
	

	
	@Override
	public Workedunits getWorkedunitsbyId(int id,String current_Month) {
		String sql = "SELECT * FROM workedunits where EmpId="+id+" AND Month='"+current_Month+"'";
		Workedunits workedunits = new Workedunits();
	//	List<Workedunits> workedunits = new ArrayList<Workedunits>();
		try
		{
			workedunits  =  this.jdbcTemplate .queryForObject(
					sql, new Object[] {  }, new WorkedunitsMapper());
			
			
//			workedunits  =  this.jdbcTemplate.query(sql,
//					new BeanPropertyRowMapper<Workedunits>(Workedunits.class));
			
			
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		return workedunits;
	
		
	}
      
	
//	public boolean update(Workedunits workedunits) throws Exception {
//		
//		 boolean isUpdated = false;
//			//employeeMaster.setActive("1");
//			isUpdated = this.jdbcTemplate.update(
//					"Update workedunits SET Period = '"+ workedunits.getPeriod()+"',Month = '"+ workedunits.getMonth()+"'"
//					 + ",WorkedUnits = '"+ workedunits.getWorkedUnits()+"',LeaveUnits = '"+ workedunits.getLeaveUnits()+"',TotalUnits = '"+ workedunits.getTotalUnits()+"'  where Empid ='"+workedunits.getEmpID()+"'"
//					)>0;
//					
//					return isUpdated;
//		}

	
	
}