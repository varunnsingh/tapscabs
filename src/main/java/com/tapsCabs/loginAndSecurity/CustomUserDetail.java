package com.tapsCabs.loginAndSecurity;

import com.tapsCabs.pojos.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote Spring security UserDetailsImpl
 */
public class CustomUserDetail implements UserDetails {

    private Users user;

    public CustomUserDetail(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<SimpleGrantedAuthority> roleSet = new HashSet<>();
       roleSet.add(new SimpleGrantedAuthority(this.user.getRole()));
             return roleSet;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
