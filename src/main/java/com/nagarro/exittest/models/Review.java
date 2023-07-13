package com.nagarro.exittest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // 1. Unique identifier for the review

	private int rating; // 2. Rating given for the product
	private String title; // 3. Title or heading of the review

	private String description; // 4. Description or content of the review
	private Long productId; // 5. Identifier of the associated product
	private Boolean approved = false; // 6. Flag indicating whether the review is approved or not
	private Boolean cancel = false; // 7. Flag indicating whether the review is cancelled or not
	private String productName; // 8. Name of the associated product
	private String productCode; // 9. Code associated with the associated product


	public Review() {
		super();
	}

	/**
	 * Constructor for creating a Review object with all the fields.
	 * 
	 * @param rating       the rating given for the product (between 1 and 5)
	 * @param heading      the title or heading of the review
	 * @param review       the description or content of the review
	 * @param productId    the identifier of the associated product
	 * @param productName  the name of the associated product
	 * @param productCode  the code of the associated product
	 */
	public Review(@NotNull @Min(1) @Max(5) int rating, String heading, @Size(min = 20, max = 400) String review,
			Long productId, String productName, String productCode) {
		super();
		this.rating = rating; // 2
		this.title = heading; // 3
		this.description = review; // 4
		this.productId = productId; // 5
		this.productName = productName; // 8
		this.productCode = productCode; // 9
	}

	// Getters and setters for the review fields

	/**
	 * Get the rating of the review.
	 * 
	 * @return the rating
	 */
	public int getRating() {
		return rating; // 3
	}

	/**
	 * Set the rating of the review.
	 * 
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating; // 4
	}

	/**
	 * Get the title of the review.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title; // 5
	}

	/**
	 * Set the title of the review.
	 * 
	 * @param heading the title to set
	 */
	public void setTitle(String heading) {
		this.title = heading; // 6
	}

	/**
	 * Get the description of the review.
	 * 
	 * @return the description
	 */
	public String getReview() {
		return description; // 7
	}

	/**
	 * Set the description of the review.
	 * 
	 * @param review the description to set
	 */
	public void setReview(String review) {
		this.description = review; // 8
	}

	/**
	 * Get the identifier of the associated product.
	 * 
	 * @return the product ID
	 */
	public Long getProductId() {
		return productId; // 9
	}

	/**
	 * Set the identifier of the associated product.
	 * 
	 * @param productId the product ID to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId; // 10
	}

	/**
	 * Get the unique identifier of the review.
	 * 
	 * @return the review ID
	 */
	public long getId() {
		return id; // 11
	}

	/**
	 * Get the approval status of the review.
	 * 
	 * @return true if the review is approved, false otherwise
	 */
	public Boolean getApproved() {
		return approved; // 12
	}

	/**
	 * Get the cancellation status of the review.
	 * 
	 * @return true if the review is cancelled, false otherwise
	 */
	public Boolean getCancel() {
		return cancel; // 13
	}

	/**
	 * Set the cancellation status of the review.
	 * 
	 * @param cancel the cancellation status to set
	 */
	public void setCancel(Boolean cancel) {
		this.cancel = cancel; // 14
	}

	/**
	 * Set the approval status of the review.
	 * 
	 * @param approved the approval status to set
	 */
	public void setApproved(Boolean approved) {
		this.approved = approved; // 15
	}

	/**
	 * Get the name of the associated product.
	 * 
	 * @return the product name
	 */
	public String getProductName() {
		return productName; // 16
	}

	/**
	 * Set the name of the associated product.
	 * 
	 * @param productName the product name to set
	 */
	public void setProductName(String productName) {
		this.productName = productName; // 17
	}

	/**
	 * Get the code of the associated product.
	 * 
	 * @return the product code
	 */
	public String getProductCode() {
		return productCode; // 18
	}

	/**
	 * Set the code of the associated product.
	 * 
	 * @param productCode the product code to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode; // 19
	}
}

/**
 * This class represents a review for a product.
 * It contains information about the review, such as its unique identifier, rating, title, description,
 * associated product ID, approval status, cancellation status, and associated product name and code.
 * 
 * Fields:
 * 1. id: Unique identifier for the review.
 * 2. rating: Rating given for the product (between 1 and 5).
 * 3. title: Title or heading of the review.
 * 4. description: Description or content of the review.
 * 5. productId: Identifier of the associated product.
 * 6. approved: Flag indicating whether the review is approved or not.
 * 7. cancel: Flag indicating whether the review is cancelled or not.
 * 8. productName: Name of the associated product.
 * 9. productCode: Code associated with the associated product.
 * 
 * Important methods:
 * 1. Review():
 *    - Default constructor for Review.
 * 
 * 2. Review(int, String, String, Long, String, String):
 *    - Constructor for creating a Review object with all the fields.
 * 
 * 3. getRating():
 *    - Get the rating of the review.
 * 
 * 4. setRating(int):
 *    - Set the rating of the review.
 * 
 * 5. getTitle():
 *    - Get the title of the review.
 * 
 * 6. setTitle(String):
 *    - Set the title of the review.
 * 
 * 7. getReview():
 *    - Get the description of the review.
 * 
 * 8. setReview(String):
 *    - Set the description of the review.
 * 
 * 9. getProductId():
 *    - Get the identifier of the associated product.
 * 
 * 10. setProductId(Long):
 *     - Set the identifier of the associated product.
 * 
 * 11. getId():
 *     - Get the unique identifier of the review.
 * 
 * 12. getApproved():
 *     - Get the approval status of the review.
 * 
 * 13. getCancel():
 *     - Get the cancellation status of the review.
 * 
 * 14. setCancel(Boolean):
 *     - Set the cancellation status of the review.
 * 
 * 15. setApproved(Boolean):
 *     - Set the approval status of the review.
 * 
 * 16. getProductName():
 *     - Get the name of the associated product.
 * 
 * 17. setProductName(String):
 *     - Set the name of the associated product.
 * 
 * 18. getProductCode():
 *     - Get the code of the associated product.
 * 
 * 19. setProductCode(String):
 *     - Set the code of the associated product.
 */