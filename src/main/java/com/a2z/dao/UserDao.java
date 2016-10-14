package com.a2z.dao;

import java.util.List;

import com.a2z.model.User;
import com.a2z.to.UserTo;

public interface UserDao {
	User findUserByUserName(String userName);
	public Long findUserIdByUserName(String userName);
	public void saveUser(User users);
    public List<?> findAllUsers(); //for audition and single user details
	public List<?> getUserDetailsProfile(long userId);
	User findUserByUserId(long userId);
	
}
