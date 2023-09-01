package com.example.demo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DemoController {

    @Autowired
    DemoRepo demoRepo;

    @GetMapping("/test")
    public Object getAllSurvey() throws JsonProcessingException {
        return "it is working";
    }

    @GetMapping("/getAllUsers")
    public Object getAllUsers() throws JsonProcessingException {
        return demoRepo.findAll();
    }

    @GetMapping("/validateUser")
    public Object validateUser(@RequestParam("username") String username , @RequestParam("password") String password) throws JsonProcessingException {

        List<UserModel> users = demoRepo.findByUsername(username);
        for(UserModel user : users){
            System.out.println(user.getUsername() + "------" + user.getPassword());
        }
        return null;
    }

}
