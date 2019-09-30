package com.social.glearning.service;

import com.social.glearning.model.User;

public interface UserService {

	public String createUser(User user);
	public User getUser(String id);
	public User getUserByEmail(String email);
}
