package com.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExerciseNinePage extends BasePage {
    public ExerciseNinePage(WebDriver driver) {
        super(driver);
    }
    By shadowHost = By.cssSelector("guid-generator");
    By shadowElement = By.cssSelector("button[id=buttonGenerate]");
    By buttonCopy = By.cssSelector("button[id=buttonCopy]");
    By editField = By.cssSelector("input[id=editField]");


    public void clickFirstElement() throws Exception {
        clickOnShadowButton(shadowHost,shadowElement);
    }
    public void showText() throws Exception {
        clickOnShadowButton(shadowHost,buttonCopy);
        String text = getValueOnShadowElement(shadowHost,editField);
        System.out.println("El valor del campo de texto es: " + text);

    }
}
