package com.sportyshoes.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportshoes.models.Admin;
import com.sportyshoes.services.AdminServices;

@RestController
public class AdminController {
	public AdminController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private AdminServices adminService;

	public AdminController(AdminServices adminService) {
		super();
		this.adminService = adminService;
	}

	@Autowired
	JdbcTemplate jdbc;

	@PostMapping("/api/admin/signin")
	public String signInAdmin(@RequestParam("admin_id") int admin_id, @RequestParam("password") String password) {
		String signInResponse = null;
		System.out.println(admin_id + password);
		boolean userAuthenticated = adminService.signInAdmin(admin_id, password);
		System.out.println("auth: " + userAuthenticated);
		if (userAuthenticated) {

			signInResponse = "User has been authenticated successfully..";
		} else {

			signInResponse = "Incorrect credentials..";
		}
		return signInResponse;

	}

	@PatchMapping("/api/admin/{admin_id}/update/password")
	public String changePassword(@PathVariable("admin_id") int admin_id, @RequestBody Admin admin) throws SQLException {
		System.out.println(admin.toString());
		Admin updatedAdmin = adminService.getAdminById(admin_id);
		updatedAdmin.setAdmin_id(admin_id);
		updatedAdmin.setPassword(admin.getPassword());
		updatedAdmin.getAdmin_name();
		adminService.changePassword(updatedAdmin);
		return "Password has been changed.. ";
	}
}
