package com.olaelectric.connectors_trial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controllers {

    @RequestMapping("/")
    public String greeting(){
        return "index.jsp";
    }

    @RequestMapping(value = "/MQTT", method = RequestMethod.GET)
    public String mqttPage(Model model){

        return "MQTT.jsp";
    }

    @RequestMapping(value = "/KAFKA", method = RequestMethod.GET)
    public String kafkaPage(){
        return "KAFKA.jsp";
    }
}
