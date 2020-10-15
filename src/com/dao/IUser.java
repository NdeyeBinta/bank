package com.dao;


import java.util.List;

import com.entities.User;



public interface IUser {
	public int add (User user);
	public int delete (int id);
	public int update (User u);
	public List<User> liste();
	public User get(int id);
	public User getLogin(String email, String password);
}
