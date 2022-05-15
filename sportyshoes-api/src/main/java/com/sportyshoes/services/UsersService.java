package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportshoes.models.Admin;
import com.sportshoes.models.Users;
import com.sportyshoes.daos.UsersDao;

@Service
public class UsersService {
	UsersService() {

	}

	@Autowired
	private UsersDao UsersRepository;

	UsersService(UsersDao UsersRepository) {
		super();
		this.UsersRepository = UsersRepository;
	}

	public Boolean signUpUser(Users user) {
		// Users user = new Users(user_id, full_name, password);
		return this.UsersRepository.signUp(user) > 0;

	}

	public Boolean signInUser(int user_id, String password) {
		// login code
		boolean validUser = UsersRepository.signInUser(user_id, password);
		if (!validUser) {
			return false;
		}

		return true;
	}

	public List<Users> getAllUsers() throws SQLException {
		return this.UsersRepository.getAllUsers();
	}

	public Users getUserByName(String name) throws SQLException {
		return this.UsersRepository.getUserByName(name);
	}

	public Users getUserById(int user_id) throws SQLException {
		return this.UsersRepository.getUserById(user_id);
	}

	public int editUserPassword(Users user) throws SQLException {
		return this.UsersRepository.editUserPassword(user);
	}

	public int editUserName(Users user) throws SQLException {
		return this.UsersRepository.editUserName(user);
	}

	

}
