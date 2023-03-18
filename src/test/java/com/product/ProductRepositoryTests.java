package com.product;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

import org.junit.jupiter.api.MethodOrderer;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepositoryTests {
	@Autowired
	private ProductRepository productRepository;

	// Junit testcase for create product
	/*
	 * @Test
	 * 
	 * @Order(1)
	 * 
	 * @Rollback(value = false) public void saveEmployeeTest(){
	 * 
	 * Product product = Product.builder() .id(1L) .name("Oppo") .price(20000)
	 * .stock(5L) .build();
	 * 
	 * productRepository.save(product);
	 * 
	 * Assertions.assertThat(product.getId()).isGreaterThan(0); }
	 */

	@Test
	@Order(2)
	public void getProduct() {

		Product product = productRepository.findById(1L).get();

		Assertions.assertThat(product.getId()).isEqualTo(1L);

	}

	@Test
	@Order(3)
	public void getListOfProducts() {

		List<Product> products = productRepository.findAll();

		Assertions.assertThat(products.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateProduct() {

		Product product = productRepository.findById(1L).get();

		product.setName("Samsung");

		Product updatedProduct = productRepository.save(product);

		Assertions.assertThat(updatedProduct.getName()).isEqualTo("Samsung");

	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteProduct() {

		Product product = productRepository.findById(1L).get();

		productRepository.delete(product);

		// productRepository.deleteById(1L);

		Product product1 = null;

		Optional<Product> optionalProduct = productRepository.findById(1L);

		if (optionalProduct.isPresent()) {
			product1 = optionalProduct.get();
		}

		Assertions.assertThat(product1).isNull();
	}

}
