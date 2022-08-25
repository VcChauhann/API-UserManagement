package com.credManager.Controller;

import com.credManager.Repository.CredentialsRepo;
import com.credManager.model.UserLoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CredentialsController {

    @Autowired
    private CredentialsRepo credentialsRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public boolean register(@RequestBody UserLoginDetails userLoginDetails){

        userLoginDetails.setEmail(userLoginDetails.getEmail().toLowerCase());
        userLoginDetails.setPassword(passwordEncoder.encode(userLoginDetails.getPassword()));

        UserLoginDetails save = credentialsRepo.save(userLoginDetails);
        if(save != null){
            return  true;
        }

        return false;
    }
}
