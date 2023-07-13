package com.nagarro.exittest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nagarro.exittest.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query method to find products by keyword
    
    // 1. Find products by keyword
    @Query("SELECT p FROM Product p WHERE p.productName LIKE %?1%"
            + " OR p.brand LIKE %?1%"
            + " OR p.productCode LIKE %?1%")
    public List<Product> findByKeyword(String keyword);

    // Query method to find a product by productCode
    
    // 2. Find a product by productCode
    public Product findByProductCode(String productCode);
    
    // Query method to find a product by productId 
    
    // 3. Find a product by productId 
    public Product findByProductId(int productId);
    
    // Query method to delete a product by productId
    
    // 4. Delete a product by productId
    public void deleteById(long productId);
}
