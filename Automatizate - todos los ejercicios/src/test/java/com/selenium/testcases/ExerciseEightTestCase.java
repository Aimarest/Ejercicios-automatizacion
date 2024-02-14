package com.selenium.testcases;

/*  Ejercicio 8:
    Navegar a https://demoqa.com/nestedframes
    Leer los textos de las cajas e imprimirlos por consola
                                                        */


import com.selenium.pageobject.ExerciseEightPage;
import com.selenium.pageobject.Hooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ExerciseEightTestCase {
    String url = "https://demoqa.com/nestedframes";
    protected WebDriver driver = Hooks.getDriver(url);
    ExerciseEightPage ExerciseEightPage;
    @Before
    public void setUp() throws Exception {

        System.out.println("Se está ejecutando el test del ejercicio 8 " );
        ExerciseEightPage = new ExerciseEightPage(driver);

    }
    @Test
    public void TestExerciseEight() throws Exception {

        /* Utilizo los métodos definidos en el pageObject del ejercicio 8 */

        ExerciseEightPage.acceptCookies();
        ExerciseEightPage.interactToFirstFrame();
        ExerciseEightPage.interactToSecondFrame();

    }
    @After
    public void tearDown() {
        //driver.quit();
        System.out.println("Ha finalizado la ejecución del test.");
    }
}
