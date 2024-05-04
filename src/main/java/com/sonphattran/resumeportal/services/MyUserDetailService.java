package com.sonphattran.resumeportal.services;

import com.sonphattran.resumeportal.models.User;
import com.sonphattran.resumeportal.models.UserDetailModel;
import com.sonphattran.resumeportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(UserDetailModel::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
