package com.cyane.wiki.controller;

import org.springframework.web.bind.annotation.*;


@RestController
public class TestController {
    //接口对应的请求地址
    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }
    @PostMapping("hello/post")
    public String helloPost(String name){
        return "Hello World Post"+name;
    }
}
