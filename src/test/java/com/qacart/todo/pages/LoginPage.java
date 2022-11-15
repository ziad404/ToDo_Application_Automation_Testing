package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement EmailInput;

    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement PassInput;

    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submitbtn;
    @Step
    public TodoPage login(String email,String password){
        EmailInput.sendKeys(email);
        PassInput.sendKeys(password);
        submitbtn.click();
        return new TodoPage(driver);
    }
    @Step("Load the login page")
    public LoginPage load(){
        driver.get(ConfigUtils.GetInstance().GetBaseUrl());
        return this;
    }
}
