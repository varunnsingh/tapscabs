package com.tapsCabs.loginAndSecurity;


import com.tapsCabs.DTO.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote controller for registering user
 */
@RestController
class UserRegistrationController implements IUserRegistrationController {

    @Autowired
    private UserRegistrationService userService;

    /**
     *
     * @param customer
     * @return
     */

    @Override
    public ResponseEntity<String> registerUser(Customer customer) {

             return new ResponseEntity<>(userService.registerUserService(customer), HttpStatus.OK);
    }
}
