package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTest {
  @Test
  public void f() {
	  Response response=RestAssured.given().pathParam("id",2).when().delete("https://jsonplaceholder.typicode.com/users/{id}");
	  System.out.println("Statuscode:"+response.statusCode());
	  response.prettyPrint();
	  Assert.assertEquals (response.statusCode(),200);
	  
			  
  }
}
