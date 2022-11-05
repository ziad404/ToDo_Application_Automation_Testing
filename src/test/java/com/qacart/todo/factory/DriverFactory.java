package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {
    public WebDriver IntializeDriver(){
        String browser=System.getProperty("browser","CHROME");
        WebDriver driver;
        switch (browser) {
            case ("CHROME") -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case ("EDGE") -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            default -> throw new RuntimeException("Browser not supported");
        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }
}
