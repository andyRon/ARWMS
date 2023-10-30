package com.andyron.wms.controller;

import com.andyron.wms.entity.User;
import com.andyron.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author andyron
 **/
@RestController
public class HelloController {
    @GetMapping
    public String hello() {
        return "hello wms";
    }

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }
}
