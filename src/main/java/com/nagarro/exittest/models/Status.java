package com.nagarro.exittest.models;

public enum Status {
	SUCCESS, // 1. Represents a successful operation
	USER_ALREADY_EXISTS, // 2. Indicates that a user already exists
	FAILURE, // 3. Represents a failed operation
	PRODUCT_ALREADY_EXISTS, // 4. Indicates that a product already exists
	REVIEW_ALREADY_EXISTS, // 5. Indicates that a review already exists
	REVIEW_ADDED, // 6. Indicates that a review has been successfully added
}