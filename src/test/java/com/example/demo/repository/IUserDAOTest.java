package com.example.demo.repository;

import com.example.demo.MyAppTest;
import com.example.demo.entity.User;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MyAppTest(activeProfiles = {"test", "stage"})
class IUserDAOTest {
    @Autowired
    private IUserDAO iUserDAO;

    EasyRandom generator = new EasyRandom();

    @Test
    void findByName() {
        var lst = Arrays.asList(
                generator.nextObject(User.class),
                generator.nextObject(User.class),
                generator.nextObject(User.class)
        );

        lst.forEach(o -> {
            o.setId(null);
            o.getCars().forEach(o1 -> {
                o1.setId(null);
            });

        });

        iUserDAO.saveAll(lst);

        var res = iUserDAO.findAll();
        assertEquals(3, res.size());
    }
}