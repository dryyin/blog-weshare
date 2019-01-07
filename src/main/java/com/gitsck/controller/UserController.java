package com.gitsck.controller;

import com.gitsck.entity.PageResult;
import com.gitsck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findall",method = RequestMethod.GET)
    public PageResult findAll(int page,int rows){
        return userService.findAllUsers(page,rows);
    }
}
