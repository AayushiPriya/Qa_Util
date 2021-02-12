package com.olaelectric.qa_util_website.service;

import com.olaelectric.qa_util_website.util.Scripting;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishCommand {

    Scripting commandScript;

    @Async
    public void excute(List<String> command, String addressPort){
        commandScript = new Scripting(command);
        commandScript.publishCommand(addressPort);
    }
}
