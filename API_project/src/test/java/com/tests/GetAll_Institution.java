package com.tests;
import io.restassured.RestAssured;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAll_Institution {
  @Test
  public void f() {
	  Response response=RestAssured
			  .given()
			  .when().get("https://lms-server-3-wedg.onrender.com/getAll/institution")
			  .then()
			  .log().all()
			 .extract().response();
	  System.out.println("statuscode:"+response.statusCode());
	  Assert.assertEquals(response.statusCode(),200);
	  System.out.println(response.asPrettyString());
	  
	
  }
}
