package com.leave.dao;

import java.util.List;
import java.util.Map;

import com.leave.dto.User;

//import com.metadata.modal.User;
 

public interface UserDao {
	public boolean saveOrUpdate(User user) throws Exception;
	public int updateUser(User user, int id);
	public List<User> userList();
	public User getUserById(int id);
	
	public List<User> getManagerList(int roleId);
	
	public int delete(int id);
	
	public void deleteManager(int id);
	
	public User validateUser(User user);
	public List<User> getUserdetails(User user);
	public User validateEmail(User user);
	public int changePassword(User user);
	
	public List<Map<String,Object>> getUserList(Map<String, Object> params);
	
	public boolean checkEmail(User user);
	public boolean checkUserName(User user);
	
	
}
