package com.lhl.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* hello
* @author lhl
* @since 2020-10-13
*/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String signUp(){
        return "hello sprint boot";
    }
}
