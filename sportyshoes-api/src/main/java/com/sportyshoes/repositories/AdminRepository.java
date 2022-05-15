package com.sportyshoes.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sportshoes.models.Admin;
import com.sportyshoes.daos.AdminDao;

@Repository
public class AdminRepository implements AdminDao {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public boolean signInAdmin(int admin_id, String password) {
		Boolean result = false;
		try {
			jdbc.queryForObject("select * from admins where admin_id=? AND password =?",
					BeanPropertyRowMapper.newInstance(Admin.class), admin_id, password);
			result = true;
		} catch (EmptyResultDataAccessException e) {
			return result;
		}
		return result;
	}

	@Override
	public Admin getAdminById(int admin_id) {
		return jdbc.queryForObject("select * from admins where admin_id =?",
				BeanPropertyRowMapper.newInstance(Admin.class), admin_id);
	}

	@Override
	public int changePassword(Admin admin) {
		return jdbc.update("UPDATE admins SET admin_name =?, password =? WHERE admin_id =?",
				new Object[] { admin.getAdmin_name(), admin.getPassword(), admin.getAdmin_id() });
	}
}
