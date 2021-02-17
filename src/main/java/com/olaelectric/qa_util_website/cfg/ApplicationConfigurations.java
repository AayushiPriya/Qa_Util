package com.olaelectric.qa_util_website.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfigurations {

    @Value("${gottyLocation}")
    private String gottyLocation;
    @Value("${gottyAddressCommand}")
    private String gottyAddressCommand;
    @Value("${gottyAddressValue}")
    private String gottyAddressValue;
    @Value("${gottyPortCommand}")
    private String gottyPortCommand;
    @Value("${gottyTimeOutCommand}")
    private String gottyTimeoutCommand;
    @Value("${gottyTimeOutValue}")
    private String gottyTimeoutValue;
    @Value("${gottyExecutibleCommand}")
    private String executibleCommand;
    @Value("${gottyExecutibleCommadParameter}")
    private String executibleCommandParams;
    @Value("${jarFileLocation}")
    private String jarFileLocation;

    List<String> generateCommandList;

    @Bean
    public String getGottyPortNumber(){
        ServerSocket portNumber = null;
        try{
            portNumber = new ServerSocket(0);
        } catch (IOException e){
            e.printStackTrace();
        }
        return Integer.toString(portNumber.getLocalPort());
    }

    @Bean
    @Primary
    public List<String> getInitialCommandList(){
        generateCommandList = new ArrayList<>();
        generateCommandList.add(gottyLocation);
        generateCommandList.add(gottyAddressCommand);
        generateCommandList.add(gottyAddressValue);
        generateCommandList.add(gottyPortCommand);
        generateCommandList.add(getGottyPortNumber());
        generateCommandList.add(gottyTimeoutCommand);
        generateCommandList.add(gottyTimeoutValue);
        generateCommandList.add(executibleCommand);
        generateCommandList.add(executibleCommandParams);
        generateCommandList.add(jarFileLocation);
        return generateCommandList;
    }


}
