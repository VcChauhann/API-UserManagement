package com.credManager.Services;

import com.credManager.Repository.CredentialsRepo;
import com.credManager.model.JwtRequest;
import com.credManager.model.UserLoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import  java.util.stream.*;
import  java.util.*;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private String userName;
    private String password;

    @Autowired
    private CredentialsRepo credentialsRepo;

    public boolean setCredentials(JwtRequest jwtRequest){

        for (UserLoginDetails userLoginDetails:credentialsRepo.findAll()) {
            if(userLoginDetails.getEmail().equals(jwtRequest.getUsername()) && userLoginDetails.getPassword().equals(jwtRequest.getPassword())){
                userName = jwtRequest.getUsername();
                password = jwtRequest.getPassword();
                return  true;
            }

        }

        return false;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        if(userName.equals(this.userName)){
            return new User(this.userName,this.password,new ArrayList<>());
        }
        else{
            throw new UsernameNotFoundException("user Not found");
        }
    }
}
