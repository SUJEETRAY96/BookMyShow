package com.scaler.BookMyShow.controllers;

import com.scaler.BookMyShow.dtos.SignUpUserRequestDTO;
import com.scaler.BookMyShow.dtos.SignUpUserResponseDTO;
import com.scaler.BookMyShow.models.User;
import com.scaler.BookMyShow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    public SignUpUserResponseDTO signUpUser(SignUpUserRequestDTO request){
        User user = userService.signUpUser(request.getEmail(), request.getPassword());
        SignUpUserResponseDTO responseDTO = new SignUpUserResponseDTO();
        responseDTO.setUserId(user.getId());
        return responseDTO;
    }
}
