package com.sportyshoes.repositories;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sportshoes.models.Orders;
import com.sportyshoes.daos.OrdersDao;

@Repository
public class OrderRepository implements OrdersDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<Orders> getAllOrderByDatesASC() throws SQLException {
		return jdbc.query("select * from orders order by date", BeanPropertyRowMapper.newInstance(Orders.class));
	}

	@Override
	public List<Orders> getAllOrderByDatesDESC() throws SQLException {
		return jdbc.query("select * from orders order by date desc", BeanPropertyRowMapper.newInstance(Orders.class));
	}

	@Override
	public List<Orders> getAllOrderByIdsASC() throws SQLException {
		return jdbc.query("select * from orders order by order_id",
				BeanPropertyRowMapper.newInstance(Orders.class));
	}

	@Override
	public List<Orders> getAllOrderByIdsDESC() throws SQLException {
		return jdbc.query("select * from orders order by order_id desc",
				BeanPropertyRowMapper.newInstance(Orders.class));
	}

	@Override
	public List<Orders> getAllOrdersByProductId(int product_id) {

		return jdbc.query("select * from orders where product_id =?", BeanPropertyRowMapper.newInstance(Orders.class),
				product_id);
	}

	@Override
	public List<Orders> getAllOrdersByUserId(int user_id) {

		return jdbc.query("select * from orders where user_id =?", BeanPropertyRowMapper.newInstance(Orders.class),
				user_id);
	}

}
