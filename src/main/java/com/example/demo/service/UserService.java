package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final IUserDAO iUserDAO;

    public UserService(IUserDAO iUserDAO) {
        this.iUserDAO = iUserDAO;
    }

    public List<User> getAllUsers() {
        var userList = iUserDAO.findAll();
        System.out.println("userList = " + userList.size());
        return userList;
    }
}
