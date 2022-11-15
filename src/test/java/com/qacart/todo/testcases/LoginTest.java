package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Auth Feature")
public class LoginTest extends BaseTest {
    @Story("Login with email and password")
    @Description("It will login by filling the fields of Email and password and navigate to the todo page ")
    @Test(description = "Testing Login functionality with Email and Password")
    public void ShouldBeAbleToLoginWithEmailAndPassword() throws InterruptedException {
        LoginPage loginPage=new LoginPage(getDriver());
        //Builder Pattern.
        boolean displayed=
                loginPage.load()
                .login(ConfigUtils.GetInstance().GetEmail(), ConfigUtils.GetInstance().GetPassword())
                .isWelcomeDisplayed();
        Thread.sleep(3000);
        Assert.assertTrue(displayed);
    }
}
