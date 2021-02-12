package com.olaelectric.qa_util_website.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfigurations {

    ServerSocket portNumber = new ServerSocket(0);

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

    private String gottyPortNumber = Integer.toString(portNumber.getLocalPort());

    List<String> generateCommandList;

    public ApplicationConfigurations() throws IOException {
    }

    @Bean
    public List<String> genarateCommandList(){
        generateCommandList = new ArrayList<>();
        generateCommandList.add(gottyLocation);
        generateCommandList.add(gottyAddressCommand);
        generateCommandList.add(gottyAddressValue);
        generateCommandList.add(gottyPortCommand);
        generateCommandList.add(gottyPortNumber);
        generateCommandList.add(gottyTimeoutCommand);
        generateCommandList.add(gottyTimeoutValue);
        generateCommandList.add(executibleCommand);
        generateCommandList.add(executibleCommandParams);
        generateCommandList.add(jarFileLocation);
        return generateCommandList;
    }


}
