package com.qacart.todo.api;

import com.qacart.todo.objects.Task;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.response.Response;
import net.bytebuddy.implementation.bytecode.Throw;

import static io.restassured.RestAssured.given;

public class TaskApi {
    public void addTask(String token){
        Task task=new Task(false,"Learn cypress");
        Response response=given()
                .baseUri(ConfigUtils.GetInstance().GetBaseUrl())
                .header("Content-Type","application/json")
                .body(task)
                .auth().oauth2(token)
        .when()
                .post("https://qacart-todo.herokuapp.com/api/v1/tasks")
        .then()
                .log().all().extract().response();
        if(response.statusCode()!=201){
             throw new RuntimeException("Error");
        }
    }
}
