package com.techolution.userauthservice.services;

import com.techolution.userauthservice.models.AuthUserDetails;
import com.techolution.userauthservice.models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userService.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found.");
        }

        return new AuthUserDetails(user);
    }

}
