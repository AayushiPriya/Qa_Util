<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bob The Builder</title>
<link rel="stylesheet" type="text/css" href="./assets/bootstrap.min (1).css">
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
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
                    <select style="position:absolute;top:0px;left:0px;width:200px; height:34px;line-height:20px;margin:0;padding:0;" onchange="document.getElementById('host#1234').value=this.options[this.selectedIndex].text; document.getElementById('host#1234').value=this.options[this.selectedIndex].value;">
                      <option></option>
                      <option value="host1">host1</option>
                      <option value="host2">host2</option>
                    </select>
                    <input type="text" name="hostvalue" id="host#1234" placeholder="add/select a value" onfocus="this.select()" style="position:absolute;top:0px;left:0px;width:183px;height:34px;border:1px solid #556;" >
                    <input name="idValue" id="idValue" type="hidden" style="position:absolute;top:0px;left:0px;width:183px;height:34px;border:1px solid #556;">
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
    <div class="col" style="position:relative;width:200px;height:34px;border:0;padding:0;margin:0;">
        <button class="btn btn-primary">Submit</button>
    </div>
</div>
   
<div class="container text-center">
    <h2> Messages of kafka will be published below</h2>
    <iframe id="#123" src="http://127.0.0.1:8080" style="overflow:hidden;overflow-x:hidden;overflow-y:hidden;height:70%;width:95%;position:absolute;top:250px;left:50px;right:0px;bottom:0px;border:none;" name="trial1"></iframe>




</div> 
</body>
</html>