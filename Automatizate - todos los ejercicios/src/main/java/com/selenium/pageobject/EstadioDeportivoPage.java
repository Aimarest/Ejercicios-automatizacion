package com.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EstadioDeportivoPage extends BasePage {

    public EstadioDeportivoPage(WebDriver driver) throws Exception {
        super(driver);
    }
    /* Localizadores propios de la página */
    By iframe = By.xpath("//*[@name='__tcfapiLocator']");

    By cookiesButton = By.xpath("//a[@id='acceptAllMain']");
    By betisImage = By.xpath("//img[@alt='Real Betis Balompié']");
    By betisNews = By.xpath("//h2/a");
    By carrouselNews = By.xpath("//div[@class='swiper-wrapper']/descendant::h2/a");
    By carrouselButton = By.xpath("//div[@class='swiper-button-next1 boton redondo']");
    int firstPosition = 0;
    int lastPosition;
    String titlePage = "Estadio Deportivo";
    Actions actions = new Actions(driver);

    public void validatePage() throws Exception {
        validateTitle(titlePage);
    }
    public void acceptCookies() throws Exception {
        WebElement button = getElement(cookiesButton);
        actions.moveToElement(button);
        click(cookiesButton);
    }
    public void clickOnBetisImage() throws Exception {
        click(betisImage);
    }
    public void showBetisNews () throws Exception {
        System.out.println("Listar por consola todas las noticias principales: ");
        showNews(betisNews);
    }
    public void clickOnSecondNew() throws Exception {
        int second = 2;
        clickOnOneElementOfTheList(betisNews,second);
    }
    public void showCarrouselNews() throws Exception {
       // JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("arguments[0].scrollIntoView()", carrouselButton);
        lastPosition = getTheLastPosition(carrouselNews);
        System.out.println("Mostrar por consola la primera y la última noticia del carrousel: ");
        String firstNew = getTextOfOneElementOfTheList(carrouselNews,firstPosition);
        String lastNew = getTextOfOneElementOfTheList(carrouselNews,lastPosition);
        System.out.println("La primera noticia del carrousel es esta: " + firstNew);
        doubleClick(carrouselButton);
        System.out.println("La última noticia del carrousel es esta: " + lastNew);
    }
    public void clickOnTheLastNew() throws Exception {
        System.out.println("Accedo a la última noticia del carrousel");
        lastPosition = getTheLastPosition(carrouselNews);
        clickOnOneElementOfTheList(carrouselNews,lastPosition);
    }
}
