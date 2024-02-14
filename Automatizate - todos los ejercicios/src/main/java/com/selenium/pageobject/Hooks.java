package com.selenium.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static WebDriver driver;

    public static WebDriver getDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
}

