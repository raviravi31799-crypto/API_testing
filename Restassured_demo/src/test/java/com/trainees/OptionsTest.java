package com.trainees;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OptionsTest {
  @Test
  public void f() {
	  Response response = RestAssured
              .given()
              .when()
              .options("http://localhost:3000/trainees");

      System.out.println("Status Code: " + response.statusCode());
      
  }
}
