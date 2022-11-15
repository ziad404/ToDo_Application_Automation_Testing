package com.qacart.todo.api;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import  static io.restassured.RestAssured.given;

public class RegisterApi {
    private Cookies restAssuredCookies;
     private String accessToken;
     private String UserId;
     private  String FirstName;

    public String getFirstName() {
        return FirstName;
    }

    public String getUserId() {
        return UserId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Cookies getRestAssuredCookies() {
        return restAssuredCookies;
    }

    public void register(){
            User user=UserUtils.GenerateRandomUsers();
            Response response=
                    given()
                          .baseUri("https://qacart-todo.herokuapp.com")
                          .header("Content-Type","application/json")
                          .body(user)
                          .log().all()
                    .when()
                          .post("https://qacart-todo.herokuapp.com/api/v1/users/register")
                    .then()
                          .log().all()
                          .extract().response();
            if(response.statusCode() != 201){
                throw new RuntimeException("Something went wrong with this request");
            }
            restAssuredCookies=response.detailedCookies();
            accessToken=response.path("access_token");
            UserId=response.path("userID");
            FirstName=response.path("firstName");
    }
}
