package com.olaelectric.qa_util_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MqttControllers {

    @RequestMapping(value = "/MQTT", method = RequestMethod.GET)
    public String mqttPage(Model model){
        return "MQTT1.jsp";
    }
}
