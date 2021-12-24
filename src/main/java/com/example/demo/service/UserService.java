package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.IUserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserDAO iUserDAO;

    public List<User> getAllUsers() {
        var userList = iUserDAO.findAll();
        System.out.println("userList = " + userList.size());
        return userList;
    }

    public User getUserByName(String name) {
        return iUserDAO.findByName(name).orElseThrow(() -> new NotFoundException(String.format("User with name: %s is not found", name)));
    }
}
