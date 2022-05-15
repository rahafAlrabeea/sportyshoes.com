package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportshoes.models.Products;
import com.sportyshoes.daos.ProductsDao;


@Service
public class ProductsService {
	@Autowired
	private ProductsDao productsRepository;

	ProductsService(ProductsDao productsRepository) {
		super();
		this.productsRepository = productsRepository;
	}

	public List<Products> getAllProducts() throws SQLException {
		return this.productsRepository.getAllProducts();
	}

	public Products getProductByName(String product_name) throws SQLException {
		return this.productsRepository.getProductByName(product_name);
	}

	public Products getProductById(int product_id) throws SQLException {
		return this.productsRepository.getProductById(product_id);
	}
	public int editMSRP(Products product) throws SQLException {
		return this.productsRepository.editMSRP(product);
	}
	public int editName(Products product) throws SQLException {
		return this.productsRepository.editName(product);
	}
	public int editQuantityInStock(Products product) throws SQLException {
		return this.productsRepository.editQuantityInStock(product);
	}
	public int editProductVendor(Products product) throws SQLException {
		return this.productsRepository.editProductVendor(product);
	}
	
	public int addProduct(Products product) {
		return this.productsRepository.addProduct(product);
	}
	public int deleteProduct(int product_id) {
		return this.productsRepository.deleteProduct(product_id);
	}

}
