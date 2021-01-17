package com.firsttouch.soccerblogbackend.controller;

import com.firsttouch.soccerblogbackend.entity.ERole;
import com.firsttouch.soccerblogbackend.entity.Role;
import com.firsttouch.soccerblogbackend.entity.User;
import com.firsttouch.soccerblogbackend.payload.request.JwtResponse;
import com.firsttouch.soccerblogbackend.payload.request.LoginRequest;
import com.firsttouch.soccerblogbackend.payload.request.RegisterRequest;
import com.firsttouch.soccerblogbackend.repository.RoleRepository;
import com.firsttouch.soccerblogbackend.repository.UserRepository;
import com.firsttouch.soccerblogbackend.security.JwtCreator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Data
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/blogs")
public class AuthController {


    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtCreator tokenMaker;


    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody LoginRequest loginRequest){

        /// authenticates password and username with myuserdetailservice, based off configuration.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenMaker.generateToken(authentication);

        return ResponseEntity.ok(new JwtResponse(jwt));

    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody RegisterRequest registerRequest){

        Set<Role> roles = new HashSet<>();
        User user = new User(registerRequest.getUsername(), registerRequest.getEmail(), passwordEncoder.encode(registerRequest.getPassword()) );

        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return ResponseEntity.ok("User Registered Successfully");
    }
}
