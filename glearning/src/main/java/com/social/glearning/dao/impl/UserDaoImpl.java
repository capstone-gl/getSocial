package com.social.glearning.dao.impl;

import com.social.glearning.dao.UserDao;
import com.social.glearning.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private DynamoDBMapper mapper;
    public void createUser(User user){
        mapper.save(user);
    }
}
