package com.OlaElectric.Subscribers;

import com.OlaElectric.Constants.MessageType;
import com.OlaElectric.deserializer.Deserializer;

public class KafkaSubscriber<V> {

    private String messageType;

    public KafkaSubscriber(String messageType){
        this.messageType = messageType;
    }

    public void printText(V message) {
        if (messageType.equals(MessageType.TEXT.name())) {
           printRegularText(message);
        } else {
            deserializer(messageType,message);
        }
    }

    private void printRegularText(V message){
        System.out.println(message);
    }

    private void deserializer(String messageType,V message){
        Deserializer deserializer = new Deserializer(messageType);
        deserializer.printMessage((byte[]) message);
    }
}
