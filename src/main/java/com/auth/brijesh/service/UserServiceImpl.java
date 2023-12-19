package com.auth.brijesh.service;

import com.auth.brijesh.dao.UserDao;
import com.auth.brijesh.model.User;
import com.auth.brijesh.model.UserType;
import com.auth.brijesh.model.request.UserLoginTemplate;
import com.auth.brijesh.model.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    JwtService jwtService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserRequest userRequest) {
        UserType userType;
        userType = (userRequest.getFirstName().equals("Brijesh")) ? UserType.ADMIN:UserType.NORMAL;

        userDao.saveUser(userRequest, passwordEncoder.encode(userRequest.getPassword()), userType);
    }

    @Override
    public String checkUserForLogin(UserLoginTemplate userLoginTemplate) {
        User user = userDao.loginUser(userLoginTemplate.getEmail());
        System.out.println(user.getEmail());
        String token = null;
        if(user!=null){
            if(!userLoginTemplate.getPassword().equals(user.getPassword())){
                return "Password is Not Matched...";
            }
            System.out.println("Token is generating...");
            token = jwtService.generateToken(user);
//            System.out.println(token);
        }
        return "Token is : " + token;
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.loginUser(email);
    }
}
