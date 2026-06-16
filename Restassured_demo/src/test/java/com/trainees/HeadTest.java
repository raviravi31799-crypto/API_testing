package com.trainees;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HeadTest {
  @Test
  public void f() {
	  Response response=RestAssured.given().when().head("http://localhost:3000/trainees/01");
	  System.out.println("Statuscode:"+response.statusCode());
	  System.out.println("Content-Type:"+response.getHeader("Content-Type"));
	  Assert.assertEquals(response.statusCode(), 200);
	  response.prettyPrint();
  }
}
