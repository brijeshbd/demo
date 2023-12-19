package com.auth.brijesh.dao;

import com.auth.brijesh.model.User;
import com.auth.brijesh.model.UserType;
import com.auth.brijesh.model.request.UserRequest;
import com.auth.brijesh.model.response.UserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public String saveUser(UserRequest user, String password, UserType userType) {
        String saveUser = "INSERT INTO root.user (first_name, last_name, email, password, user_type) VALUES (?,?,?,?,?)";
        int data = jdbc.update(saveUser, new Object[]{user.getFirstName(), user.getLastName(), user.getEmail(), password, userType.name()});
        if(data==1){
            return "Saved Successfully...";
        } else {
            return "Sorry Please Try Again...";
        }
    }

    @Override
    public User loginUser(String email) {
        String loginUser = "SELECT * FROM root.user where email=?";
        try {
            return jdbc.queryForObject(loginUser, new Object[]{email}, (resultSet, rowNum) -> {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case when no user is found with the given email
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }
}
