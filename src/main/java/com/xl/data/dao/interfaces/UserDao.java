package com.xl.data.dao.interfaces;

import java.util.List;

import com.xl.data.entities.User;

//user specific dao functionalities
public interface UserDao extends Dao<User, Long>{
	public List<User> findByFirstName(String firstName);
}
