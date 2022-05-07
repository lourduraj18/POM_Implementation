package com.userService;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getUserService {
  @Test
  public void getUser() {
	  RestAssured.baseURI= "http://localhost:8090/api/v1/user/ajay@gmail.com";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.request(Method.GET,"");
	  System.out.println("status received= "+response.prettyPrint());
	  System.out.println("status code :"+ response.statusCode());
  }
  
  @Test
  public void id() {
	  RestAssured
	  .given()
	  .get("http://localhost:8090/api/v1/user/ajay@gmail.com")
	  .then()
	  .body("userEmailId", equalTo("ajay@gmail.com"));
	  
	
  }
  
  @Test
  public void status() {
	  RestAssured
	  .given()
	  .get("http://localhost:8090/api/v1/user/ajay@gmail.com")
	  .then()
	  .body("userName", equalTo("Ajay A"));
	  
	
  }
}
