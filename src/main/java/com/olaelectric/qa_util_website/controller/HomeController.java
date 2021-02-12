package com.olaelectric.qa_util_website.controller;

import com.olaelectric.qa_util_website.dta.WebsiteRequestPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class HomeController {

    @GetMapping(value = "/hello")
    public String helloWorld(){
        return "Hello there";
    }

}
