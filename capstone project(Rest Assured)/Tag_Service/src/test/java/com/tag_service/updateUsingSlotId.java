package com.tag_service;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class updateUsingSlotId {
	@BeforeTest
    public void setupBaseUrl() {
        RestAssured.baseURI = "http://localhost:8097/api/v1/slot/status/";
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
    		  +"\"techTrack\":\"developer\",\n"
    		  +"\"interviewerEmailId\":\"ajayro@gmail.com\",\n"
    		  +"\"interviewerName\":\"ajay ro\",\n"
                 +"\"startTime\":\"11:30:00\",\n"
                 +"\"endTime\":\"12:40:00\",\n"
                 +"\"date\":\"2022:06:03\",\n"
                 +"\"description\":\"Automation\",\n"
                 +"\"bookedStatus\":\"UNAVAILABLE\"\n"
                 + "}")
      .when()
      .put("SLOT3")
      .then()
      .log()
      .all();
  }
}
