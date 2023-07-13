package com.nagarro.exittest.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exittest.impl.ProductServiceImpl;
import com.nagarro.exittest.impl.ReviewServiceImpl;
import com.nagarro.exittest.models.Product;
import com.nagarro.exittest.models.Review;

@RestController
@CrossOrigin("*")
public class ReviewController {
    @Autowired
    private ProductServiceImpl productService; 
    @Autowired
    private ReviewServiceImpl reviewService;
    
    /**
     * 7. Fetch all reviews.
     *
     * @return the list of all reviews
     */
    @GetMapping("/user/reviews")
    public List<Review> showReviews() {
        return this.reviewService.findAllReviews(); // Going to ReviewServiceImpl.findAllReviews()
    }

    /**
     * 8. Fetch all reviews (admin only).
     *
     * @return the list of all reviews
     */
    @GetMapping("/admin/reviews") 
    public List<Review> showAllReviews() {
        return this.reviewService.findAll(); // Going to ReviewServiceImpl.findAll()
    }

    /**
     * 11. Add a new review.
     *
     * @param review the review to add
     * @return the added review
     * @throws Exception if the review cannot be added
     */
    @CrossOrigin("*")
    @PostMapping("/addReview") 
    public Review addReview(@RequestBody Review review) throws Exception {
        try {
            System.out.println(review);
            return this.reviewService.addReview(review); // Going to ReviewServiceImpl.addReview()
        } catch (Exception e) {
            throw new Exception("Bad Data");
        }
    }

    /**
     * 12. Fetch reviews for a specific product.
     *
     * @param productId the ID of the product
     * @return the list of reviews for the product
     * @throws Exception if the product is not found
     */
    @CrossOrigin("*")
    @GetMapping("products/{productId}/showReviews") 
    public List<Review> showProductReview(@PathVariable Long productId) throws Exception {
        try {
            return this.reviewService.showProductReview(productId); // Going to ReviewServiceImpl.showProductReview() 
        } catch (Exception e) {
            throw new Exception("Product Not Found");
        }
    }

    /**
     * 14. Approve a review.
     *
     * @param review the review to approve
     * @return true if the review is approved successfully
     * @throws Exception
     */
    @PutMapping("review/approve") 
    @CrossOrigin("*")
    public Boolean approveReview(@RequestBody Review review) throws Exception {
        try {
            review.setApproved(true);
            this.reviewService.save(review); // Going to ReviewServiceImpl.save() 
            return true;
        } catch (Exception e) {
            throw new Exception("Something went wrong!!");
        }
    }

    /**
     * 15. Cancel a review.
     *
     * @param review the review to cancel
     * @return true if the review is canceled successfully
     * @throws Exception if an error occurs during the cancellation
     */
    @PutMapping("review/cancel") 
    @CrossOrigin("*")
    public Boolean cancelReview(@RequestBody Review review) throws Exception {
        try {
            review.setCancel(false);
            // Going to ReviewServiceImpl.delete() from package "com.nagarro.exittest.impl"
            this.reviewService.delete(review); 
            return true;
        } catch (Exception e) {
            throw new Exception("Something went wrong!!");
        }
    }

    /**
     * 17. Request reviews for a product.
     *
     * @param product the product to request reviews for
     * @return the list of reviews for the product
     */
    @PostMapping("review/request")
    @CrossOrigin("*")
    public ResponseEntity<List<Review>> requestReviews(@RequestBody Product product) {
    	// Going to ProductServiceImpl.findByProductCode() from package "com.nagarro.exittest.impl"
        Product p = this.productService.findByProductCode(product.getProductCode()); 
        if (p != null) {
        	// Going to ReviewServiceImpl.findByProductId() from package "com.nagarro.exittest.impl"
            List<Review> reviews = this.reviewService.findByProductId(p.getProductId()); 
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
