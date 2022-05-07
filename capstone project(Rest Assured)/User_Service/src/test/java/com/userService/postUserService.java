package com.userService;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postUserService {
  @Test
  public void postUser() {
	  RestAssured.baseURI= "http://localhost:8090/api/v1/user";
	  RequestSpecification httpRequest = RestAssured.given();
	  JSONObject requestparams = new JSONObject();
	  requestparams.put("userEmailId","romeo@gmail.com");
	  requestparams.put("userName","romeo");
	  requestparams.put("phoneNo",9932776655l);
	  requestparams.put("password","romeo@1999");
	  requestparams.put("department","IT");
	  
	
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requestparams.toJSONString());
	  Response response = httpRequest.post("http://localhost:8090/api/v1/user");
	  System.out.println(response.statusCode());
	  
	  Assert.assertEquals(201,response.getStatusCode());
  }
}
