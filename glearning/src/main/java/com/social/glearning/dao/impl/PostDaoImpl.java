package com.social.glearning.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.social.glearning.dao.PostDao;
import com.social.glearning.model.Post;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
    private DynamoDBMapper mapper;

	@Override
	public void createPost(Post post) {
		
		
	}
}
