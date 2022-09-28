package com.tapsCabs.loginAndSecurity;

import com.tapsCabs.pojos.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote repository for storing users
 */
public interface IUserDao extends JpaRepository<Users,Integer> {
   /**
    *
    * @param email
    * @return
    */
   public Users findByEmail(String email);
}
