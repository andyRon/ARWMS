package com.andyron.wms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andyron
 **/
@RestController
public class HelloController {
    @GetMapping
    public String hello() {
        return "hello wms";
    }

}
