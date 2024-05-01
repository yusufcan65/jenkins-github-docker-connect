package com.example.yenivesondeneme.controller;


import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/yusuf")
public class yusufcontroller {

    @GetMapping("/list")
    public String  listelle(){
        return "yusuf can";
    }
}
