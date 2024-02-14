package com.selenium.testcases;

/*  Ejercicio 6:
    Navegar a https://demoqa.com/automation-practice-form
    Rellenar el formulario usando xpath para localizar el label de los campos y luego rellenarlos (Prohibido ID's)  */

import com.selenium.pageobject.ExerciseSixPage;
import com.selenium.pageobject.Hooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ExerciseSixTestCase {
    String url = "https://demoqa.com/automation-practice-form";
    protected WebDriver driver = Hooks.getDriver(url);
    ExerciseSixPage ExerciseSixPage;
    @Before
    public void setUp() throws Exception {

        System.out.println("Se está ejecutando el test del ejercicio 6 " );
        ExerciseSixPage = new ExerciseSixPage(driver);

    }
    @Test
    public void TestExerciseSix() throws Exception {

        /* Utilizo los métodos definidos en el pageObject del ejercicio 6 */

        ExerciseSixPage.acceptCookies();
        ExerciseSixPage.fillInputs();
    }
    @After
    public void tearDown() {
        //driver.quit();
        System.out.println("Ha finalizado la ejecución del test.");
    }

}
