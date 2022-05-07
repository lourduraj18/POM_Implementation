package com.authentication;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {
  @Test
  public void log() {
	  RestAssured.baseURI= "http://localhost:8095/api/v1/login";
	  RequestSpecification httpRequest = RestAssured.given();
	  JSONObject requestparams = new JSONObject();
	  requestparams.put("userEmailId","babu@gmail.com");
	  requestparams.put("password","BAbul@99");
	  requestparams.put("userRole","TAG");
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requestparams.toJSONString());
	  Response response = httpRequest.post("http://localhost:8095/api/v1/login");
	  System.out.println(response.statusCode());
	  
	  Assert.assertEquals(200,response.getStatusCode());
  }
}
