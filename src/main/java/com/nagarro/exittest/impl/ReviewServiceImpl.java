package com.nagarro.exittest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.exittest.models.Review;
import com.nagarro.exittest.repository.ReviewRepository;
import com.nagarro.exittest.services.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	/**
	 * Adds a new review to the database.
	 *
	 * @param review The review to be added.
	 * @return The added review.
	 */
	public Review addReview(Review review) {
		return this.reviewRepository.save(review); //ReviewRepository.save(review)
	}

	/**
	 * Retrieves a list of reviews based on the given product ID.
	 *
	 * @param productId The ID of the product.
	 * @return A list of reviews for the specified product.
	 */
	public List<Review> findByProductId(Long productId) {
		return this.reviewRepository.findByProductId(productId); //ReviewRepository.findByProductId(productId)
	}

	/**
	 * Retrieves a list of reviews for a specific product.
	 *
	 * @param productId The ID of the product.
	 * @return A list of reviews for the specified product.
	 */
	public List<Review> showProductReview(Long productId) {
		return this.reviewRepository.findAllById(productId); //ReviewRepository.findAllById(productId)
	}

	/**
	 * Retrieves all reviews from the database.
	 *
	 * @return A list of all reviews.
	 */
	public List<Review> findAll() {
		return this.reviewRepository.findAll(); //ReviewRepository.findAll()
	}

	/**
	 * Retrieves all reviews from the database.
	 *
	 * @return A list of all reviews.
	 */
	public List<Review> findAllReviews() {
		return this.reviewRepository.findAllReviews(); //ReviewRepository.findAllReviews()
	}

	/**
	 * Saves a review in the database.
	 *
	 * @param review The review to be saved.
	 */
	public void save(Review review) {
		this.reviewRepository.save(review); //ReviewRepository.save(review)
	}

	/**
	 * Deletes a review from the database.
	 *
	 * @param review The review to be deleted.
	 */
	public void delete(Review review) {
		this.reviewRepository.delete(review); //ReviewRepository.delete(review)
	}
}

/**
 * This class provides the implementation for the ReviewService interface.
 * It handles operations related to reviews, including adding, retrieving, and deleting reviews.
 * 
 * Dependencies:
 * - Requires a ReviewRepository for data access.
 * 
 * Important methods:
 * 1. addReview(Review review):
 *    - Adds a new review to the database.
 *    - Returns the added review.
 * 
 * 2. findByProductId(Long productId):
 *    - Retrieves a list of reviews based on the given product ID.
 *    - Returns a list of reviews for the specified product.
 * 
 * 3. showProductReview(Long productId):
 *    - Retrieves a list of reviews for a specific product.
 *    - Returns a list of reviews for the specified product.
 * 
 * 4. findAll():
 *    - Retrieves all reviews from the database.
 *    - Returns a list of all reviews.
 * 
 * 5. findAllReviews():
 *    - Retrieves all reviews from the database.
 *    - Returns a list of all reviews.
 * 
 * 6. save(Review review):
 *    - Saves a review in the database.
 * 
 * 7. delete(Review review):
 *    - Deletes a review from the database.
 * 
 * Note: The class utilizes the ReviewRepository to interact with the underlying data source.
 */