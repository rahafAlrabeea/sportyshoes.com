package com.sportyshoes.daos;

import java.sql.SQLException;
import java.util.List;

import com.sportshoes.models.Products;



public interface ProductsDao {
	List<Products> getAllProducts() throws SQLException;
	Products getProductByName(String product_name) throws SQLException;
	Products getProductById(int product_id)throws SQLException;
	int editMSRP(Products product);
	int editName(Products product);
	int editQuantityInStock(Products product);
	int editProductVendor(Products product);
	int addProduct(Products product);
	int deleteProduct(int product_id);
}
