package com.example.login_register.controller;


import com.example.login_register.entities.User;
import com.example.login_register.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="http://localhost:40516")
@RestController
@RequestMapping(value = "api/v1/user")
public class Controller {

        private final UserServices userServices;

        @Autowired
        public Controller(UserServices userServices) {
            this.userServices = userServices;
        }

        @PostMapping("/save")
        public User saveUser(@RequestBody User user) {

            return userServices.saveUser(user);

        }
        @GetMapping("/getall")
        public Iterable<User> getAllUsers() {
            return userServices.listAll();
        }

        @GetMapping("/search/{id}")
        public User getUserById(@PathVariable Long id) {
            return userServices.getUserById(id);
        }

        @GetMapping("/{email}/{password}")
        public User getUserByEmailAndPassword(@PathVariable String email ,@PathVariable String password){
            return userServices.getUserByEmailAndPassword(email,password);
        }
}
