package com.trainees;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Update_putTest {
  @Test
  public void f() {
	  Map<String,String> data=new HashMap<>();
	  data.put("name", "Usha");
	  data.put("id","1");
	  data.put("email"," usha@gmail.com");
	  data.put("company","Smartcliff");
	  Response response=RestAssured.given().contentType(ContentType.JSON).body(data).when().put("http://localhost:3000/trainees/01");
	  System.out.println("statuscode:"+response.statusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.statusCode(),200);
	  Assert.assertEquals(response.jsonPath().getString("name"),"Usha");
  }
}
