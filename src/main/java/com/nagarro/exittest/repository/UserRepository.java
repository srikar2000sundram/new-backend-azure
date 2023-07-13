package com.nagarro.exittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.exittest.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 1. This repository is responsible for managing the User entity

    // 2. The JpaRepository<User, Long> interface specifies that this repository handles User entities
    //    The Long type represents the data type of the user's ID field

    // 3. By extending JpaRepository<User, Long>, this repository inherits various methods for basic CRUD operations

    // 4. This method retrieves a user by their email and password
    public User findByEmailAndPassword(String email, String password);
    // 5. This method retrieves a user by their email using a custom query
    //    The @Query annotation allows you to define a custom query using JPQL (Java Persistence Query Language)
    //    The :email parameter in the query is mapped to the method's @Param("email") annotation
    @Query("select u from User u where u.email = :email")
    public User getUserByEmail(@Param("email") String email); 
}
