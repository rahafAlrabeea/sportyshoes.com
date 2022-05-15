package com.sportyshoes.daos;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sportshoes.models.Orders;



public interface OrdersDao {
	@Autowired
	List<Orders> getAllOrderByDatesASC() throws SQLException;
	List<Orders> getAllOrderByDatesDESC() throws SQLException;
	List<Orders> getAllOrderByIdsASC() throws SQLException;
	List<Orders> getAllOrderByIdsDESC() throws SQLException;
	List<Orders> getAllOrdersByProductId(int product_id);
	List<Orders> getAllOrdersByUserId(int user_id);
}
