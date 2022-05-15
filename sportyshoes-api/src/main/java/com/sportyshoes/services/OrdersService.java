package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sportshoes.models.Orders;
import com.sportyshoes.daos.OrdersDao;

@Service
public class OrdersService {
	OrdersService() {

	}
	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	private OrdersDao ordersRepository;

	OrdersService(OrdersDao ordersRepository) {
		super();
		this.ordersRepository = ordersRepository;
	}

	public List<Orders> getAllOrdersByDatesASC() throws SQLException {
			return this.ordersRepository.getAllOrderByDatesASC();
	}

	public List<Orders> getAllOrdersByDatesDESC() throws SQLException {
		return this.ordersRepository.getAllOrderByDatesDESC();
	}

	public List<Orders> getAllOrdersByIdsASC() throws SQLException {
		return this.ordersRepository.getAllOrderByIdsASC();
	}

	public List<Orders> getAllOrdersByIdsDESC() throws SQLException {
		return this.ordersRepository.getAllOrderByIdsDESC();
	}
	public List<Orders> getOrdersByProductId(int product_id) throws SQLException {
		return this.ordersRepository.getAllOrdersByProductId(product_id);
	}
	public List<Orders> getOrdersByUserId(int user_id) throws SQLException {
		return this.ordersRepository.getAllOrdersByUserId(user_id);
	}
}
