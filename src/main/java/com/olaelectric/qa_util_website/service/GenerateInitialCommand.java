package com.olaelectric.qa_util_website.service;

import com.olaelectric.qa_util_website.cfg.ApplicationConfigurations;
import com.olaelectric.qa_util_website.constants.MqttCredentials;
import com.olaelectric.qa_util_website.constants.SourceType;
import com.olaelectric.qa_util_website.dta.WebsiteRequestPojo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerateInitialCommand {

    public List<String> getListwithRandomPort(String sourceType, WebsiteRequestPojo requestPojo){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationConfigurations.class);
        /**
         * get bean function is called everytime so that the port number will be different each time.
         * Else due to singleton property of the bean, the same port number will be generated for multiple clients.
         */
        List<String> initialCommandList =  annotationConfigApplicationContext.getBean("getInitialCommandList",List.class);

        initialCommandList.add(sourceType);
        initialCommandList.add(requestPojo.getHost());
        initialCommandList.add(requestPojo.getTopic());
        initialCommandList.add(requestPojo.getText());

        if(sourceType.equals(SourceType.MQTT.name())){
            initialCommandList.add(MqttCredentials.mqttUsername);
            initialCommandList.add(MqttCredentials.mqttPassword);
        }
        initialCommandList.add("120");

        annotationConfigApplicationContext.close();

        return initialCommandList;
    }

}
