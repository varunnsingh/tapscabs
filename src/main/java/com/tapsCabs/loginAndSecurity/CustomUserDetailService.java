package com.tapsCabs.loginAndSecurity;

import com.tapsCabs.pojos.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote Spring security UserDetailsServiceImpl
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
   private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.userDao.findByEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("You are not registered , kindly register");
        }
        return new CustomUserDetail(user);
    }
}
