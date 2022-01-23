package com.durumluemrullah.keyboardguid.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deneme")
public class Deneme {

    @GetMapping("/dene")
    public String deneme(){
        return "OK";
    }

}
