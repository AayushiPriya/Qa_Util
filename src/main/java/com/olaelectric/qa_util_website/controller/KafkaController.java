package com.olaelectric.qa_util_website.controller;

import com.olaelectric.qa_util_website.cfg.ApplicationConfigurations;
import com.olaelectric.qa_util_website.constants.SourceType;
import com.olaelectric.qa_util_website.dta.WebsiteRequestPojo;
import com.olaelectric.qa_util_website.service.GenerateInitialCommand;
import com.olaelectric.qa_util_website.service.PublishCommandService;
import com.olaelectric.qa_util_website.service.ResponseAddressGeneratorService;
import com.olaelectric.qa_util_website.util.Scripting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KafkaController {

    /**
     * The service is called to publish the command (to run the jar)
     */
    @Autowired
    public PublishCommandService publishCommandService;

    /**
     * This service is called to generate command with random port number, else a single port number will be generated to multiple clinets.
     * If this service is not called and the initial list is directly autowired then due to bean 'singleton property' a single port number will be generated everytime.
     */
    @Autowired
    private GenerateInitialCommand generateInitialCommand;

    /**
     * This service is used to build the response address which will be consumed by the iframe to load the terminal in the website.
     */
    @Autowired
    private ResponseAddressGeneratorService responseAddressGeneratorService;


    List<String> genarateCommandList;

    @PostMapping(value = "/start/KafkaServer")
    public String startKafkaCommandServer(@RequestBody WebsiteRequestPojo kafkaRequestPojo)
    {
        genarateCommandList = generateInitialCommand.getListwithRandomPort(SourceType.KAFKA.name(),kafkaRequestPojo);
        String address = responseAddressGeneratorService.getAddress(genarateCommandList);
        publishCommandService.excute(genarateCommandList,address);
        return address;
    }


}
