package com.olaelectric.qa_util_website.controller;

import com.olaelectric.qa_util_website.cfg.ApplicationConfigurations;
import com.olaelectric.qa_util_website.constants.SourceType;
import com.olaelectric.qa_util_website.dta.WebsiteRequestPojo;
import com.olaelectric.qa_util_website.service.PublishCommand;
import com.olaelectric.qa_util_website.util.Scripting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MqttControllers {


    @Autowired
    public PublishCommand publishCommand;

    AnnotationConfigApplicationContext applicationContext;

    List<String> genarateCommandList;

    Scripting commandScript;

    StringBuilder responseaddress;

    @PostMapping(value = "/start/MqttServer")
    public String startMqttCommandServer(@RequestBody WebsiteRequestPojo mqttRequestPojo)
    {
        /**
         * get bean is called so that a new random port number will be genrated everytime this controller is called.
         */

        applicationContext = new AnnotationConfigApplicationContext(ApplicationConfigurations.class);
        genarateCommandList = applicationContext.getBean("genarateCommandList",List.class);
        /**
         * adding additional paramters to the command
         */
        genarateCommandList.add(SourceType.MQTT.name());
        genarateCommandList.add(mqttRequestPojo.getHost());
        genarateCommandList.add(mqttRequestPojo.getTopic());
        genarateCommandList.add(mqttRequestPojo.getText());

        /**
         * Username and password is hardcoded.
         */
        genarateCommandList.add("UserName");
        genarateCommandList.add("PassWord");

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
        //publishCommand.excute(genarateCommandList,responseaddress.toString());

        return responseaddress.toString();
    }

}
