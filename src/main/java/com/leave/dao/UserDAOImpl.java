package com.leave.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leave.dto.User;
import com.leave.dto.UserMapper;
import com.leave.util.DateUtil;

@Transactional
@Repository
public class UserDAOImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	DateUtil du = new DateUtil();
	
	//PasswordUtil pu = new PasswordUtil();

	
	
	
	public boolean saveOrUpdate(User user) throws Exception {
		boolean isUpdated = false;
		//user.setCreatedDate(du.setDateTimeNow());
		//user.setUpdatedDate(du.setDateTimeNow());
		user.setActive(1);
		
		isUpdated = this.jdbcTemplate.update(
				"INSERT INTO users(userName,userPassword,email,active) values(?,?,?,?,)",
				user.getUserName(), user.getUserPassword(), user.getEmail(),
				user.getActive()) > 0;
		return isUpdated;

	}
	
	@Override
	public int updateUser(User user,int id) {
		String sql = "UPDATE users SET userName=?,email=?, WHERE userId=?";
		int updated =jdbcTemplate.update(sql,new Object[]{ user.getUserName(),  user.getEmail(),id});
		return updated;

	}

	

	public List<User> userList() {
		String sql = "SELECT * FROM users where active=1";
		RowMapper<User> rowMapper = new UserMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public User getUserById(int id) {
		String sql = "SELECT * FROM users WHERE active=1 and userId=" + id;
		
		
		
		return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					User user = new User();
					user.setUserId(rs.getInt("userId"));
					user.setUserName(rs.getString("userName"));
					user.setUserPassword(rs.getString("userPassword"));
					user.setEmail(rs.getString("email"));
					return user;
				}

				return null;
			}

		});
	}

	

	

	@Override
	public List<User> getManagerList(int roleId ) {
		String sql="";
		if(roleId == 3) {
			 sql = "SELECT * FROM users where roleID ='2'";
		}else if(roleId == 5) {
			sql = "SELECT * FROM users where roleID ='4'";
		}else if(roleId==2 || roleId==4) {
			sql="select * from users where roleID='1'";
		}
		
		List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();

				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));

				return user;
			}

		});	
		return userList;
	}
	
	public int delete(int id) {
		//String sql = "DELETE FROM users WHERE userId=?";
		  String sql = "UPDATE users SET active=0 WHERE userId=?";
		  int deleteUser=jdbcTemplate.update(sql, id);
		  
		  return deleteUser;
		
	}

	@Override
	public void deleteManager(int id) {
		String sql = "UPDATE users SET manager=NULL WHERE manager=?";
		  jdbcTemplate.update(sql, id);		
	}
	

/*	@Override
	public User validateUser(User user) {
		String sql = "select * from employee_login where Status=1 and Email='" + user.getEmail() + "' and Password=MD5('"+user.getUserPassword()+"')";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}*/
	@Override
	public User validateUser(User user) {
		String sql = "select * from employee_login where Status=1 and Email='" + user.getEmail() + "' and Password=MD5('"+user.getUserPassword()+"')";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.get(0);
		//return users.size() > 0 ? users.get(0) : null;
		//return empid;
	}

	@Override
		public User validateEmail(User user) {
		String sql = "select * from users where active=1 and email='" + user.getEmail()+ "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public List<User> getUserdetails(User user) {
		String sql = "select * from users where active=1 and email='" + user.getEmail()+"'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users;
	}

	@Override
	public int changePassword(User user) {
	
		String sql = "UPDATE users SET userPassword=? where userId=?";
		int user1= jdbcTemplate.update(sql, new Object[]{user.getUserPassword(),user.getUserId()});
		return user1;
	}

	@Override
	public List<Map<String, Object>> getUserList(Map<String, Object> params) {
		String sql ="select * from users u,role r where u.roleID=r.id; ";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public boolean checkEmail(User user) {
		String sql="select count(*) from users where email=? ";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, user.getEmail());
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean checkUserName(User user) {
		String sql="select count(*) from users where userName=? ";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, user.getUserName());
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}
	/*class UserMapper implements RowMapper<User> {
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setUserId(rs.getInt("userid"));
			user.setUserName(rs.getString("userName"));
			user.setUserPassword(rs.getString("userPassword"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setRoleId(rs.getInt("roleId"));
			user.setManager(rs.getInt("manager"));
			user.setEmail(rs.getString("email"));
	
			return user;
		}
	
		
	}*/

}
