package com.tag_service;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class updateTagService {
	@BeforeTest
    public void setupBaseUrl() {
        RestAssured.baseURI = "http://localhost:8070/api/v1/interview/slot/";
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
    		  +"\"bookedTagEmailId\":\"ragu@gmail.com\",\n"
    		  +"\"bookedTagName\":\"ragu\",\n"
    		  +"\"interviewerEmailId\":\"ronaldo@gmail.com\",\n"
    		  +"\"interviewerName\":\"ronaldo\",\n"
    		  +"\"interviewTopic\":\"IT\",\n"
             +"\"description\":\"Automation\",\n"
                 + "\"techTrack\":\"testing\",\n"
                 +"\"bookedStatus\":\"UPCOMING\",\n"
                 +"\"startTime\":\"11:30:00\",\n"
                 +"\"endTime\":\"12:40:00\",\n"
                 +"\"bookingDate\":\"2022:06:03\"\n"
                 + "}")
      .when()
      .put("BOOKED_SLOT3")
      .then()
      .log()
      .all();
  }
















}
