package com.tag_service;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getUsingTagId {
  @Test
  public void get() {
	  RestAssured.baseURI= "http://localhost:8070/api/v1/interview/tag/slot/ragu@gmail.com";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.request(Method.GET,"");
	  System.out.println("status received= "+response.prettyPrint());
	  System.out.println("status code :"+ response.statusCode());
  }
  
  @Test
  public void id() {
	  RestAssured
	  .given()
	  .get("http://localhost:8070/api/v1/interview/tag/slot/ragu@gmail.com")
	  .then()
	  .body("[1].interviewerEmailId", equalTo("ronaldo@gmail.com"));
	  
	
  }
  
  @Test
  public void status() {
	  RestAssured
	  .given()
	  .get("http://localhost:8070/api/v1/interview/tag/slot/ragu@gmail.com")
	  .then()
	  .body("[0].bookedStatus", equalTo("UPCOMING"));
	  
	
  }
}
