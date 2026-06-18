package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserTest {
  @Test
  public void f() {
	  Response response=RestAssured.given()
			  .when().get("https://jsonplaceholder.typicode.com/users/2");
	  System.out.println("Statuscode:"+response.statusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.getStatusCode(), 200);
	  String name=response.jsonPath().getString("name");
	  Assert.assertEquals(name,"Ervin Howell");
			  
  }
}
