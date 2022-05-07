package com.userService;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getAllUser {
  @Test
  public void getAll() {
	  RestAssured.baseURI= "http://localhost:8090/api/v1/users";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.request(Method.GET,"");
	  System.out.println("status received= "+response.prettyPrint());
	  System.out.println("status code :"+ response.statusCode());
  }
  
  @Test
  public void id() {
	  RestAssured
	  .given()
	  .get("http://localhost:8090/api/v1/users")
	  .then()
	  .body("[1].userEmailId", equalTo("joel@gmail.com"));
	  
	
  }
  
  @Test
  public void name() {
	  RestAssured
	  .given()
	  .get("http://localhost:8090/api/v1/users")
	  .then()
	  .body("[2].userName", equalTo("babu"));
}
}
