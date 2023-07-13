package com.nagarro.exittest.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exittest.impl.UserServiceImpl;
import com.nagarro.exittest.models.Role;
import com.nagarro.exittest.models.User;
import com.nagarro.exittest.models.UserRole;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceImpl userService;

    /**
     * 1. Register a new user.
     *
     * @param user the user to register
     * @return the registered user
     * @throws Exception if the user already exists
     */
    @PostMapping("/user/register") // API called from external client to register a new user
    @CrossOrigin("*")
    public User register(@RequestBody User user) throws Exception {
        try {
            // Encode the password
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            Set<UserRole> roles = new HashSet<>();
            Role role = new Role();
            if (user.getEmail().equalsIgnoreCase("srikar2000sundram@gmail.com")) {
                role.setRoleId(44L);
                role.setRoleName("ADMIN");
            } else {
                role.setRoleId(45L);
                role.setRoleName("NORMAL");
            }

            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            roles.add(userRole);
            return this.userService.createUser(user, roles); // Call to the UserServiceImpl to create a new user 
        } catch (Exception e) {
            throw new Exception("User with email " + user.getEmail() + " already exists!!");
        }
    }

    /**
     * 5. Fetch all users.
     *
     * @return the list of all users
     */
    @GetMapping("/user/users") // API called from external client to fetch all users
    @CrossOrigin("*")
    public List<User> showUser() {
        return this.userService.findAll(); // Call to the UserServiceImpl to fetch all users
    }
    
    /**
     * 16. Activate/Deactivate a user.
     *
     * @param user the user to activate/deactivate
     * @return the updated user
     * @throws Exception if an error occurs during the activation/deactivation
     */
    @PutMapping("user/active") // API called from external client to activate/deactivate a user
    @CrossOrigin("*")
    public User activateUser(@RequestBody User user) throws Exception {
        try {
            if (!user.getEnabled())
                user.setEnabled(true);
            else
                user.setEnabled(false);
            return this.userService.save(user); // Call to the UserServiceImpl to save the updated user
        } catch (Exception e) {
            throw new Exception("Something went wrong!!");
        }
    }
}
