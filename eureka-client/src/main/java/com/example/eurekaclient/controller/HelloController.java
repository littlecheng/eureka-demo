package com.example.eurekaclient.controller;

import com.weitao.entity.User;
import com.weitao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String ip;

    @Autowired
    private UserService userService;


    @GetMapping("/info")
    public String info() {
        return " ip :"+ip;
    }

    @RequestMapping("/getUser/{id}")
    public User GetUser(@PathVariable int id)

    {
        return userService.Sel(id);
    }

    @RequestMapping("/save/{userName}/{passWord}/{realName}")
    public String SaveUser(@PathVariable String userName,@PathVariable String passWord, @PathVariable String realName)
    {
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        user.setRealName(realName);
        userService.Save(user);
        return "user saved";
    }

    @RequestMapping("/findAll")
    public List<User> findAll()
    {
        return userService.SelectAll();
    }

}
