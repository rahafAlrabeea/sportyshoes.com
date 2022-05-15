package com.sportyshoes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportshoes.models.Admin;
import com.sportyshoes.daos.AdminDao;

@Service
public class AdminServices {

	public AdminServices() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private AdminDao adminRepository;

	public AdminServices(AdminDao adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	public Boolean signInAdmin(int admin_id, String password) {
		// login code
		boolean validUser = adminRepository.signInAdmin(admin_id, password);
		if (!validUser) {
			return false;
		}

		return true;
	}

	public Admin getAdminById(int admin_id) {

		return this.adminRepository.getAdminById(admin_id);
	}

	public int changePassword(Admin updatedAdmin) {
		return this.adminRepository.changePassword(updatedAdmin);

	}
}
