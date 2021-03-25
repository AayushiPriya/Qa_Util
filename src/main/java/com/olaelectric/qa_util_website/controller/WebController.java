package com.olaelectric.qa_util_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value ="/Health_Check",method =RequestMethod.GET)
    public String health_checkDevelop(){return "Health_check.jsp"; }

    @RequestMapping(value="/Health_Check_Stage",method=RequestMethod.GET)
    public String health_checkStage(){return "Health_check_StageEndpoint.jsp";}

    @RequestMapping(value="/Overall_Service_Health",method=RequestMethod.GET)
    public String health_checkOverall(){return "Overall_Service_Health.jsp";}

}
