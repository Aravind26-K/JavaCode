package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

//controller basically controls the flow of the data.

 
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProdutController {

	@Autowired
	private ProductService productService;

	// api to get all products
	@GetMapping("/list")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// api to create new product
	@PostMapping("/saveProduct")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	// api to update existing product
	@PutMapping("/list/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		productService.updateProduct(id, product);
		return product;
	}

	// api to delete product by id
	@DeleteMapping("/list/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return " Product deleted successfully";
	}

	// api to get product by id
	@GetMapping("/getProduct/{id}")
	public Product getProduct(@PathVariable Long id) {
		Product product = productService.getProductById(id);
		return product;
	}

}
