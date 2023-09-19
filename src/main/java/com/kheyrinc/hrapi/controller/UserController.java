package com.kheyrinc.hrapi.controller;


import com.kheyrinc.hrapi.model.User;
import com.kheyrinc.hrapi.repository.UserRepository;
import com.kheyrinc.hrapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestMapping(path="/api/v1") // This means URL's start with /demo (after Application path)
@RestController
public class UserController {
    @Autowired // This means to get the bean called userRepository
    private UserService userService;

    private final static Logger LOG = Logger.getLogger(UserController.class.getName());


    @GetMapping(path="/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.getAllUser();
    }


    /**
     * Create - Add new user
     * @param user An object User
     * @return all user
     */
    @PostMapping(path="/user") // Map ONLY POST Requests
    public @ResponseBody User addNewUser (@RequestBody User user ){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        LOG.log(Level.INFO, "### PARAM FIRSTNAME : `{0}` ###", user.getFirstname().toString());
        LOG.log(Level.INFO, "### PARAM LASTNAME : `{0}` ###", user.getLastname().toString());
        LOG.log(Level.INFO, "### PARAM EMAIL : `{0}` ###", user.getEmail().toString());
        //LOG.log(Level.INFO, "### PARAM PASSWORD : `{0}` ###", user.getPassword().toString());

        return userService.saveUser(user);
    }


    @GetMapping(path="/user/{id}", params = {})
    public @ResponseBody User getOneUser(@PathVariable final int id) {
        LOG.log(Level.INFO, "### PARAM LASTNAME : `{0}` ###", id);

        Optional<User> user = userService.getOneUser(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }


    /**
     * Update - Update an existing employee
     * @param id - The id of the employee to update
     * @param user - The employee object updated
     * @return
     */
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") final int id, @RequestBody User user) {
        Optional<User> e = userService.getOneUser(id);

        if(e.isPresent()) {
            User currentUser = e.get();

            String firstName = user.getFirstname();
            if(firstName != null) {
                currentUser.setFirstname(firstName);
            }
            String lastName = user.getLastname();
            if(lastName != null) {
                currentUser.setLastname(lastName);;
            }
            String mail = user.getEmail();
            if(mail != null) {
                currentUser.setEmail(mail);
            }
            String password = user.getPassword();
            if(password != null) {
                currentUser.setPassword(password);;
            }
            userService.saveUser(currentUser);
            return currentUser;
        } else {
            return null;
        }
    }


    @DeleteMapping(path="/user/{id}")
    public @ResponseBody void deleteUser(@PathVariable("id") final int id) {
        // This returns a JSON or XML with the users
        userService.deleteOneUser(id);
    }
}