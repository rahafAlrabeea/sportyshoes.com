package com.sportyshoes.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportshoes.models.Products;
import com.sportyshoes.services.ProductsService;

@RestController
public class ProductsController {
	@Autowired
	private ProductsService productsService;

	ProductsController(ProductsService productsService) {
		this.productsService = productsService;
	}

	@Autowired
	JdbcTemplate jdbc;

	@GetMapping("/api/product/all/{product_id}")
	public Products findProductById(@PathVariable("product_id") int product_id) throws SQLException {

		return productsService.getProductById(product_id);
	}

	@GetMapping("/api/product/all")
	public List<Products> getAllProducts() throws SQLException {

		return productsService.getAllProducts();
	}

	@GetMapping("/api/product/search")
	public Products findProductByName(@RequestParam("name") String product_name) throws SQLException {

		return productsService.getProductByName(product_name);
	}

	@PatchMapping("/api/product/{product_id}/update/name")
	public String editName(@PathVariable("product_id") int product_id, @RequestBody Products product)
			throws SQLException {
		Products updatedproduct = productsService.getProductById(product_id);
		updatedproduct.setProduct_id(product_id);
		updatedproduct.setProduct_name(product.getProduct_name());
		updatedproduct.getMSRP();
		updatedproduct.getQuantity_instock();
		updatedproduct.getProduct_vendor();
		productsService.editName(updatedproduct);
		return "Name has been changed.. ";
	}

	@PatchMapping("/api/product/{product_id}/update/MSRP")
	public String editMSRP(@PathVariable("product_id") int product_id, @RequestBody Products product)
			throws SQLException {
		Products updatedproduct = productsService.getProductById(product_id);
		updatedproduct.setProduct_id(product_id);
		updatedproduct.getProduct_name();
		updatedproduct.setMSRP(product.getMSRP());
		updatedproduct.getQuantity_instock();
		updatedproduct.getProduct_vendor();
		productsService.editMSRP(updatedproduct);
		return "MSRP has been changed.. ";
	}

	@PatchMapping("/api/product/{product_id}/update/quantityInStock")
	public String editQuantityInStock(@PathVariable("product_id") int product_id, @RequestBody Products product)
			throws SQLException {
		Products updatedproduct = productsService.getProductById(product_id);
		updatedproduct.setProduct_id(product_id);
		updatedproduct.getProduct_name();
		updatedproduct.getMSRP();
		updatedproduct.setQuantity_instock(product.getQuantity_instock());
		updatedproduct.getProduct_vendor();
		productsService.editQuantityInStock(updatedproduct);
		return "QuantityInStock has been changed.. ";
	}

	@PatchMapping("/api/product/{product_id}/update/productvendor")
	public String editProductVendor(@PathVariable("product_id") int product_id, @RequestBody Products product)
			throws SQLException {
		Products updatedproduct = productsService.getProductById(product_id);
		updatedproduct.setProduct_id(product_id);
		updatedproduct.getProduct_name();
		updatedproduct.getMSRP();
		updatedproduct.getQuantity_instock();
		updatedproduct.setProduct_vendor(product.getProduct_vendor());
		productsService.editProductVendor(updatedproduct);
		return "Product vendor has been changed.. ";
	}

	@PostMapping("/api/product/add")
	public String addProduct(@RequestBody Products product) {
		productsService.addProduct(product);
		return "Product has been created";
	}

	@DeleteMapping("/api/product/{product_id}/delete")
	public String deleteProduct(@PathVariable("product_id") int product_id) {
		productsService.deleteProduct(product_id);
		return "Product has been deleted..";
	}

}
