package com.cyane.wiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Value("${test.hello:TEST}")
    private String testHello;
    //接口对应的请求地址
    @GetMapping("/hello")
    public String hello(){
        return "Hello world!"+ testHello;
    }
    @PostMapping("hello/post")
    public String helloPost(String name){
        return "Hello World Post"+name;
    }
}
