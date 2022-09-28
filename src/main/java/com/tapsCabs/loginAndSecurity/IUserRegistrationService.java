package com.tapsCabs.loginAndSecurity;


import com.tapsCabs.DTO.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote service interface for registering user
 */
@RequestMapping("/register")
interface IUserRegistrationService {

 @PostMapping("/user")
 public String registerUserService(Customer customer);

}
