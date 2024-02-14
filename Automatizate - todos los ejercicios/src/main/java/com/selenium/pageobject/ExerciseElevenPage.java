package com.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExerciseElevenPage extends BasePage {
    public ExerciseElevenPage(WebDriver driver) {
        super(driver);
    }

    By cookiesButton = By.xpath("//button[@aria-label='Consentir']");
    By firstNameInput = By.xpath("//input[@placeholder='First Name']");
    By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
    By userEmailInput = By.xpath("//input[@placeholder='name@example.com']");
    By genderRadio1 = By.xpath("//input[@value='Male']");
    By userNumberInput = By.xpath("//input[@placeholder='Mobile Number']");
    By dateOfBirthInput = By.xpath("//div[contains(@class,'datepicker__input')]/input");
    By subjectsContainer = By.xpath("//label[contains(text(),'Subjects')]/ancestor::div[2]/descendant::input[@type='text']");
    By hobbiesSports = By.xpath("//label[@for='hobbies-checkbox-1']/ancestor::div[3]/descendant::input[@value='1']");
    By labelSport = By.xpath("//label[@for ='hobbies-checkbox-1']");
    By uploadPictureButton = By.xpath("//input[@type='file']");
    By currentAddressInput = By.xpath("//textarea[@placeholder='Current Address']");
    By stateFixedbanInput = By.xpath("//label[contains(text(),'State and City')]/ancestor::div[2]/descendant::input[1]");
    By SelectCity =  By.xpath("//label[contains(text(),'City')]/ancestor::div[2]/descendant::input[2]");
    By ArtsLabel = By.xpath("//div[@id='subjectsContainer']/descendant::div[contains(text(),'Arts')]");
    String stringForValidate = "";
    By validateForm = By.xpath("//td[contains(text(), '" + stringForValidate + "')]");
    By NCR = By.xpath("//div[contains(text(),'NCR')]");
    By Delhi = By.xpath("//div[contains(text(),'Delhi')]");
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
    String TextFileInput = "No se ha seleccionado ningún archivo";

    public void acceptCookies() throws Exception {
        waitToClick(cookiesButton);
    }
    public void validateSubjectsUpdated() throws Exception {
        if(isVisible(ArtsLabel)){
            System.out.println("The option Arts is selected");
        };
    }
    public void validateStateUpdated() throws Exception {
        if(isVisible(NCR)){
            System.out.println("The state NCR is selected");
        };
    }
    public void validateCityUpdated() throws Exception {
        if(isVisible(Delhi)){
            System.out.println("The city Delhi is selected");
        };
    }
    public void validateInput(String value) throws Exception {
        stringForValidate = value;
        if(validatePresenceOfElementAtForm(validateForm)){
            System.out.println(value);
        };
    }
    public void validateInputImage() throws Exception {
        stringForValidate = "nttdata.png.jpg";
        if(validatePresenceOfElementAtForm(validateForm)){
            System.out.println(stringForValidate);
        };
    }
    public void fillInputs () throws Exception {
        System.out.println("Rellenamos el formulario y confirmamos que los valores se están marcando: ");
        sendKeys(firstNameInput, firstName);
        ValidateInnerText(firstNameInput,firstName);
        sendKeys(lastNameInput,secondName);
        ValidateInnerText(lastNameInput,secondName);
        sendKeys(userEmailInput,userEmail);
        ValidateInnerText(userEmailInput,userEmail);
        WebElement genderRadio = getElement(genderRadio1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", genderRadio);
        isSelected(genderRadio1);
        sendKeysControl(dateOfBirthInput,date);
        createWait(subjectsContainer);
        ValidateInnerText(dateOfBirthInput,date);
        sendKeysControl(subjectsContainer,subjet);
        validateSubjectsUpdated();
        WebElement hobbiesCheck = getElement(hobbiesSports);
        js.executeScript("arguments[0].click();", hobbiesCheck);
        isSelected(hobbiesSports);
        sendKeys(uploadPictureButton, picturePath);
        ValidateImageByName(uploadPictureButton,TextFileInput);
        sendKeys(currentAddressInput,currentAddress);
        ValidateInnerText(currentAddressInput,currentAddress);
        sendKeysControl(stateFixedbanInput,state);
        validateStateUpdated();
        sendKeysControl(SelectCity,city);
        validateCityUpdated();
        sendKeys(userNumberInput,numberphone);
        ValidateInnerText(userNumberInput,numberphone);
    }
    public void validateForm () throws Exception {
        System.out.println("Confirmamos que los valores se están mostrando bien en el modal final: ");
        validateInput(firstName);
        validateInput(secondName);
        validateInput(userEmail);
        String genre = getAtribute(genderRadio1, "value");
        validateInput(genre);
        validateInput(numberphone);
        validateInput(date);
        validateInput(subjet);
        String hobby = getAtribute(labelSport,"innerText");
        validateInput(hobby);
        validateInputImage();
        validateInput(currentAddress);
        validateInput(state);
        validateInput(city);
    }
}


