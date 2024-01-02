package com.scaler.BookMyShow;

import com.scaler.BookMyShow.controllers.UserController;
import com.scaler.BookMyShow.dtos.SignUpUserRequestDTO;
import com.scaler.BookMyShow.dtos.SignUpUserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

	private UserController userController;
	@Autowired
	public BookMyShowApplication(UserController userController){
		this.userController = userController;
	}

	@Override
	public void run(String... args) throws Exception {
		SignUpUserRequestDTO requestDTO = new SignUpUserRequestDTO();
		requestDTO.setEmail("sujeet@123");
		requestDTO.setPassword("Hello3");
		SignUpUserResponseDTO responseDTO = userController.signUpUser(requestDTO);
		System.out.println(responseDTO.getUserId());
	}

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

}
