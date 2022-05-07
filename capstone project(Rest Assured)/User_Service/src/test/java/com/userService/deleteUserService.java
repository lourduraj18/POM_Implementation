package com.userService;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deleteUserService {
  @Test
  public void deleteUser() {
	  RestAssured.baseURI= "http://localhost:8090/api/v1/user/";
	  RequestSpecification httpRequest = RestAssured.given();
	  httpRequest.header("Content-Type","application/json");
	  Response response = httpRequest.delete("/dani@gmail.com/");
	  
	  Assert.assertEquals(response.getStatusCode(),200);
	  
	  String jsonString = response.asString();
	  System.out.println(jsonString);
  }
}
