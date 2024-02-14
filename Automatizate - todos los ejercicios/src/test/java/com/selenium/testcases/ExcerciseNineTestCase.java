package com.selenium.testcases;

/*  Ejercicio 9:
    Navegar a http://uitestingplayground.com/shadowdom
    Hacer click en el botón con el engranaje e imprimir por consola el valor del campo de texto  */

import com.selenium.pageobject.ExerciseNinePage;
import com.selenium.pageobject.Hooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class ExcerciseNineTestCase {
    String url = "http://uitestingplayground.com/shadowdom";
    protected WebDriver driver = Hooks.getDriver(url);
    com.selenium.pageobject.ExerciseNinePage ExerciseNinePage;
    @Before
    public void setUp() throws Exception {

        System.out.println("Se está ejecutando el test del ejercicio 9 " );
        ExerciseNinePage = new ExerciseNinePage(driver);

    }
    @Test
    public void TestExerciseNine() throws Exception {

        /* Utilizo los métodos definidos en el pageObject del ejercicio 9 */

        ExerciseNinePage.clickFirstElement();
        ExerciseNinePage.showText();

    }
    @After
    public void tearDown() {
        //driver.quit();
        System.out.println("Ha finalizado la ejecución del test.");
    }
}
