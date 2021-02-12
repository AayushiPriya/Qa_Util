package com.olaelectric.qa_util_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KafkaController {

    @RequestMapping(value = "/KAFKA", method = RequestMethod.GET)
    public String kafkaPage(){
        return "KAFKA.jsp";
    }

}
