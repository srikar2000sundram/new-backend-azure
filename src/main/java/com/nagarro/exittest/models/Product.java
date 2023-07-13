package com.nagarro.exittest.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Product{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId; // 1. Unique identifier for the product
	
	private String productName; // 2. Name of the product
	private String brand; // 3. Brand of the product
	private double prodPrice; // 4. Price of the product

	
	private String productCode; // 5. Code associated with the product

	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "prod_code_fk", referencedColumnName = "productId")
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	private List<Review> prodReviews; // 6. List of reviews associated with the product

	
	
	public Product(Long productId, String productName, String brand, double prodPrice, String productCode,
			List<Review> prodReviews) {
		super();
		this.productId = productId; // 1
		this.productName = productName; // 2
		this.brand = brand; // 3
		this.prodPrice = prodPrice; // 4
		this.productCode = productCode; // 5
		this.prodReviews = prodReviews; // 6
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getters and setters for the product fields

	/**
	 * Get the name of the product.
	 * 
	 * @return the product name
	 */
	public String getProductName() {
		return productName; // 3
	}

	/**
	 * Set the name of the product.
	 * 
	 * @param productName the product name to set
	 */
	public void setProductName(String productName) {
		this.productName = productName; // 4
	}

	/**
	 * Get the brand of the product.
	 * 
	 * @return the product brand
	 */
	public String getBrand() {
		return brand; // 5
	}

	/**
	 * Set the brand of the product.
	 * 
	 * @param brand the product brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand; // 6
	}

	/**
	 * Get the code associated with the product.
	 * 
	 * @return the product code
	 */
	public String getProductCode() {
		return productCode; // 7
	}

	/**
	 * Set the code associated with the product.
	 * 
	 * @param productCode the product code to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode; // 8
	}

	/**
	 * Get the unique identifier of the product.
	 * 
	 * @return the product ID
	 */
	public Long getProductId() {
		return productId; // 9
	}

	/**
	 * Get the price of the product.
	 * 
	 * @return the product price
	 */
	public double getProdPrice() {
		return prodPrice; // 10
	}

	/**
	 * Set the price of the product.
	 * 
	 * @param prodPrice the product price to set
	 */
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice; // 11
	}

	/**
	 * Check if the product is present.
	 * 
	 * @return true if the product is present, false otherwise
	 */
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false; // 12
	}
}
/**
 * This class represents a product.
 * It contains information about the product, such as its unique identifier, name, brand, price, code, and reviews.
 * 
 * Fields:
 * 1. productId: Unique identifier for the product.
 * 2. productName: Name of the product.
 * 3. brand: Brand of the product.
 * 4. prodPrice: Price of the product.
 * 5. productCode: Code associated with the product.
 * 6. prodReviews: List of reviews associated with the product.
 * 
 * Important methods:
 * 1. Product(Long, String, String, double, String, List<Review>):
 *    - Constructor for creating a Product object with all the fields.
 * 
 * 2. Product():
 *    - Default constructor for Product.
 * 
 * 3. getProductName():
 *    - Get the name of the product.
 * 
 * 4. setProductName(String):
 *    - Set the name of the product.
 * 
 * 5. getBrand():
 *    - Get the brand of the product.
 * 
 * 6. setBrand(String):
 *    - Set the brand of the product.
 * 
 * 7. getProductCode():
 *    - Get the code associated with the product.
 * 
 * 8. setProductCode(String):
 *    - Set the code associated with the product.
 * 
 * 9. getProductId():
 *    - Get the unique identifier of the product.
 * 
 * 10. getProdPrice():
 *     - Get the price of the product.
 * 
 * 11. setProdPrice(double):
 *     - Set the price of the product.
 * 
 * 12. isPresent():
 *     - Check if the product is present.
 */
