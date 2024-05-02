package com.example.yenivesondeneme.controller;


import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/yusuf")
public class yusufcontroller {

    @GetMapping()
    public String  listelle(){
        return "yusuf jhhjoho can";
    }
}
