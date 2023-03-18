package com.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.Product;

//JpaRepository interface that defines methods for all the CRUD operations on the entity, 
//and a default implementation of JpaRepository called SimpleJpaRepository.
public interface ProductRepository extends JpaRepository<Product, Long> {

	/*
	 * Returns an Optional which contains the found product entry by using its id as
	 * search criteria. If no product entry is found, this method returns an empty
	 * Optional.
	 */

	Optional<Product> findById(Long id);

}
