<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QA_util_Website</title>
<link rel="stylesheet" type="text/css" href="./assets/bootstrap.min (1).css">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</head>
<body>
 <div class="alert alert-primary">
    <div class="container text-center">
         <h1>Health_Check Monitor</h1>
    </div>
</div>
<div class="container" style="min-height:50px">
    <p>
        <a href="./" class="btn btn-link">HOME</a>
        <a href="./MQTT" class="btn btn-link">MQTT</a>
        <a href="./KAFKA" class="btn btn-link">KAFKA</a>
        <a href ="./Health_Check" class="btn btn-link">Health_Check</a>
        <a href ="./Health_Check" class="btn btn-link">Health_Check_Stage</a>

    </p>
</div>
</body>
    <div>
<!--         <iframe src="http://localhost:3000/d/bbe/prometheus-blackbox-exporter?orgId=1&refresh=10s&from=1616033351794&to=1616036951794&var-interval=10s&var-target=All&theme=light" height="100%" width="100%"> -->
        <iframe src="http://localhost:3000/?orgId=1&from=1616027898683&to=1616049498683&panelId=3" width="1500" height="1500" frameborder="0"></iframe>
    </div>
<script>
    function displayIframe(){
        console.log("button clicked")
        var iframe = $("#Iframe1234");
        let hostValue = document.getElementById("host#1234").value;
        let topicValue = document.getElementById("topic#1234").value;
        let textValue = document.getElementById("text#1234").value;
        console.log("The host selected is : "+hostValue+"  topic is : "+topicValue+" text is : "+textValue);
        let address = getGottyServerAddress(hostValue,topicValue,textValue);
        console.log("The Gotty server address is : "+address)
        iframe.attr("src", address);
    }
    function getGottyServerAddress(host,topic,text){
        let serverAddress
        var dataaa = {"host":host,"topic":topic,"text":text}
        console.log("The Json for the ajax call is : "+JSON.stringify(dataaa))
        serverAddress = $.ajax({
            async : false,
            type:"POST",
            url:"http://127.0.0.1:8080/start/KafkaServer",
            data: JSON.stringify(dataaa),
            contentType: 'application/json',
            success: function(res) {
                console.log("The request is successful");
            serverAddress = res;
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(xhr, status, err.toString());
            }.bind(this)
        }).responseText;
        return serverAddress;
    }
</script>
</html>