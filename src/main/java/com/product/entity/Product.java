package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.*;

/*The entities are the persistence objects stores as a record in the database.*/
@Entity
@Table(name = "product")
public class Product {
	// @Id annotation specifies the primary key of an entity
	@Id
	// @GeneratedValue provides for the specification of generation strategies for
	// the values of primary keys
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public Product(long id, String name, double price, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public Product() {

	}

	// @Column -->enables you to customize the mapping between the entity attribute
	// and the database column
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private int stock;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
