package com.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class GetcoursestructureTest extends Login_onrenderTest {
  @Test
  public void f() {
        Response response = RestAssured
	                  .given()
	                  .header("Authorization", "Bearer " + getToken())
	                  .when()
	                  .get("https://lms-server-3-wedg.onrender.com/courses-structure/getAll");

	          response.then()
	                  .statusCode(200)
	                  .log().all();

	      }

	  
  }

