package com.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExerciseFourPage extends BasePage {
    public ExerciseFourPage(WebDriver driver) {
        super(driver);
    }
    By cookiesButton = By.xpath("//button[@aria-label='Consentir']");
    By firstNameInput = By.id("firstName");
    By lastNameInput = By.id("lastName");
    By userEmailInput = By.id("userEmail");
    By genderRadio1 = By.id("gender-radio-1");
    By userNumberInput = By.id("userNumber");
    By dateOfBirthInput = By.id("dateOfBirthInput");
    By subjectsContainer = By.id("subjectsInput");
    By hobbiesSports = By.id("hobbies-checkbox-1");
    By uploadPictureButton = By.id("uploadPicture");
    By currentAddressInput = By.id("currentAddress");
    By stateFixedbanInput = By.id("react-select-3-input");
    By SelectCity = By.id("react-select-4-input");

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
