package com.blog.project.controller;

import com.blog.project.payload.ApiResponse;
import com.blog.project.payload.UserDto;
import com.blog.project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //post-create user
    //endpoint: /api/users/create
    @PostMapping("/create")
   public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto CreatedUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(CreatedUser, HttpStatus.CREATED);
    }

    //put update user
    //endpoint: /api/users/{userId}
    @PutMapping("{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable String userId, @RequestBody UserDto userDto){
        UserDto updatedUser = this.userService.updateUser(userDto, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //get-retrieve all users
    //endpoint: /api/users/all
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    //get-retrieve user by id
    //endpoint: /api/users/{userId}
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }


    // DELETE delete user
// Endpoint: /api/users/delete/{userId}
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId) {
        this.userService.deleteUserById(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }



}
