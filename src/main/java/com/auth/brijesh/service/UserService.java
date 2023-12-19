package com.auth.brijesh.service;

import com.auth.brijesh.model.User;
import com.auth.brijesh.model.request.UserLoginTemplate;
import com.auth.brijesh.model.request.UserRequest;

public interface UserService {
    void saveUser(UserRequest userRequest);

    String checkUserForLogin(UserLoginTemplate userLoginTemplate);

    User getUserByEmail(String email);

}
