package com.Hitansh.Services;


import com.Hitansh.Model.ApplicationUser;
import com.Hitansh.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    public PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Inthe user Details service");
        if(!username.equals("ethan"))throw new UsernameNotFoundException("not ethan");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1,"USER"));

        return new ApplicationUser(1,"ethan", encoder.encode("password"),roles);
    }
}
