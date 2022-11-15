package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewToDoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Todo Feature")
public class TodoTest extends BaseTest {
   // private WebDriver driver;
    @Story("Add todo")
    @Description("It will add new not completed task ")
    @Test(description = "Should be able to add new todo correctly")
    public void ShouldBeAbleToAddnewToDo() throws InterruptedException {
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.load()
        .login("ziadelsoudy@gmail.com","123456789");
        NewToDoPage newToDoPage=new NewToDoPage(getDriver());
        newToDoPage.addNewToDo("Appuim Mobile Testing");
       String Actual= newToDoPage.getAddedText();
        Thread.sleep(3000);
        Assert.assertEquals(Actual,"Appuim Mobile Testing");



    }
    @Story("Delete todo")
    @Description("It will delete last added task ")
    @Test(description = "Should be able to delete todo correctly")
    public void ShouldBeAbleToDeleteToDo() throws InterruptedException {
        RegisterApi registerApi=new RegisterApi();
        registerApi.register();
        TaskApi taskApi=new TaskApi();
        taskApi.addTask(registerApi.getAccessToken());
        LoginPage loginPage=new LoginPage(getDriver());
       loginPage.load()
                .login("ziadelsoudy@gmail.com","123456789")
                .deleteTodo();
        Thread.sleep(3000);
        //Assert.assertTrue(displayed);
    }

}
