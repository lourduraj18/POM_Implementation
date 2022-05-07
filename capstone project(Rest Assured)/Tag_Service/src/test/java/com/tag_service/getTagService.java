package com.tag_service;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getTagService {
  @Test
  public void getTag() {
	  RestAssured.baseURI= "http://localhost:8070/api/v1/interview/slot/ronaldo@gmail.com";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.request(Method.GET,"");
	  System.out.println("status received= "+response.prettyPrint());
	  System.out.println("status code :"+ response.statusCode());
  }
  
  @Test
  public void id() {
	  RestAssured
	  .given()
	  .get("http://localhost:8070/api/v1/interview/slot/ronaldo@gmail.com")
	  .then()
	  .body("[0].bookedTagEmailId", equalTo("ragu@gmail.com"));
	  
	
  }
  
  @Test
  public void status() {
	  RestAssured
	  .given()
	  .get("http://localhost:8070/api/v1/interview/slot/ronaldo@gmail.com")
	  .then()
	  .body("[0].bookedStatus", equalTo("UPCOMING"));
	  
	
  }
}
