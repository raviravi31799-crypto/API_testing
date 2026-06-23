package com.tests;

import org.testng.Assert;
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
  @Test
  
	
	 
  public void getRolewithoutToken() {
	  Response response = RestAssured
              .given()
              .when()
              .get( "https://lms-server-3-wedg.onrender.com/roles/getAll");

      response.then()
              .statusCode(401)
              .log().all();
      
      response.prettyPrint();
      String warningmessage=response.jsonPath().getString("message");
      
      Assert.assertEquals(warningmessage,"User is not logged in");

  } 
  }

