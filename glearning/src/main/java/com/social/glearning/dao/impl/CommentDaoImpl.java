package com.social.glearning.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.social.glearning.dao.CommentDao;
import com.social.glearning.model.Comments;

public class CommentDaoImpl implements CommentDao {

	@Autowired
    private DynamoDBMapper mapper;
	
	@Override
	public void createComment(Comments comments) {
		
		
	}

}
