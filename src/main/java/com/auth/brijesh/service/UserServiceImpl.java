package com.auth.brijesh.service;

import com.auth.brijesh.dao.UserDao;
import com.auth.brijesh.model.UserType;
import com.auth.brijesh.model.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void saveUser(UserRequest userRequest) {
        UserType userType;
        userType = (userRequest.getFirstName().equals("Brijesh")) ? UserType.ADMIN:UserType.NORMAL;
        userDao.saveUser(userRequest, userRequest.getPassword(), userType);
    }
}
