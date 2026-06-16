package com.trainees;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Login_traineesTest {
  @Test
  public void f() {
	  Map<String,String>login=new HashMap<>();
	  login.put("username","admin");
	  login.put("password","admin123");
	  Response response=RestAssured.given().contentType(ContentType.JSON).body(login).when().post("http://localhost:3000/trainees");
	  System.out.println("Statuscode:"+response.statusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.statusCode(), 201);
	  
  }
  
}
