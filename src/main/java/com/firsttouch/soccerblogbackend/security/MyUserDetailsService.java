package com.firsttouch.soccerblogbackend.security;

import com.firsttouch.soccerblogbackend.security.MyUserDetails;
import com.firsttouch.soccerblogbackend.entity.User;
import com.firsttouch.soccerblogbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    //@Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + "Username does not exist"));;
        return new MyUserDetails(user);
    }
}
