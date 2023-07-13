package com.nagarro.exittest.controllers; 

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exittest.impl.ProductServiceImpl;
import com.nagarro.exittest.impl.ReviewServiceImpl; 
import com.nagarro.exittest.impl.UserServiceImpl; 
import com.nagarro.exittest.models.User; 

@RestController
@CrossOrigin("*")
public class MainController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ReviewServiceImpl reviewService;

    /**
     * Fetch statistics for the home page.
     *
     * @return a list of integers representing different statistics
     */
    @GetMapping("home/stats")
    public List<Integer> showStats() {
        // Retrieve all users from UserServiceImpl
        List<User> users = this.userService.findAll();
        int totalUsers = users.size();
        // Get the total number of reviews from ReviewServiceImpl 
        int posts = this.reviewService.findAllReviews().size();
        // Get the total number of products from ProductServiceImpl
        int products = this.productService.getNumberofProducts();
        int onlineUsers = 0;
        for (User u : users) {
            if (u.getEnabled()) {
                onlineUsers++;
            }
        }
        List<Integer> stats = new ArrayList<>();
        stats.add(totalUsers);
        stats.add(posts);
        stats.add(onlineUsers);
        stats.add(products);
        // Return the list of statistics
        return stats;
    }
}
