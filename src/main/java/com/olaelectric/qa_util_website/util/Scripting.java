package com.olaelectric.qa_util_website.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Slf4j
public class Scripting {

    private List<String> inputCommand;

    public Scripting(List<String> list){
        this.inputCommand = list;
    }

    public void publishCommand(String addressPort){
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Run a shell command
        processBuilder.command(inputCommand);
        try {
            Process process = processBuilder.start();
            log.info("Thread started for port "+addressPort);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (reader.readLine() != null ) {
            }
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                log.info("Thread Closed for port "+addressPort);
            } else {
                log.info("The Thread has failed to publish the gotty Command "+addressPort);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
