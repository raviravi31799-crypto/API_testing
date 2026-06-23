package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HealthCheck {
  @Test
  public void healthcheck() {
	  Response response=RestAssured
			           .given()
			           .when()
			           .get("https://lms-server-3-wedg.onrender.com/");
	  System.out.println("statuscode:"+response.statusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.statusCode(), 200);
  }
}
