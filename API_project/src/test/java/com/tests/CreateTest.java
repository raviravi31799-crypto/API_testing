package com.tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateTest extends Login_onrenderTest {
  @Test
  public void f() {
	  
	 String noteId;
              JSONObject payload = new JSONObject();
              payload.put("title", "API Test Note");
	          payload.put("content", "Created by Tester");
	          payload.put("color", "#ffeb3b");
	          payload.put("isPinned", false);

	          Response response = RestAssured
	                  .given()
	                  .header("Authorization", "Bearer " + getToken())
	                  .header("Content-Type", "application/json")
	                  .body(payload.toString())
	                  .when()
	                  .post( "https://lms-server-3-wedg.onrender.com/create/notes");

	          noteId = response.jsonPath().getString("data._id");

	          System.out.println("Created Note Id : " + noteId);

	          response.then()
	                  .statusCode(201)
	                  .log().all();

	      }

	  
  }

