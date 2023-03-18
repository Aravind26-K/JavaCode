package com.product.service;

import java.util.List;

import com.product.entity.Product;

/*This layer will contain the business logic for the API and will be used to perform CRUD operations 
 * using the Repository.*/

public interface ProductService {

	// Display list of products
	List<Product> getAllProducts();

	// Create new product in database
	Product createProduct(Product newProduct);

	// To get details of product using product id
	Product getProductById(Long id);

	// To update existing product in database
	Product updateProduct(Long id, Product updateProduct);

	// To delete product from database
	void deleteProduct(Long id);

}
