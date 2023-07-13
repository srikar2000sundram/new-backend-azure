package com.nagarro.exittest.impl;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.exittest.models.Product;
import com.nagarro.exittest.models.Status;
import com.nagarro.exittest.repository.ProductRepository;
import com.nagarro.exittest.services.ProductService;

import javassist.NotFoundException;

@Service
public class ProductServiceImpl implements ProductService {
/** This class provides the implementation for the ProductService interface.
 * It handles various operations related to products such as fetching, saving, searching, and deleting products.
 */

	@Autowired
	private ProductRepository productRepository;
	//	Note: The class utilizes the ProductRepository to interact with the underlying data source.

	/**
	 * Fetch products by name, brand, or product code.
	 *
	 * @param query the search query
	 * @return the list of matching products
	 */
	// 1. Fetch products by name, brand, or product code
	public List<Product> fetchProductByProductNameOrBrandOrProductCode(String query) {
		if (query != null) {
			return productRepository.findByKeyword(query);
		}
		return productRepository.findAll();
	}

	/**
	 * Save a product.
	 *
	 * @param product the product to save
	 * @return the saved product
	 */
	// 2. Save a product
	public Product saveProduct(Product product) {
		System.out.println(product.toString());
		return this.productRepository.save(product);
	}

	/**
	 * Show a single product by ID.
	 *
	 * @param productId the ID of the product
	 * @return the product with the specified ID, or null if not found
	 */
	// 3. Show a single product by ID
	public Product showSingleProduct(Long productId) {
		return this.productRepository.findById(productId).orElse(null);
	}
	
	/**
	 * Find a product by product code.
	 *
	 * @param productCode the product code
	 * @return the product with the specified product code, or null if not found
	 */
	// 4. Find a product by product code
	public Product findByProductCode(String productCode) {
		return this.productRepository.findByProductCode(productCode);
	}

	/**
	 * Find all products.
	 *
	 * @return the list of all products
	 */
	// 5. Find all products
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	/**
	 * Add a product.
	 *
	 * @param product the product to add
	 * @return the status of the operation
	 */
	// 6. Add a product
	public Status addProduct(@Valid Product product) {
		List<Product> products = productRepository.findAll();
		for (Product prod : products) {
			if (prod.equals(product)) {
				System.out.println("Product Already exists!");
				return Status.PRODUCT_ALREADY_EXISTS;
			}
		 }
		productRepository.save(product);
		return Status.SUCCESS;
	}
	
	/**
	 * Get the number of products.
	 *
	 * @return the number of products
	 */
	// 7. Get the number of products
	public int getNumberofProducts() {
		return (int) this.productRepository.count();
	}

	/**
	 * Delete a product by ID.
	 *
	 * @param productId the ID of the product to delete
	 * @throws NotFoundException if the product is not found
	 */
	// 8. Delete a product by ID
	public void deleteProduct(Long productId) throws NotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new NotFoundException("Product not found with ID: " + productId));
		productRepository.delete(product);
	}
}
/**
 *
 * 
 * Dependencies:
 * - Requires a ProductRepository for data access.
 * 
 * Important methods:
 * 1. fetchProductByProductNameOrBrandOrProductCode(String query):
 *    - Fetches products based on the provided query, which can be a name, brand, or product code.
 *    - If the query is null, it returns all products.
 * 
 * 2. saveProduct(Product product):
 *    - Saves a product to the database.
 * 
 * 3. showSingleProduct(Long productId):
 *    - Retrieves a single product by its ID.
 *    - Returns null if the product is not found.
 * 
 * 4. findByProductCode(String productCode):
 *    - Finds a product by its product code.
 *    - Returns null if the product is not found.
 * 
 * 5. findAll():
 *    - Retrieves all products from the database.
 * 
 * 6. addProduct(Product product):
 *    - Adds a new product to the database.
 *    - Checks if the product already exists and returns a status indicating the result.
 * 
 * 7. getNumberofProducts():
 *    - Gets the total number of products in the database.
 * 
 * 8. deleteProduct(Long productId):
 *    - Deletes a product from the database by its ID.
 *    - Throws a NotFoundException if the product is not found.
 * 
 * 
 */
