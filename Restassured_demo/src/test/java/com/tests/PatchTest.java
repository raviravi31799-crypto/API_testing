package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchTest {
  @Test
  public void f() {
	  
	  Map<String,String> data_patch=new HashMap<>();
	  data_patch.put("title","Senior manager");
	  Response response=RestAssured.given().contentType(ContentType.JSON).body(data_patch).when().patch("https://jsonplaceholder.typicode.com/posts/1");
	  System.out.println("Status code:"+response.statusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.statusCode(), 200);
	 
  }
}
