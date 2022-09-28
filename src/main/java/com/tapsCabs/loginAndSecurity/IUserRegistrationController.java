package com.tapsCabs.loginAndSecurity;


import com.tapsCabs.DTO.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote controller interface for registering user
 */
@RequestMapping("/user")
 interface IUserRegistrationController {

    @PostMapping("/reg")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer);

}
