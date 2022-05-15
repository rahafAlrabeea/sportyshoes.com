package com.sportyshoes.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportshoes.models.Admin;
import com.sportshoes.models.Users;
import com.sportyshoes.services.UsersService;

@RestController
public class UsersController {
	UsersController() {

	}

	@Autowired
	private UsersService usersService;

	UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	@Autowired
	JdbcTemplate jdbc;

	@GetMapping("/api/user/all/{user_id}")
	public Users findUserById(@PathVariable("user_id") int user_id) throws SQLException {

		return usersService.getUserById(user_id);
	}

	@GetMapping("/api/user/all")
	public List<Users> getAllUsers() throws SQLException {

		return usersService.getAllUsers();
	}

	@GetMapping("/api/user/search")
	public Users findUserByName(@RequestParam("name") String name) throws SQLException {

		return usersService.getUserByName(name);
	}

	@PatchMapping("/api/user/{user_id}/update/password")
	public String editUserPassword(@PathVariable("user_id") int user_id, @RequestBody Users user) throws SQLException {
		System.out.println(user.toString());
		Users updatedUser = usersService.getUserById(user_id);
		updatedUser.setUser_id(user_id);
		updatedUser.setPassword(user.getPassword());
		updatedUser.getFull_name();
		usersService.editUserPassword(updatedUser);
		return "Password has been changed.. ";
	}

	@PatchMapping("/api/user/{user_id}/update/name")
	public String editUserName(@PathVariable("user_id") int user_id, @RequestBody Users user) throws SQLException {
		Users updatedUser = usersService.getUserById(user_id);
		updatedUser.setUser_id(user_id);
		updatedUser.getPassword();
		updatedUser.setFull_name(user.getFull_name());
		usersService.editUserName(updatedUser);
		return "Name has been changed.. ";
	}

	@PostMapping("/api/user/signup")
	public String UserSignup(@RequestBody Users user) throws SQLException {
		usersService.signUpUser(user);

		return "registered.. ";
	}

	@PostMapping("/api/user/signin")
	public String signIn(@RequestParam("user_id") int user_id, @RequestParam("password") String password) {
		String signInResponse = null;
		System.out.println(user_id + password);

		boolean userAuthenticated = usersService.signInUser(user_id, password);

		System.out.println("auth: " + userAuthenticated);
		if (userAuthenticated) {

			signInResponse = "User has been authenticated successfully..";
		} else {

			signInResponse = "Incorrect credentials..";
		}
		return signInResponse;

	}

	
}
