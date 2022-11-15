package com.qacart.todo.pages;

import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewToDoPage {
    private WebDriver driver;
    public NewToDoPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css ="[data-testid=\"add\"]")
    private WebElement addbtn;

    @FindBy(css ="[data-testid=\"new-todo\"]")
    private WebElement addnewtodo;

    @FindBy(css ="[data-testid=\"submit-newTask\"]")
    private WebElement submittaskbtn;
    @FindBy(css ="[data-testid=\"todo-item\"]")
    private WebElement actualaddedtext;
    @Step
    public  TodoPage addNewToDo(String Todoname){
        addbtn.click();
        addnewtodo.sendKeys(Todoname);
        submittaskbtn.click();
        return new  TodoPage(driver);
    }
    public TodoPage load(){
        driver.get(ConfigUtils.GetInstance().GetBaseUrl()+"/todo");
        return new TodoPage(driver);
    }
    public String getAddedText(){
         return actualaddedtext.getText();
    }
}
