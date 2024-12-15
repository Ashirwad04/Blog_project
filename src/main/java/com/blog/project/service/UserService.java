package com.blog.project.service;

import com.blog.project.model.User;
import com.blog.project.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,String userId);
    UserDto getUserById(String userId);
    List<UserDto> getAllUsers();
    void deleteUserById(String userId);


}
