package com.selenium.testcases;

/*  Ejercicio 7:
    Navegar a https://demoqa.com/alerts
    Hacer click en los botones y cerrar los mensajes que aparecen
                                                        */
import com.selenium.pageobject.ExerciseSevenPage;
import com.selenium.pageobject.Hooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ExerciseSevenTestCase {

    String url = "https://demoqa.com/alerts";
    protected WebDriver driver = Hooks.getDriver(url);
    ExerciseSevenPage ExerciseSevenPage;
    @Before
    public void setUp() throws Exception {

        System.out.println("Se está ejecutando el test del ejercicio 7 " );
        ExerciseSevenPage = new ExerciseSevenPage(driver);

    }
    @Test
    public void TestExerciseSeven() throws Exception {

        /* Utilizo los métodos definidos en el pageObject del ejercicio 7 */

        ExerciseSevenPage.acceptCookies();
        ExerciseSevenPage.interactWithFirstAlert();
        ExerciseSevenPage.interactWithSecondAlert();
        ExerciseSevenPage.interactWithThirdAlert();
        ExerciseSevenPage.interactWithFourthAlert();
    }
    @After
    public void tearDown() {
        //driver.quit();
        System.out.println("Ha finalizado la ejecución del test.");
    }
}


