package com.tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetallNotesTest extends Login_onrenderTest {
  @Test
  public void f() {
	 
     Response response = RestAssured
	                  .given()
	                  .header("Authorization", "Bearer " + getToken())
	                  .queryParam("limit", 2)
	                  .queryParam("sortOrder", "desc")
	                  .when()
	                  .get( "https://lms-server-3-wedg.onrender.com/getAll/notes");

	          response.then()
	                  .statusCode(200)
	                  .log().all();

	      }

	  
  }

