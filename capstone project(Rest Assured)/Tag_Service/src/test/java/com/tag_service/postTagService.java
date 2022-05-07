package com.tag_service;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postTagService {
  @Test
  public void postTag() {
	  RestAssured.baseURI= "http://localhost:8070/api/v1/interview/slot";
	  RequestSpecification httpRequest = RestAssured.given();
	  JSONObject requestparams = new JSONObject();
	  requestparams.put("bookedTagEmailId","ram@gmail.com");
	  requestparams.put("bookedTagName","ram");
	  requestparams.put("interviewerEmailId","john");
	  requestparams.put("interviewerName","john@gamil.com");
	  requestparams.put("interviewTopic","IT");
	  requestparams.put("description","java backend interview");
	  requestparams.put("techTrack","Developer");
	  requestparams.put("bookedStatus","UPCOMING");
	  requestparams.put("startTime","11:00:00");
	  requestparams.put("endTime","11:30:00");
	  requestparams.put("date","2022:06:07");
	
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requestparams.toJSONString());
	  Response response = httpRequest.post("http://localhost:8070/api/v1/interview/slot");
	  System.out.println(response.statusCode());
	  
	  Assert.assertEquals(201,response.getStatusCode());
  }
}
