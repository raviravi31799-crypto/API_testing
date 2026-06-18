package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class QueryparamTest {
  @Test
  public void f() {
	  Response response=RestAssured.given().when().get("https://jsonplaceholder.com/users?id=2");
	  int statuscode=response.statusCode();
	  System.out.println("Statuscode:"+statuscode);
	  response.prettyPrint();
	  Assert.assertEquals(statuscode,200);
  }
}
