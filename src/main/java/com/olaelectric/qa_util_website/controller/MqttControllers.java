package com.olaelectric.qa_util_website.controller;

import com.olaelectric.qa_util_website.cfg.ApplicationConfigurations;
import com.olaelectric.qa_util_website.constants.SourceType;
import com.olaelectric.qa_util_website.service.PublishCommand;
import com.olaelectric.qa_util_website.util.Scripting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MqttControllers {

    @RequestMapping(value = "/MQTT", method = RequestMethod.GET)
    public String mqttPage(Model model){
        return "MQTT1.jsp";
    }

    AnnotationConfigApplicationContext applicationContext;

    List<String> genarateCommandList;

    Scripting commandScript;

    StringBuilder responseaddress;

    @Autowired
    public PublishCommand publishCommand;

    @PostMapping(value = "/v1/MQTT")
    public Map<String,String> startMqttCommandServer(@RequestBody MqttStartPojo mqttStartPojo)
    {
        applicationContext = new AnnotationConfigApplicationContext(ApplicationConfigurations.class);
        genarateCommandList = applicationContext.getBean("genarateCommandList",List.class);
        /**
         * adding additional paramters to the command
         */
        genarateCommandList.add(SourceType.MQTT.name());
        genarateCommandList.add(mqttStartPojo.getHost());
        genarateCommandList.add(mqttStartPojo.getTopic());
        genarateCommandList.add(mqttStartPojo.getMessageType());
        genarateCommandList.add(mqttStartPojo.getUsername());
        genarateCommandList.add(mqttStartPojo.getPassword());

        /**
         * The connection time for mqtt is hardcode. it is in seconds
         */
        genarateCommandList.add("120");

        /**
         * String builder is used to build the response address string.
         */
        responseaddress = new StringBuilder();
        responseaddress.append("http://");
        responseaddress.append(genarateCommandList.get(2));
        responseaddress.append(":");
        responseaddress.append(genarateCommandList.get(4));
        applicationContext.close();

        /**
         * This is where the command will be published
         */
        publishCommand.excute(genarateCommandList,responseaddress.toString());

        /**
         * response for the request
         */
        Map<String,String> response = new HashMap<>();
        response.put("status","200");
        response.put("go to address",responseaddress.toString());

        return response;
    }

}
