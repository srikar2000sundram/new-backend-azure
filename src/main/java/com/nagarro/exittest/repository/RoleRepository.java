package com.nagarro.exittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.exittest.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // 1. This repository is responsible for managing the Role entity

    // 2. No custom methods or queries defined in this repository
    //    The JpaRepository interface provides default implementations for common CRUD operations

    // 3. By extending JpaRepository<Role, Long>, this repository inherits the following methods:
    //    - save(Role entity): Saves a role to the database
    //    - findById(Long id): Retrieves a role by its ID
    //    - findAll(): Retrieves all roles
    //    - delete(Role entity): Deletes a role from the database

    // 4. You can use these inherited methods to perform basic CRUD operations on the Role entity

}
