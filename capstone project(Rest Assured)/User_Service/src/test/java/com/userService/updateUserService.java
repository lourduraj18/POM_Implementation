package com.userService;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class updateUserService {
	@BeforeTest
    public void setupBaseUrl() {
        RestAssured.baseURI = "http://localhost:8090/api/v1/user/";
    }
  @Test
  public void updateDoctor() {
      RestAssured
      .given()
      .log()
      .all()
      .header("Content-type", "application/json")
      .and()
      .body("{\n"
    		  +"\"userEmailId\":\"ajay@gmail.com\",\n"
    		  +"\"userName\":\"Ajay AR\",\n"
    		  +"\"phoneNo\":\"9988776655\",\n"
    		  +"\"password\":\"Ajay@23\",\n"
    		  +"\"department\":\"IT\"\n"
                 + "}")
      .when()
      .put("ajay@gmail.com")
      .then()
      .log()
      .all();
  }
}
