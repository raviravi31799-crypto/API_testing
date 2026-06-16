package com.trainees;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_traineesTest {
  @Test
  public void f() {
	  Response response=RestAssured.given().when().delete("http://localhost:3000/trainees/dz63t5bvOPQ");
	  System.out.println("Statuscode:"+response.statusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.statusCode(),200);
	  Assert.assertTrue(response.time()<3000);
  }
}
