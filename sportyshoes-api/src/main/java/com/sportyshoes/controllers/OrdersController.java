package com.sportyshoes.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportshoes.models.Orders;
import com.sportyshoes.services.OrdersService;

@RestController
public class OrdersController {
	@Autowired
	private OrdersService ordersService;

	OrdersController() {

	}

	OrdersController(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	@Autowired
	JdbcTemplate jdbc;

	@GetMapping("/api/order/all/sorted")
	public List<Orders> getAllOrdersSorted(@RequestParam("key") String key, @RequestParam("ordering") String ordering)
			throws SQLException {
		if ((key.equals("date")) && (ordering.equals("ASC"))) {
			return ordersService.getAllOrdersByDatesASC();
		} else if ((key.equals("date")) && (ordering.equals("DESC"))) {
			return ordersService.getAllOrdersByDatesDESC();
		} else if ((key.equals("order_id")) && (ordering.equals("ASC"))) {
			return ordersService.getAllOrdersByIdsASC();
		} else {
			return ordersService.getAllOrdersByIdsDESC();
		}

	}

	@GetMapping("/api/product/{product_id}/order/all")
	public List<Orders> getAllOrdersByProductId(@PathVariable("product_id") int product_id) throws SQLException {
		return ordersService.getOrdersByProductId(product_id);
	}

	@GetMapping("/api/user/{user_id}/order/all")
	public List<Orders> getAllOrdersByUserId(@PathVariable("user_id") int user_id) throws SQLException {
		return ordersService.getOrdersByUserId(user_id);
	}

}
