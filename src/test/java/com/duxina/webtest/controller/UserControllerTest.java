package com.duxina.webtest.controller;

import com.duxina.webtest.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserControllerTest {
    @Autowired
    UserController userController;

    @TestConfiguration
    static class UserControllerTestContextConfiguration {
        @Bean
        public UserController getUserController() {
            return new UserController();
        }
    }

    @Test(expected = Exception.class)
    public void getByIdException() throws Exception {
        Integer id = 4;
        User result = userController.getById(id);
    }

    @Test
    public void getById() throws Exception {
        Integer id = 1;
        User result = userController.getById(id);
    }
}
