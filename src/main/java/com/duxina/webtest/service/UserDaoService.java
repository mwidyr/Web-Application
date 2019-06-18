package com.duxina.webtest.service;

import com.duxina.webtest.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoService{
    static List<User> users = new ArrayList<>();
    Integer userCount = 3;
    static {
        users.add(new User(1, "Widy", 17, "Jakarta"));
        users.add(new User(2, "Jack", 20, "Bekasi"));
        users.add(new User(3, "Entong", 17, "Depok"));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id) throws Exception{
        Optional<User> user = users.stream().filter(x -> x.getId().equals(id)).findFirst();
        if(!user.isPresent()){
            throw new Exception();
        }
        return user.get();

    }
    public User saveUser(User user){
        if(user.getId() == null)
            user.setId(userCount++);
        users.add(user);
        return user;
    }
  public User deleteUser (int id) throws Exception {
      Optional<User> user = users.stream().filter(x -> x.getId().equals(id)).findFirst();
      if (!user.isPresent()) {
          throw new Exception();
      }
      users.remove(user.get());
      return user.get();
  }
}
