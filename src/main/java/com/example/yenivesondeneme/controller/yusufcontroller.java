package com.example.yenivesondeneme.controller;


import org.springframework.web.bind.annotation.*;

@RequestMapping("/yusuf")
public class yusufcontroller {


    @GetMapping("{/listele}")
    public String  listelle(){
        return "yusuf can";
    }
}
