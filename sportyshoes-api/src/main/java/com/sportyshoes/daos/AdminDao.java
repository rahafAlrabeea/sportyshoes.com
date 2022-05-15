package com.sportyshoes.daos;

import com.sportshoes.models.Admin;

public interface AdminDao {
	boolean signInAdmin(int admin_id, String password);

	Admin getAdminById(int admin_id);

	int changePassword(Admin admin);
}
