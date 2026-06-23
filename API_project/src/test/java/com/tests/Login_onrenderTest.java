package com.tests;

import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_onrenderTest {
	String Token;
	 String noteId;
 
  
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
  @Test
 public void validLogin() {
        	  String token = getToken();
              System.out.println("Valid Login Token : " + token);
         }
  
  
  @Test
  public void invalidEmailLogin() {

      Map<String, String> login = new HashMap<>();
      login.put("email", "invalid@gmail.com");
      login.put("password", "123");

     Response response= RestAssured
              .given()
              .contentType(ContentType.JSON)
              .body(login)
              .when()
              .post("https://lms-server-3-wedg.onrender.com/user/login");
              response.then()
              .statusCode(400)
              .log().all();
      
      String errormessage=response.jsonPath().getString("message[0].value");
      System.out.println("ErrorMessage:"+errormessage);
      Assert.assertEquals(errormessage, "Email is invalid");
      
  }
  @Test
  public void invalidpasswordLogin() {

      Map<String, String> login = new HashMap<>();
      login.put("email", "sam@gmail.com");
      login.put("password", "12345");

     Response response= RestAssured
              .given()
              .contentType(ContentType.JSON)
              .body(login)
              .when()
              .post("https://lms-server-3-wedg.onrender.com/user/login");
              response.then()
              .statusCode(400)
              .log().all();
      
      String errormessage=response.jsonPath().getString("message[0].value");
      System.out.println("ErrorMessage:"+errormessage);
      Assert.assertEquals(errormessage, "Password is incorrect");
      
  }
  @Test
  public void invalidLogin() {

      Map<String, String> login = new HashMap<>();
      login.put("email", "sam@gmail.com");
      login.put("password", "");

     Response response= RestAssured
              .given()
              .contentType(ContentType.JSON)
              .body(login)
              .when()
              .post("https://lms-server-3-wedg.onrender.com/user/login");
              response.then()
              .statusCode(400)
              .log().all();
      
      String errormessage=response.jsonPath().getString("message[0].value");
      System.out.println("ErrorMessage:"+errormessage);
      Assert.assertEquals(errormessage, "All fields are required");
      
  }
  
  }

