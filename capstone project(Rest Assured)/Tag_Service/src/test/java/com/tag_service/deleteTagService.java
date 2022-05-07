package com.tag_service;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deleteTagService {
  @Test
  public void deleteTag() {
	  RestAssured.baseURI= "http://localhost:8070/api/v1/interview/slot/";
	  RequestSpecification httpRequest = RestAssured.given();
	  httpRequest.header("Content-Type","application/json");
	  Response response = httpRequest.delete("/BOOKED_SLOT3/");
	  
	  Assert.assertEquals(response.getStatusCode(),200);
	  
	  String jsonString = response.asString();
	  System.out.println(jsonString);
  }
}
