package com.blog.project.service.impl;

import com.blog.project.Exception.ResourseNotFoundException;
import com.blog.project.model.User;
import com.blog.project.payload.UserDto;
import com.blog.project.repository.UserRepo;
import com.blog.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;



//create user
    @Override
    public UserDto createUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

//update user

    @Override
    public UserDto updateUser(UserDto userDto,String userId) {

        User user = this.userRepo.findById(userId).
                orElseThrow(() -> new ResourseNotFoundException("User", "Id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepo.save(user);
        return this.userToDto(updatedUser);
    }


    @Override
    public UserDto getUserById(String userId) {
        User user = this.userRepo.findById(userId).
                orElseThrow(() -> new ResourseNotFoundException("User", "Id", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUserById(String userId) {
        User user = this.userRepo.findById(userId).
                orElseThrow(() -> new ResourseNotFoundException("User", "Id", userId));
        this.userRepo.delete(user);
    }






    public User dtoToUser(UserDto userDto) {

            User newUser = this.modelMapper.map(userDto,User.class);
//      User newUser = new User();
//        newUser.setId(user.getId());
//        newUser.setName(user.getName());
//        newUser.setEmail(user.getEmail());
//        newUser.setPassword(user.getPassword());
//        newUser.setAbout(user.getAbout());
        return newUser;
    }

    public UserDto userToDto(User user) {

        UserDto newUserDto = this.modelMapper.map(user,UserDto.class);
//        UserDto newUserDto = new UserDto();
//        newUserDto.setId(user.getId());
//        newUserDto.setName(user.getName());
//        newUserDto.setEmail(user.getEmail());
//        newUserDto.setPassword(user.getPassword());
//        newUserDto.setAbout(user.getAbout());
        return newUserDto;
    }
}
