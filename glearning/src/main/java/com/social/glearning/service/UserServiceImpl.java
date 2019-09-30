package com.social.glearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.glearning.dao.UserDao;
import com.social.glearning.model.User;

@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserDao userDao;

	@Override
	public String createUser(User user) {
		return userDao.createUser(user,true);
	}

	@Override
	public User getUser(String id) {
		return userDao.getUser(id);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
}
