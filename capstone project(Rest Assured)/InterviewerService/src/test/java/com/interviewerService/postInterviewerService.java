package com.interviewerService;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postInterviewerService {
  @Test
  public void postInterview() {
	  RestAssured.baseURI= "http://localhost:8097/api/v1/slot";
	  RequestSpecification httpRequest = RestAssured.given();
	  JSONObject requestparams = new JSONObject();
	  requestparams.put("techTrack","developer");
	  requestparams.put("interviewerEmailId","vimal");
	  requestparams.put("interviewerName","vimal@gamil.com");
	  requestparams.put("startTime","11:00:00");
	  requestparams.put("endTime","11:30:00");
	  requestparams.put("date","2022:06:07");
	  requestparams.put("description","Automation");
	  requestparams.put("bookedStatus","AVAILABLE");
	  
	
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requestparams.toJSONString());
	  Response response = httpRequest.post("http://localhost:8097/api/v1/slot");
	  System.out.println(response.statusCode());
	  
	  Assert.assertEquals(201,response.getStatusCode());
  }
}
