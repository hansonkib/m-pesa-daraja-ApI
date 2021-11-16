package com.hanson.darajaapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
public class MpesaController {

    @GetMapping(produces = "application/json")
    public String getSapleMessage(){

        return "Sample controller working";
    }
}
