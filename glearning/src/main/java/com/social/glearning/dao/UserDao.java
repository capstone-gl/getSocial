package com.social.glearning.dao;

import com.social.glearning.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public String createUser(User user,Boolean create);
    public User getUser(String id);
    public User getUserByEmail(String email);
}
