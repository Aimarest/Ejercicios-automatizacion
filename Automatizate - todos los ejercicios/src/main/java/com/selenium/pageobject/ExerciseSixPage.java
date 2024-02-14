package com.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExerciseSixPage extends BasePage {
    public ExerciseSixPage(WebDriver driver) {
        super(driver);
    }
    By cookiesButton = By.xpath("//button[@aria-label='Consentir']");
    By firstNameInput = By.xpath("//input[@placeholder='First Name']");
    By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
    By userEmailInput = By.xpath("//input[@placeholder='name@example.com']");
    By genderRadio1 = By.xpath("//input[@value='Male']");
    By userNumberInput = By.xpath("//input[@placeholder='Mobile Number']");
    By dateOfBirthInput = By.xpath("//input[@value='14 Feb 2024']");
    By subjectsContainer = By.xpath("//label[contains(text(),'Subjects')]/ancestor::div[2]/descendant::input[@type='text']");
    By hobbiesSports = By.xpath("//label[@for='hobbies-checkbox-1']/ancestor::div[3]/descendant::input[@value='1']");
    By uploadPictureButton = By.xpath("//input[@type='file']");
    By currentAddressInput = By.xpath("//textarea[@placeholder='Current Address']");
    By stateFixedbanInput = By.xpath("//label[contains(text(),'State and City')]/ancestor::div[2]/descendant::input[1]");
    By SelectCity =  By.xpath("//label[contains(text(),'City')]/ancestor::div[2]/descendant::input[2]");

    String firstName = "Joaquín";
    String secondName = "Sánchez";
    String userEmail = "joaquinBetis@gmail.com";
    String numberphone = "6529515070";
    String date = "21 jul 1981";
    String subjet = "Arts";
    String picturePath = "C:\\Users\\amarcose\\Pictures\\Saved Pictures\\nttdata.png.jpg";
    String currentAddress = "La cartuja";
    String state = "NCR";
    String city = "Delhi";

    public void acceptCookies() throws Exception {
        waitToClick(cookiesButton);
    }

    public void fillInputs () throws Exception {
        sendKeys(firstNameInput, firstName);
        sendKeys(lastNameInput,secondName);
        sendKeys(userEmailInput,userEmail);
        WebElement genderRadio = getElement(genderRadio1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", genderRadio);
        sendKeysControl(dateOfBirthInput,date);
        createWait(subjectsContainer);
        sendKeysControl(subjectsContainer,subjet);
        WebElement hobbiesCheck = getElement(hobbiesSports);
        js.executeScript("arguments[0].click();", hobbiesCheck);
        sendKeys(uploadPictureButton, picturePath);
        sendKeys(currentAddressInput,currentAddress);
        sendKeysControl(stateFixedbanInput,state);
        sendKeysControl(SelectCity,city);
        sendKeys(userNumberInput,numberphone);
    }

}
