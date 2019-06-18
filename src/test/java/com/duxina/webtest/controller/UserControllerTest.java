package com.duxina.webtest.controller;

import com.duxina.webtest.model.User;
import com.duxina.webtest.service.UserDaoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest implements Serializable {
    @InjectMocks
    UserController userController;
    @Mock
    UserDaoService userDaoService;

    @Test
    public void abcd(){
        Assert.assertTrue(true);
    }

    @Test
    public void getById() throws Exception {
        User user = new User();
        user.setName("sa");
        user.setId(1);
        Mockito.when(userDaoService.findOne(1)).thenReturn(user);
        User result = userController.getById(1);
    }
    @Test
    public void getAll(){
        List<User> users = new ArrayList<>();
        Mockito.when(userDaoService.findAll()).thenReturn(users);
        List<User> result = userController.retrieveAll();
    }
    @Test
    public void saveUser(){
        User user = new User();
        user.setId(4);
        user.setName("gabriel");
        Mockito.when(userDaoService.saveUser(user)).thenReturn(user);
        User result = userController.saveUser(user);
    }
    @Test
    public void deleteUser() throws Exception {
        User user = new User();
        user.setName("jose");
        user.setId(1);
        Mockito.when(userDaoService.deleteUser(1)).thenReturn(user);
        User result = userController.deleteById(user.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(user.getId(), result.getId());
    }

}
