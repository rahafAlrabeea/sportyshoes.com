package com.sportyshoes.repositories;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sportshoes.models.Products;
import com.sportyshoes.daos.ProductsDao;

@Repository
public class ProductsRepository implements ProductsDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<Products> getAllProducts() throws SQLException {

		return jdbc.query("select * from products", BeanPropertyRowMapper.newInstance(Products.class));
	}

	@Override
	public Products getProductByName(String product_name) throws SQLException {
		return jdbc.queryForObject("select * from products where product_name=?",
				BeanPropertyRowMapper.newInstance(Products.class), product_name);
	}

	@Override
	public Products getProductById(int product_id) throws SQLException {
		return jdbc.queryForObject("select * from products where product_id =?",
				BeanPropertyRowMapper.newInstance(Products.class), product_id);
	}

	@Override
	public int editMSRP(Products product) {
		return jdbc.update(
				"UPDATE products SET product_name =?,  MSRP =?, quantity_instock =?, product_vendor =? WHERE product_id =?",
				new Object[] { product.getProduct_name(), product.getMSRP(), product.getQuantity_instock(),
						product.getProduct_vendor(), product.getProduct_id() });
	}

	@Override
	public int editName(Products product) {
		return jdbc.update(
				"UPDATE products SET product_name =?,  MSRP =?, quantity_instock =?, product_vendor =? WHERE product_id =?",
				new Object[] { product.getProduct_name(), product.getMSRP(), product.getQuantity_instock(),
						product.getProduct_vendor(), product.getProduct_id() });
	}

	@Override
	public int editQuantityInStock(Products product) {
		return jdbc.update(
				"UPDATE products SET product_name =?,  MSRP =?, quantity_instock =?, product_vendor =? WHERE product_id =?",
				new Object[] { product.getProduct_name(), product.getMSRP(), product.getQuantity_instock(),
						product.getProduct_vendor(), product.getProduct_id() });
	}

	@Override
	public int editProductVendor(Products product) {
		return jdbc.update(
				"UPDATE products SET product_name =?,  MSRP =?, quantity_instock =?, product_vendor =? WHERE product_id =?",
				new Object[] { product.getProduct_name(), product.getMSRP(), product.getQuantity_instock(),
						product.getProduct_vendor(), product.getProduct_id() });
	}

	@Override
	public int addProduct(Products product) {
	return	jdbc.update(
				"insert into products(product_name, MSRP, quantity_instock, product_vendor)values(?,?,?,?)",
				new Object[] { product.getProduct_name(), product.getMSRP(), product.getQuantity_instock(),
						product.getProduct_vendor() });
	}
	@Override
	public int deleteProduct(int product_id) {
	return	jdbc.update("delete  from products where product_id =?", product_id);
	}

}
