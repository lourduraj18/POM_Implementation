package com.emailService;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postEmailService {
  @Test
  public void postEmail() {
	  RestAssured.baseURI= "http://localhost:8075/api/v1/sendEmail";
	  RequestSpecification httpRequest = RestAssured.given();
	  JSONObject requestparams = new JSONObject();
	  requestparams.put("subject","Booking for interview");
	  requestparams.put("statusCode","Confirmed");
	  requestparams.put("interviewerEmailId","raj@gmail.com");
	  requestparams.put("tagEmailId","john@gamil.com");
	  requestparams.put("messageText","Interview scheduled");
	  requestparams.put("startTime","11:00:00");
	  requestparams.put("endTime","11:30:00");
	  requestparams.put("date","2022:06:07");
	
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requestparams.toJSONString());
	  Response response = httpRequest.post("http://localhost:8075/api/v1/sendEmail");
	  System.out.println(response.statusCode());
	  
	  Assert.assertEquals(200,response.getStatusCode());
  }
}
