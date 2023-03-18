package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

/*@Service annotation and allows developers to add business functionalities. 
The annotation is used with the classes that provide these business functionalities.*/
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	// Display list of products
	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	// Create new product in database
	@Override
	public Product createProduct(Product newProduct) {
		return productRepository.save(newProduct);
	}

	// To get details of product using product id
	@Override
	public Product getProductById(Long id) {
		Optional<Product> optional = productRepository.findById(id);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			throw new RuntimeException("Product not found" + id);
		}
		return product;
	}

	// To update existing product in database
	@Override
	public Product updateProduct(Long id, Product updateProduct) {
		Product existingProduct = productRepository.findById(updateProduct.getId()).get();
		existingProduct.setName(updateProduct.getName());
		existingProduct.setPrice(updateProduct.getPrice());
		existingProduct.setStock(updateProduct.getStock());
		Product updatedProduct = productRepository.save(existingProduct);
		return updatedProduct;
	}

	// To delete product from database
	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
