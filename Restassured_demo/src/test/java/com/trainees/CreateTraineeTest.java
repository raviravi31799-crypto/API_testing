package com.trainees;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateTraineeTest {
  @Test
  public void f() {
	 Map<String,String> trainee_data=new HashMap<>();
	  //JSONObject trainee_data=new JSONObject();
	 trainee_data.put("Name","Leela");
	 trainee_data.put("email","leela@gmail.com");
	 trainee_data.put("Company","Bosch");
	 trainee_data.put("Id","07");
	 Response response =RestAssured.given().contentType(ContentType.JSON).body(trainee_data).when().post("http://localhost:3000/trainees");
		System.out.println("Statuscode:"+response.statusCode());
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 201);
		Assert.assertEquals(response.jsonPath().getString("Name"),"Leela");
	 
	    }
}
