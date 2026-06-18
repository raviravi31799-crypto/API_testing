package com.tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetRoleTest extends Login_onrenderTest {
  @Test
  
	
	 
	      public void getRoleTest() {

	          Response response = RestAssured
	                  .given()
	                  .header("Authorization", "Bearer " + getToken())
	                  .when()
	                  .get( "https://lms-server-3-wedg.onrender.com/roles/getAll");

	          response.then()
	                  .statusCode(200)
	                  .log().all();
	          
	          response.prettyPrint();

	      }

	  
  }

