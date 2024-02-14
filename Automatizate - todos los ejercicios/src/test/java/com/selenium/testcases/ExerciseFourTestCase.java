package com.selenium.testcases;

import com.selenium.pageobject.ExerciseFourPage;
import com.selenium.pageobject.Hooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/*  Ejercicio 4:
    Navegar a https://demoqa.com/automation-practice-form
    Rellenar el formulario usando el id de los campos
                                                        */
public class ExerciseFourTestCase {
    String url = "https://demoqa.com/automation-practice-form";
    protected WebDriver driver = Hooks.getDriver(url);
    ExerciseFourPage ExerciseFourPage;
    @Before
    public void setUp() throws Exception {

        System.out.println("Se está ejecutando el test del ejercicio 4 " );
        ExerciseFourPage = new ExerciseFourPage(driver);

    }
    @Test
    public void TestExerciseFour() throws Exception {

        /* Utilizo los métodos definidos en el pageObject del ejercicio 4 */
        ExerciseFourPage.acceptCookies();
        ExerciseFourPage.fillInputs();

    }
    @After
    public void tearDown() {
        //driver.quit();
        System.out.println("Ha finalizado la ejecución del test.");
    }
}
