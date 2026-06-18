package com.tests;

import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.testng.annotations.Test;

public class Login_onrenderTest {
	String Token;
	 String noteId;
  @Test
  
  public String getToken() {
	  Map<String,String> login=new HashMap<>();
	  login.put("email","sam@gmail.com");
	  login.put("password", "123");
	  if (Token==null) {
	  Response response= RestAssured
			  .given().contentType(ContentType.JSON).
			   body(login)
			   .when()
			   .post("https://lms-server-3-wedg.onrender.com/user/login ")
			   .then().
			    statusCode(201)
			   .log().all()
			   .extract().response();
	  
	           System.out.println(response.asPrettyString());
	           Token=response.jsonPath().getString("token");
	           System.out.println("Token:"+Token);
  }	  
  
	
         return Token;
	  }
  }

