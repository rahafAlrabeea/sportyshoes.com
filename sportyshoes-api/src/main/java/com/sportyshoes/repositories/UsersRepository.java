package com.sportyshoes.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sportshoes.models.Admin;
import com.sportshoes.models.Users;
import com.sportyshoes.daos.UsersDao;

@Repository
public class UsersRepository implements UsersDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public boolean signInUser(int user_id, String password) {
		Boolean result = false;
		try {
			jdbc.queryForObject("select * from users where user_id=? AND password =?",
					BeanPropertyRowMapper.newInstance(Users.class), user_id, password);
			result = true;
		} catch (EmptyResultDataAccessException e) {
			return result;
		}
		return result;
	}

	@Override
	public int signUp(Users user) {
		return jdbc.update("insert into users values(?,?,?)",
				new Object[] { user.getUser_id(), user.getFull_name(), user.getPassword() });
	}

	@Override
	public List<Users> getAllUsers() {

		return jdbc.query("select user_id, full_name from users", BeanPropertyRowMapper.newInstance(Users.class));
	}

	@Override
	public Users getUserByName(String name) {

		return jdbc.queryForObject("select user_id, full_name from users where full_name =?",
				BeanPropertyRowMapper.newInstance(Users.class), name);
	}

	@Override
	public Users getUserById(int user_id) {

		return jdbc.queryForObject("select * from users where user_id =?",
				BeanPropertyRowMapper.newInstance(Users.class), user_id);
	}

	@Override
	public int editUserPassword(Users user) {

		return jdbc.update("UPDATE users SET full_name =?, password =? WHERE user_id =?",
				new Object[] { user.getFull_name(), user.getPassword(), user.getUser_id() });
	}

	@Override
	public int editUserName(Users user) {

		return jdbc.update("UPDATE users SET full_name =?, password =? WHERE user_id =?",
				new Object[] { user.getFull_name(), user.getPassword(), user.getUser_id() });
	}
	

}
