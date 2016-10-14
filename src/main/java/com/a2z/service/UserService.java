package com.a2z.service;

import java.util.List;

import com.a2z.model.User;
import com.a2z.to.UserTo;

public interface UserService {
	public User findUserByUserName(String userName);
	public Long findUserIdByUserName(String userName);
	public  UserTo saveUser(UserTo userTo);
	UserTo validateUser(String userName, String password);
	User autologin(String userName, String password);
	
	
	///=========------------- for audition and oneuser details
	List<?> findAllUsers(); 
	public List<?> getUserDetailsProfile(Long userId);
	

}
