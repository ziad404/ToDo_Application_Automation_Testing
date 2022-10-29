package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
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
    public TodoPage login(String email,String password){
        EmailInput.sendKeys(email);
        PassInput.sendKeys(password);
        submitbtn.click();
        return new TodoPage(driver);
    }
    public LoginPage load(){
        driver.get("https://qacart-todo.herokuapp.com/");
        return this;
    }
}
