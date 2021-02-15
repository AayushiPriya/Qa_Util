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
         <h1>MQTT</h1>
    </div>
</div>    
<div class="container" style="min-height:50px">
    <p>
        <a href="./" class="btn btn-link">HOME</a>
        <a href="./MQTT" class="btn btn-link">MQTT</a>
        <a href="./KAFKA" class="btn btn-link">KAFKA</a>
    </p>
</div>
<div class="row">
    <div class="col">
        <div class="row">
            <label class="col-md-2" for="host#1234">Host</label>
            <div class="col-md-8">
                <div class="container" style="position:relative;width:200px;height:34px;border:0;padding:0;margin:0;">
                    <select style="position:absolute;top:0px;left:0px;width:200px; height:34px;line-height:20px;margin:0;padding:0;" name="host" id = "host#2345" >
                        <option value="" selected>-none-</option>
                        <option value="ssl://emqtt-stg-ev-oem-ext.olacabs-dev.in:443" >Develop - ssl://emqtt-stg-ev-oem-ext.olacabs-dev.in:443</option>
                        <option value="ssl://emqtt-stg-ev.olacabs-dev.in:8883">Stage - ssl://emqtt-stg-ev.olacabs-dev.in:8883</option>
                </select>
                </div>  
            </div>
        </div>
    </div>
    <div class="col">
        <div class="row">
            <label class="col-md-2" for="topic#1234">Topic</label> 
            <div class="col-md-8" >
                <div class="container" style="position:relative;width:200px;height:34px;border:0;padding:0;margin:0;">
                    <input type="text" id="topic#1234" name="topic" class="form-control" style="position:absolute;top:0px;left:0px;width:183px;height:34px;border:1px solid #556;" >
                </div>  
            </div>
        </div>
    </div>
    <div class="col">
        <div class="row">
            <label class="col-md-2" for="topic#1234">Text Type</label> 
            <div class="col-md-8" >
                <div class="container" style="position:relative;width:200px;height:34px;border:0;padding:0;margin:0;">
                    <select style="position:absolute;top:0px;left:0px;width:200px; height:34px;line-height:20px;margin:0;padding:0;" name="Text" id = "text#2345">
                            <option value="" selected>-none-</option>
                            <option value="TEXT">TEXT</option>
                            <option value="REGULAR_PACKET">REGULAR_PACKET</option>
                    </select>
                </div>  
            </div>
        </div>
    </div>
    <div class="container text-center" style="padding:25px;">
        <button class="btn btn-primary" id = "submitButton" onclick="displayIframe()">Submit</button>
    </div> 
    <div class="container text-center">
        <h2> Messages of MQTT will be published here</h2>
        <iframe id="Iframe1234" src="" style="overflow:hidden;overflow-x:hidden;overflow-y:hidden;height:60%;width:95%;position:absolute;top:250px;left:50px;right:0px;bottom:0px;border:none;padding:15px;" name="trial1"></iframe>
    </div> 
</div>
</body>
<script>
    function displayIframe(){
        console.log("button clicked")
        var iframe = $("#Iframe1234");
        let hostValue = document.getElementById("host#2345").value;
        let topicValue = document.getElementById("topic#1234").value;
        let textValue = document.getElementById("text#2345").value;
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
            url:"http://127.0.0.1:8080/start/MqttServer",
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