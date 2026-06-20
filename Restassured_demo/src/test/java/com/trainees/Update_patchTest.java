package com.trainees;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Update_patchTest {
  @Test
  public void f() {
	  String payload =
			  "{\"company\":\"Qualcomm\"}";
	  Response response=RestAssured.given().contentType(ContentType.JSON).body(payload).when().patch("http://localhost:3000/trainees/01");
	  System.out.println("statuscode:"+response.statusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.statusCode(),200);
	  Assert.assertEquals(response.jsonPath().getString("company"), "Qualcomm");
	  
	  
  }
}
