package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookieUtils;
import io.qameta.allure.Allure;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.test.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {
    protected ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public WebDriver getDriver() {
        return this.driver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    @BeforeMethod
    public void setup(){
        WebDriver driver=new DriverFactory().IntializeDriver();
        setDriver(driver);
    }
    @AfterMethod
    public void teardown(ITestResult testResult) {
        String TestCaseName=testResult.getMethod().getMethodName();
        File destfile=new File("target"+File.separator+"screenshots"+File.separator+TestCaseName+".png");
        TakeScreenshot(destfile);
        getDriver().quit();
    }
    public void InjectCookiesToBrowser(List<Cookie> RestAssuredCookies){
        List<org.openqa.selenium.Cookie> SeleniumCookies=CookieUtils.ConvertRestAssuredCookiesToSeleniumCookies(RestAssuredCookies);
        for(org.openqa.selenium.Cookie cookie: SeleniumCookies){
            getDriver().manage().addCookie(cookie);
        }
    }
    public void TakeScreenshot(File destfile){
        File file=((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,destfile);
            InputStream is=new FileInputStream(destfile);
            Allure.addAttachment("screenshot",is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
