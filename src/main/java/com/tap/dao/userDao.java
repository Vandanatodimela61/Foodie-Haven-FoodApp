package com.tap.dao;

import java.util.List;
import com.tap.model.User;

public interface userDao {
    int insertUser(User user);
    List<User> getAlluserData();
    User getUser(String email);
    int deleteUserById(int user_id);
    int updateUserById(String password, int user_id);
}
