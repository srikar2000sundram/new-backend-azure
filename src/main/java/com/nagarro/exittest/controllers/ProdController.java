package com.nagarro.exittest.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exittest.impl.ProductServiceImpl;
import com.nagarro.exittest.models.Product;
import com.nagarro.exittest.models.Status;
import javassist.NotFoundException;

@RestController
@CrossOrigin("*")
public class ProdController {
    
    @Autowired
    private ProductServiceImpl productService;

    /**
     * 2. Save a product.
     *
     * @param product the product to save
     * @return the status of the operation
     */
    
    // API: Save a product
    // Endpoint: POST /allProducts
    // Incoming: Product object in the request body
    // Outgoing: Status object indicating the result of the operation
    @PostMapping("/allProducts")
    public Status saveProduct(@Valid @RequestBody Product product) {
        return productService.addProduct(product);
    }

    /**
     * 3. Fetch products based on a search query.
     *
     * @param query the search query
     * @return the list of matching products
     * @throws Exception if the products are not found
     */
    
    // API: Fetch products based on a search query
    // Endpoint: GET /products
    // Incoming: query parameter representing the search query
    // Outgoing: List of Product objects matching the search query
    @GetMapping("/products")
    @CrossOrigin("*")
    public List<Product> product(@RequestParam String query) throws Exception {
        try {
            List<Product> products = this.productService.fetchProductByProductNameOrBrandOrProductCode(query);
            return products;
        } catch (Exception e) {
            throw new Exception("Product Not Found!");
        }
    }

    /**
     * 4. Fetch all products.
     *
     * @return the list of all products
     * @throws Exception if the products are not found
     */
    
    // API: Fetch all products
    // Endpoint: GET /allProducts
    // Outgoing: List of all Product objects
    @GetMapping("/allProducts")
    @CrossOrigin("*")
    public List<Product> products() throws Exception {
        try {
            List<Product> products = this.productService.findAll();
            return products;
        } catch (Exception e) {
            throw new Exception("Product Not Found!");
        }
    }
    
    /**
     * 6. Fetch all products.
     *
     * @return the list of all products
     */
    
    // API: Fetch all products
    // Endpoint: GET /user/products
    // Outgoing: List of all Product objects
    @GetMapping("/user/products")
    @CrossOrigin("*")
    public List<Product> showProducts() {
        return this.productService.findAll();
    }
    
    /**
     * 10. Get a product by ID.
     *
     * @param productId the ID of the product
     * @return the product with the given ID
     */
    
    // API: Get a product by ID
    // Endpoint: GET /getProduct/{productId}
    // Incoming: Path variable representing the product ID
    // Outgoing: Product object with the given ID
    @GetMapping("/getProduct/{productId}")
    public Product getProductById(@PathVariable long productId) {
        Product product = productService.showSingleProduct(productId);
        return product;
    }
    
    /**
     * 9. Add a new product.
     *
     * @param product the product to add
     * @return the added product
     * @throws Exception if the product cannot be added
     */
    
    // API: Add a new product
    // Endpoint: POST /addProduct
    // Incoming: Product object in the request body
    // Outgoing: Added Product object
    @CrossOrigin("*")
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) throws Exception {
        try {
            System.out.println(product);
            return this.productService.saveProduct(product);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    
    /**
     * 18. Delete a product.
     *
     * @param productId the ID of the product to delete
     * @throws NotFoundException if the product is not found
     */
    
    // API: Delete a product
    // Endpoint: DELETE /delete/{productId}
    // Incoming: Path variable representing the product ID
    // Outgoing: None (void)
    @DeleteMapping("/delete/{productId}")
    @CrossOrigin("*")
    public void deleteProduct(@PathVariable("productId") Long productId) throws NotFoundException {
        productService.deleteProduct(productId);
    }
}
