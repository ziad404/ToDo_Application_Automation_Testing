package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomemessage;
    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteTodo;
    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement notodos;
    public boolean isWelcomeDisplayed(){
        return welcomemessage.isDisplayed();
    }
    public TodoPage deleteTodo(){
        deleteTodo.click();
        return this;
    }
    public boolean NotodosAfterDeletion(){
        return notodos.isDisplayed();
    }
}
