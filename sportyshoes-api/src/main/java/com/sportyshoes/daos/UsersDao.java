package com.sportyshoes.daos;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sportshoes.models.Admin;
import com.sportshoes.models.Users;
@Component
public interface UsersDao {
	
		boolean signInUser(int user_id, String password);
		int signUp(Users user);
		List<Users> getAllUsers() throws SQLException;
		Users getUserByName(String name) throws SQLException;
		Users getUserById(int user_id)throws SQLException;
		int editUserPassword(Users user);
		int editUserName(Users user);
		

}
