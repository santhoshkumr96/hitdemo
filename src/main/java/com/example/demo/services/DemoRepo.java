package com.example.demo.services;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoRepo extends CrudRepository<UserModel, String> {
    List<UserModel> findByUsername(String username);
}
