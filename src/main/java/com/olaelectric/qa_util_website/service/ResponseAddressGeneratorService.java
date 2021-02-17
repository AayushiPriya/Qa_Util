package com.olaelectric.qa_util_website.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseAddressGeneratorService {

    public String getAddress(List<String> commandList){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://");
        stringBuilder.append(commandList.get(2));
        stringBuilder.append(":");
        stringBuilder.append(commandList.get(4));

        return stringBuilder.toString();
    }




}
