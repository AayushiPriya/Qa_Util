package com.OlaElectric.deserializer;

import com.OlaElectric.Constants.MessageType;
import com.OlaElectric.protoBuf.RegularPacket;
import com.google.protobuf.InvalidProtocolBufferException;

public class Deserializer {

    private String messageType;

    public Deserializer(String messageType){
        this.messageType = messageType;
    }

    public void printMessage(byte[] message){
        if(messageType.equals(MessageType.REGUALR_PACKET.name())){
            getRegularPacket(message);
        }
    }

    private void getRegularPacket(byte[] message) {
        RegularPacket.RegularDataSt regularDataSt;
        try {
            regularDataSt = RegularPacket.RegularDataSt.parseFrom(message);
            System.out.println(regularDataSt);
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            invalidProtocolBufferException.printStackTrace();
        }
    }



}
