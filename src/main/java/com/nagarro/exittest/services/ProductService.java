package com.nagarro.exittest.services;

import java.util.List;

import javax.validation.Valid;

import com.nagarro.exittest.models.Product;
import com.nagarro.exittest.models.Status;

public interface ProductService {

    // 1. This interface defines the contract for the ProductService

    // 2. Fetch products by name, brand, or product code
    public List<Product> fetchProductByProductNameOrBrandOrProductCode(String query);

    // 3. Save a product
    public Product saveProduct(Product product);

    // 4. Show a single product by ID
    public Product showSingleProduct(Long productId);

    // 5. Find a product by product code
    public Product findByProductCode(String productCode);

    // 6. Find all products
    public List<Product> findAll();

    // 7. Add a product
    public Status addProduct(@Valid Product product);
}
