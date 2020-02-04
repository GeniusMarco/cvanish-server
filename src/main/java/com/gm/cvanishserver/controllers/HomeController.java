package com.gm.cvanishserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping("/api")
    @ResponseBody
    public String home() {
        return "dupa";
    }
}
