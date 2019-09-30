package com.social.glearning.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.SaveBehavior;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.social.glearning.GlConstants;
import com.social.glearning.dao.UserDao;
import com.social.glearning.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private DynamoDBMapper mapper;
   
    public String createUser(User user,Boolean create){
    	String userCreated = null;
    	if(create == false && user.getId() != null) { 
    		mapper.save(user,SaveBehavior.CLOBBER.config());
    		userCreated = GlConstants.USER_UPDATED;
    	}else if(create && getUserByEmail(user.getEmail()) == null) {
    		user.setPostNo(0L);
    		mapper.save(user,SaveBehavior.CLOBBER.config());
    		userCreated = GlConstants.USER_CREATED;
    	}
    	return userCreated;
    }

	@Override
	public User getUser(String id) {
//		User user = mapper.load(User.class,id);
//		return user;
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":v1", new AttributeValue().withS(id));
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
	            .withFilterExpression("id = :v1")
	            .withExpressionAttributeValues(eav);
		
		List<User> user = mapper.scan(User.class, scanExpression);
		return (user != null && user.size()>0) ? user.get(0) : null;
	}

	@Override
	public User getUserByEmail(String email) {
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":v1", new AttributeValue().withS(email));
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
	            .withFilterExpression("email = :v1")
	            .withExpressionAttributeValues(eav);
		
		List<User> user = mapper.scan(User.class, scanExpression);
		return (user != null && user.size()>0) ? user.get(0) : null;
	}


    
    
}
