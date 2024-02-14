package com.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExerciseEightPage extends BasePage {
    public ExerciseEightPage(WebDriver driver) {
        super(driver);
    }
    By cookiesButton = By.xpath("//button[@aria-label='Consentir']");
    By iframe1 = By.id("frame1");
    By body = By.tagName("body");
    By iframe2 = By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']");
    By text = By.xpath("//body/p");

    public void acceptCookies() throws Exception {
        waitToClick(cookiesButton);
    }
    public void interactToFirstFrame() throws Exception {
        moveToIframe(iframe1);
        String text = getTextByLocator(body);
        System.out.println("El texto de la primera caja es: " + text);
    }
    public void interactToSecondFrame() throws Exception {
        moveToIframe(iframe2);
        String secondText = getTextByLocator(text);
        System.out.println("El texto de la primera caja es: " + secondText);
    }
}
