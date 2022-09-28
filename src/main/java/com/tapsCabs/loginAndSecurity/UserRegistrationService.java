package com.tapsCabs.loginAndSecurity;


import com.tapsCabs.DTO.Customer;
import com.tapsCabs.enums.Role;
import com.tapsCabs.pojos.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote service layer for registering user
 */
@Service
class UserRegistrationService implements IUserRegistrationService {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    IUserDao userDao;

    /**
     *
     * @param customer
     * @return
     */
   @Override
    public String registerUserService(Customer customer) {
        Users user = new Users();
        user.setEmail(customer.getEmail());
        user.setName(customer.getName());
        user.setNumber(customer.getNumber());
        user.setRole(String.valueOf(Role.ROLE_USER));
        user.setPassword(passwordEncoder.encode(customer.getPassword()));
        userDao.save(user);
        return "user registered successfully";
    }
}
