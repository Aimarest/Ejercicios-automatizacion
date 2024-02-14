package com.selenium.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static com.selenium.utils.Common.getSublist;

/* Esta clase contiene los métodos en los que se utilizan los comandos de Selenium, luego éstos serán utilizados en los diferentes pageObjects. */

public class BasePage {

    protected WebDriver driver;

    /* Declaro el producto en una variable para que pueda ser cambiado por otro. */
    String product = "compresor electrico";
    Boolean visible = false;
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void click(By locator) throws Exception {
        try {
            driver.findElement(locator).click();
        }catch (Exception e) {
            throw new Exception("Could not click on the button with the locator " +  locator );
        }
    }
    public WebElement getElement(By locator) throws Exception {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            WebElement element = driver.findElement(locator);
            return element;
        }catch (Exception e) {
            throw new Exception("Could not get the element with the locator " +  locator );
        }
    }
    public void sendKeysControl (By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }
    public void validateTitle(String title) throws Exception {
        try {
            String titlePage = driver.getTitle();
            String expectedTitle = title;

            if (titlePage.equalsIgnoreCase(expectedTitle) || titlePage.contains(title)) {
                System.out.println("Title Matched");

            } else System.out.println("Title didn't match");
        } catch (Exception e) {
            throw new Exception("The title page is not the expected");
        }
    }
    public void ValidateElementOfAPage(By locator, String stringSearched) throws Exception {
        try {
            WebElement element = driver.findElement(locator);
            String name = element.getAttribute("aria-label");
            if (name.contains(stringSearched)){
                System.out.println("The string searched matched with the text of the element at the current page ");
            } else System.out.println("The string searched didn't match with the text of the element at the current page");
        }catch (Exception e) {
            throw new Exception("The element wich we try to compare is not enable yet");
        }
    }
    public void ValidateInnerText(By locator, String stringSearched) throws Exception {
        try {
            WebElement element = driver.findElement(locator);
            String text = element.getAttribute("value");
            if (stringSearched.equalsIgnoreCase(text)){
                System.out.println("The string searched matched with the text of the element at the current page");
            } else System.out.println("The string searched didn't match with the text of the element at the current page");
        }catch (Exception e) {
            throw new Exception("The element wich we try to compare is not enable yet");
        }
    }
    public void ValidateImageByName(By locator, String stringSearched) throws Exception {
        try {
            WebElement element = driver.findElement(locator);
            String text = element.getAccessibleName();
            if (text.contains(stringSearched)){
                System.out.println("The image is not uploaded");
            } else System.out.println("The image is already uploaded " );
        }catch (Exception e) {
            throw new Exception("The element wich we try to compare is not enable yet");
        }
    }
    public void moveToIframe(By locator) throws Exception {
        try{
            WebElement iframe = driver.findElement(locator);
            driver.switchTo().frame(iframe);
        }catch (Exception e){
            throw new Exception("Is not possible switch to this iframe");
        }
    }
    public void waitToClick(By locator) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = driver.findElement(locator);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }catch (Exception e) {
            throw new Exception("The element is not clickable yet");
        }

    }
   public void createWait(By locator) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       WebElement element = driver.findElement(locator);
       wait.until(ExpectedConditions.visibilityOf(element));
   }
    public void sendKeys(WebElement input, String text) throws Exception {

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(input));
            input.clear();
            input.sendKeys(text);
            input.submit();
        }catch (Exception e) {
            throw new Exception("Is not possible write and send text at the element with this element , is not enabled yet");
            }
        }

    public void sendKeys(By locator, String text) throws Exception {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            WebElement input = driver.findElement(locator);
            input.clear();
            input.sendKeys(text);
            input.submit();
        }catch (Exception e) {
            throw new Exception("Is not possible write and send text at the element with this locator , is not enabled yet");
        }
    }
    public WebElement getOneElementOfTheList(List<WebElement> list, int position) throws Exception {
        try{
            return list.get(position);
        }catch (Exception e) {
            throw new Exception("Is not possible get this element of the list");
        }
    }
    public void waitToSwitchAlert() throws Exception {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
        }catch (Exception e) {
            throw new Exception("The alert is not present yet ");
        }
    }
    public void clickOnOneElementOfTheList(By locator, int position) throws Exception {
        try {
            List<WebElement> list = driver.findElements(locator);
            WebElement element = getOneElementOfTheList(list, position);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new Exception("Is not possible click on this element of the list");
        }
    }
    public String getTextOfOneElementOfTheList(By locator, int position) throws Exception {
        try {
            List<WebElement> list = driver.findElements(locator);
            String text = getOneElementOfTheList(list,position).getAttribute("title");
            return text;
        }catch (Exception e) {
            throw new Exception("Is not possible get this text");
        }
    }

    public ArrayList<Double> getDoublePrimePrices(List <WebElement> elements) throws Exception {
        try {
            List<List<WebElement>> spansOfMoney = getSublist(elements, 3);
            ArrayList<Double> allPrices = new ArrayList<>();
            Double completePrice;

            for (List<WebElement> spanMoney : spansOfMoney) {

                Double euros = 0.0;
                Double cents = 0.0;

                for (int j = 0; j < spanMoney.size(); j++) {
                    String money = spanMoney.get(j).getText();
                    if (j == 0) {
                        euros = new Double(money);
                    } else if (j == 1) {
                        cents = new Double(money) / 100;
                    }
                }
                completePrice = euros + cents;
                allPrices.add(completePrice);
            }
            return allPrices;
        }catch (Exception e) {
            throw new Exception("Is not possible get the double valor of the prices");
        }
    }
    public List<WebElement> getListOfElements (By locator) throws Exception {
        try{
            List<WebElement> oneList = driver.findElements(locator);
            return oneList;
        }catch (Exception e) {
            throw new Exception("Is not possible get the list");
        }

    };
    public int getTheLastPosition(By locator) throws Exception {
        try {
            List<WebElement> list = getListOfElements(locator);
            int lastPosition = list.size() - 1;
            return lastPosition;
        }catch (Exception e) {
            throw new Exception("Is not possible get the last position of the list");
        }
    }
    public String getInnerText(By locator) {
        WebElement element = driver.findElement(locator);
        String textElement = element.getAttribute("innerText");
        return textElement;
    }
    public String getAtribute(By locator, String atributte) {
        WebElement element = driver.findElement(locator);
        String textAtributte = element.getAttribute(atributte);
        return textAtributte;
    }
    public void moveToSecondWindow () throws Exception {
        try {
            //Obtener todas las ventanas
            Set<String> allHandles = driver.getWindowHandles();

            //Obtener la ventana actual
            String currentWindowHandle = allHandles.iterator().next();

            //Eliminarla
            allHandles.remove(allHandles.iterator().next());

            //Obtener la segunda ventana
            String lastHandle = allHandles.iterator().next();

            //Cambiar a la segunda ventana
            driver.switchTo().window(lastHandle);

        }catch (Exception e) {
            throw new Exception("Is not possible move to the second window");
        }
    }
    public void doubleClick(By locator) throws Exception {
        try{
            WebElement element = driver.findElement(locator);
            element.click();
            element.click();
        }catch (Exception e) {
            throw new Exception("Is not possible click two times at the element with locator " + locator);
        }
    }
    public void showNews (By locator) throws Exception {
        try {
            List<WebElement> list = driver.findElements(locator);
            for (int i = 0; i < list.size(); i++) {
                String title = list.get(i).getText();
                System.out.println("La noticia nº " + (i + 1) + " es: " + title);
            }
        }catch (Exception e) {
            throw new Exception("Could not show the news of the list");
        }
    }
    public void click(WebElement element) throws Exception {
        try {
            element.click();
        }catch (Exception e) {
            throw new Exception("Could not click on the button " +  element);
        }
    }
    public boolean isDisplayed(By locator) throws Exception {
        Boolean isDisplayed = false;
        try {
            WebDriverWait wait = new WebDriverWait( driver,  Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if(driver.findElement(locator).isDisplayed()){
                isDisplayed = true;
            }
        }catch (Exception e) {
            throw new Exception("The element with this locator " + locator + " is not displayed yet");
        }
        return isDisplayed;
    }
    public void isSelected(By locator) throws Exception {
        try{
            WebElement element = driver.findElement(locator);
            if(element.isSelected()){
                String value = element.getAttribute("value");
                System.out.println("The option " + value + " is selected");
            }else {
                String value = element.getAttribute("value");
                System.out.println("The option " + value + " is not selected");
            }
        }catch (Exception e) {
            throw new Exception("Is not possible to know if this element is selected");
        }
    }
    public boolean isDisplayed(WebElement element) throws Exception {
        try{
            return element.isDisplayed();
        }catch (Exception e) {
            throw new Exception("The element is not displayed yet");
        }
    }
    public Boolean isVisible(By locator) throws Exception {
        try{
            WebDriverWait wait = new WebDriverWait( driver,  Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("The element is visible");
            visible = true;
        }catch (Exception e) {
            throw new Exception("The element is not visible yet");
        }
        return visible;
    };


    public boolean isClickable(By locator) throws Exception{
        try {
            return driver.findElement(locator).isEnabled();
        }catch (Exception e) {
            throw new Exception("The element with this locator " + locator + " is not enabled yet");
        }
    }
    public String getTitle() throws Exception {
        try {
            return driver.getTitle();
        }catch (Exception e) {
            throw new Exception("The title page is not enabled yet");
        }
    }
    public String getTextByLocator(By locator) {
        return  driver.findElement(locator).getText();
    }
    public static void waitForElement(WebDriver driver, WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public List<WebElement> getList(By locator) {
        return driver.findElements(locator);
    }
    public SearchContext getShadowRoot(By locator) throws Exception {
        try{
            WebElement element = driver.findElement(locator);
            return element.getShadowRoot();
        }catch (Exception e) {
            throw new Exception("Is not possible get the shadowRoot");
        }
    }
    public void clickOnShadowButton(By locator, By buttonLocator) throws Exception {
        try {
            SearchContext shadowRoot = getShadowRoot(locator);
            WebElement shadowElement = shadowRoot.findElement(buttonLocator);
            shadowElement.click();

        } catch (Exception e) {
            throw new Exception("Is not possible click to the button at the shadowRoot");
        }
    }
    public String getValueOnShadowElement(By locator, By elementLocator) throws Exception {
        try {
            SearchContext shadowRoot = getShadowRoot(locator);
            WebElement shadowElement = shadowRoot.findElement(elementLocator);
            String value = shadowElement.getAttribute("value");
            return value;

        } catch (Exception e) {
            throw new Exception("Is not possible click to the button at the shadowRoot");
        }
    }
    public boolean validatePresenceOfElementAtForm(By locator) throws Exception {
        boolean isPresent = false;
        try{
            WebDriverWait wait = new WebDriverWait( driver,  Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("This string is present at the form: ");
            isPresent = true;
        }catch (Exception e) {
            throw new Exception("The element is not present");
        }
        return isPresent;
    }

}
