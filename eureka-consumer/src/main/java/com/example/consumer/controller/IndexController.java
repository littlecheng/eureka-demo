package com.example.consumer.controller;

import com.weitao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {



    @Autowired
    RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping("/index/info")
    public String hello(){
        return restTemplate.getForObject("http://eureka-client/info", String.class);
    }


    @RequestMapping("/save/{userName}/{passWord}/{realName}")
    public String SaveUser(@PathVariable String userName,@PathVariable String passWord, @PathVariable String realName)
    {
        ResponseEntity<String> entity = restTemplate.postForEntity("http://eureka-client/save/"+userName+"/"+passWord+"/"+realName, null,String.class);
        String body = entity.getBody();
        System.out.println("body="+body);
        return body;
    }


    @ResponseBody
    @RequestMapping("/index/getUser/{id}")
    public User GetUser(@PathVariable int id)
    {
        return restTemplate.getForObject("http://eureka-client/getUser/"+id, User.class);
    }



}
