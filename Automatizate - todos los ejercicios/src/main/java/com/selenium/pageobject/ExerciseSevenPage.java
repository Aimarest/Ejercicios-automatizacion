package com.selenium.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ExerciseSevenPage extends BasePage {
    public ExerciseSevenPage(WebDriver driver) {
        super(driver);
    }
    By cookiesButton = By.xpath("//button[@aria-label='Consentir']");
    By alertButton = By.id("alertButton");
    By timerAlertButton = By.id("timerAlertButton");
    By confirmButton = By.id("confirmButton");
    By promtButton = By.id("promtButton");
    String Selenium = "Selenium";

    public void acceptCookies() throws Exception {
        waitToClick(cookiesButton);
    }

    public void interactWithFirstAlert() throws Exception {
        waitToClick(alertButton);
        Alert FirstAlert = driver.switchTo().alert();
        FirstAlert.accept();
    }
    public void interactWithSecondAlert() throws Exception {
        waitToClick(timerAlertButton);
        waitToSwitchAlert();
        Alert SecondAlert = driver.switchTo().alert();
        SecondAlert.accept();
    }
    public void interactWithThirdAlert() throws Exception {
        WebElement button = getElement(confirmButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", button);
        waitToClick(confirmButton);
        Alert ThirdAlert = driver.switchTo().alert();
        ThirdAlert.accept();
    }
    public void interactWithFourthAlert() throws Exception {
        waitToClick(promtButton);
        Alert FourthAlert = driver.switchTo().alert();
        FourthAlert.sendKeys(Selenium);
        FourthAlert.accept();
    }

}
