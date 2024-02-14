package com.selenium.testcases;

import com.selenium.pageobject.EstadioDeportivoPage;
import com.selenium.pageobject.Hooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/*   Ejercicios 1,2 y 3:
        Navegar a www.estadiodeportivo.com
        Aceptar las cookies
        Click icono escudo Betis
        Listar por consola todas las noticias principales
        Accede a una noticia
        Listar primera y última noticia del carrusel
        Acceder a la última noticia                          */

public class EstadioDeportivoTestCase {
    String url = "https://www.estadiodeportivo.com/";
    protected WebDriver driver = Hooks.getDriver(url);
    EstadioDeportivoPage EstadioDeportivoPage;
    @Before
    public void setUp() throws Exception {

        System.out.println("Se está ejecutando el test de Estadio Deportivo: " );
        EstadioDeportivoPage = new EstadioDeportivoPage(driver);

    }
    @Test
    public void TestEstadioDeportivo() throws Exception {

        /* Utilizo los métodos definidos en el pageObject de Estadio deportivo */

        EstadioDeportivoPage.validatePage();
        EstadioDeportivoPage.acceptCookies();
        EstadioDeportivoPage.clickOnBetisImage();
        EstadioDeportivoPage.showBetisNews();
        EstadioDeportivoPage.clickOnSecondNew();
        EstadioDeportivoPage.showCarrouselNews();
        EstadioDeportivoPage.clickOnTheLastNew();
    }
    @After
    public void tearDown() {
       // driver.quit();
        System.out.println("Ha finalizado la ejecución del test.");
    }

}
