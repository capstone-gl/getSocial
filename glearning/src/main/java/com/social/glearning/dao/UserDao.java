package com.social.glearning.dao;

import com.social.glearning.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public void createUser(User user);
}
