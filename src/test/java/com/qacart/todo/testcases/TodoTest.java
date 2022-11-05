package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewToDoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {
   // private WebDriver driver;
    @Test
    public void ShouldBeAbleToAddnewToDo(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.load()
        .login("ziadelsoudy@gmail.com","123456789");
        NewToDoPage newToDoPage=new NewToDoPage(driver);
        newToDoPage.addNewToDo("Appuim Mobile Testing");
       String Actual= newToDoPage.getAddedText();
        Assert.assertEquals(Actual,"Appuim Mobile Testing");



    }
    @Test(enabled = false)
    public void ShouldBeAbleToDeleteToDo(){
        LoginPage loginPage=new LoginPage(driver);
        boolean displayed=loginPage.load()
                .login("ziadelsoudy@gmail.com","123456789")
                .deleteTodo()
                .NotodosAfterDeletion();
        Assert.assertTrue(displayed);
    }

}
