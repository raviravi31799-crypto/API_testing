package com.trainees;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTraineeTest {
  @Test
  public void f() {
	  Response response=RestAssured.given().when().get("http://localhost:3000/trainees/01");
	  System.out.println("Statuscode:"+response.statusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.statusCode(), 200);
	  Assert.assertEquals(response.jsonPath().getString("name"), "Joshi");
	  
	  
  }
}
