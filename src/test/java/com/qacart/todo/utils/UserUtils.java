package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

public class UserUtils {
    public  static User GenerateRandomUsers(){
        String FirstName=new Faker().name().firstName();
        String LastName=new Faker().name().lastName();
        String Email=new Faker().internet().emailAddress();
        String Password=new Faker().internet().password();
        return new User(FirstName,LastName,Email,Password);
    }
}
