package com.selenium.testcases;

/*  Ejercicio 5:
    Navegar a https://demoqa.com/automation-practice-form
    Rellenar el formulario usando xpath de los campos
 */

import com.selenium.pageobject.ExerciseFivePage;
import com.selenium.pageobject.Hooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ExerciseFiveTestCase {
    String url = "https://demoqa.com/automation-practice-form";
    protected WebDriver driver = Hooks.getDriver(url);
    ExerciseFivePage ExerciseFivePage;
    @Before
    public void setUp() throws Exception {

        System.out.println("Se está ejecutando el test del ejercicio 5 " );
        ExerciseFivePage = new ExerciseFivePage(driver);

    }
    @Test
    public void TestExerciseFive() throws Exception {

        /* Utilizo los métodos definidos en el pageObject del ejercicio 5 */

        ExerciseFivePage.acceptCookies();
        ExerciseFivePage.fillInputs();

    }
    @After
    public void tearDown() {
        //driver.quit();
        System.out.println("Ha finalizado la ejecución del test.");
    }
}
