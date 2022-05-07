package com.interviewerService;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getUsingtechTrack {
  @Test
  public void get() {
	  RestAssured.baseURI= "http://localhost:8097/api/v1/slot/interview/slot/tester";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.request(Method.GET,"");
	  System.out.println("status received= "+response.prettyPrint());
	  System.out.println("status code :"+ response.statusCode());
  }
  
  @Test
  public void id() {
	  RestAssured
	  .given()
	  .get("http://localhost:8097/api/v1/slot/interview/slot/tester")
	  .then()
	  .body("[0].description", equalTo("Automation"));
	  
	
  }
  
  @Test
  public void status() {
	  RestAssured
	  .given()
	  .get("http://localhost:8097/api/v1/slot/interview/slot/tester")
	  .then()
	  .body("[0].interviewerName", equalTo("ronaldo"));
	  
	
  }
}
