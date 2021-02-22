package com.olaelectric.qa_util_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebController {

    @RequestMapping(value = "/MQTT", method = RequestMethod.GET)
    public String mqttPage(Model model){
        return "MQTT1.jsp";
    }

    @RequestMapping(value = "/KAFKA", method = RequestMethod.GET)
    public String kafkaPage(){
        return "KAFKA.jsp";
    }

    @RequestMapping("/")
    public String greeting(){
        return "index.jsp";
    }

}
