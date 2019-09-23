package com.social.glearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.social.glearning.model.User;

@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	private DynamoDBMapper mapper;

	@Override
	public void createUser(User user) {
		mapper.save(user);
	}
}
