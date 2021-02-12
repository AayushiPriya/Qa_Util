package com.OlaElectric.Mqtt;


import com.OlaElectric.Configuration.MqttConfiguration;
import com.OlaElectric.Subscribers.MqttSubscriber;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;


public class MqttConnector {


    private MqttClient client;

    private MqttConfiguration configuration;

    public MqttConnector(MqttConfiguration configuration){
        this.configuration = configuration;
    }

    public void connect() {
        MqttConnectOptions connectOptions = new MqttConnectOptions();
        try {
            client = new MqttClient(configuration.getHost(), MqttClient.generateClientId());
            connectOptions.setUserName(configuration.getUserName());
            connectOptions.setPassword(configuration.getPassWord().toCharArray());
            connectOptions.setCleanSession(true);
            connectOptions.setAutomaticReconnect(true);
            client.connect(connectOptions);
            System.out.println("<------------------MQTT Connection is successful----------------------->");
        } catch (MqttException exception){
            exception.printStackTrace();
        }
    }

    private void receiveMessages() throws MqttException {
        MqttSubscriber subcriber = new MqttSubscriber(configuration.getSubscribeType());
        client.setCallback(subcriber);
        client.subscribe(configuration.getTopic());
    }

    public void subscribe() throws MqttException {
        long connectionEndTime = System.currentTimeMillis() + configuration.getSourceConnectionTime() ;
        while  (System.currentTimeMillis()<connectionEndTime){
            receiveMessages();
        }
        System.out.println("<------------------MQTT connection timeout----------------------->");
        client.disconnectForcibly();
        client.close();
        System.out.println("<------------------MQTT Connection Closed----------------------->");
    }


}

