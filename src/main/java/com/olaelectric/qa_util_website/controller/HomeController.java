package com.olaelectric.qa_util_website.controller;

import com.olaelectric.qa_util_website.dta.WebsiteRequestPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RestController
public class HomeController {

    @RequestMapping("/")
    public String greeting(){
        return "index.jsp";
    }

    @GetMapping(value = "/hello")
    public String helloWorld(){
        return "Hello there";
    }

    @PostMapping(value = "/testingPost")
    public String  printMessage(@RequestBody WebsiteRequestPojo websiteRequestPojo){
        log.info("this is the output printed host: "+ websiteRequestPojo.host+" topic: "+ websiteRequestPojo.topic+" text: "+ websiteRequestPojo.text);

        return "this is the test text that is being returned!";
    }
}
