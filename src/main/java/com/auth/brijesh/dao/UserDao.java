package com.auth.brijesh.dao;

import com.auth.brijesh.model.User;
import com.auth.brijesh.model.UserType;
import com.auth.brijesh.model.request.UserRequest;
import com.auth.brijesh.model.response.UserResponse;

public interface UserDao {
    public String saveUser(UserRequest user, String password, UserType userType);
    public User loginUser(String email);
    public User findUserByEmail(String email);
}
