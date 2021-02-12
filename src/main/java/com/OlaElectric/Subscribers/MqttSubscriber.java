package com.OlaElectric.Subscribers;
import com.OlaElectric.Constants.MessageType;
import com.OlaElectric.deserializer.Deserializer;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class MqttSubscriber implements MqttCallback {

    private String messageType;

    public MqttSubscriber(String messageType){
        this.messageType = messageType;
    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

        if (messageType.equals(MessageType.TEXT.name())) {
            regularMessage(mqttMessage.getPayload());
        } else {
            deserialize(messageType,mqttMessage.getPayload());
        }

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }

    private void regularMessage(byte[] mqttMessage){
        System.out.println( new String(mqttMessage));
    }

    private void deserialize(String subscribeType,byte[] message){
        Deserializer deserializer = new Deserializer(subscribeType);
        deserializer.printMessage(message);
    }

}
