package com.selenium.testcases;

/*      Navegar a https://demoqa.com/automation-practice-form
        Rellenar el formulario usando el id de los campos
        Confirmar los valores y en el modal comprobar que se muestran correctamente
*/

import com.selenium.pageobject.ExerciseTenPage;
import com.selenium.pageobject.Hooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ExerciseTenTestCase {
    String url = "https://demoqa.com/automation-practice-form";
    protected WebDriver driver = Hooks.getDriver(url);
   ExerciseTenPage ExerciseTenPage;
    @Before
    public void setUp() throws Exception {

        System.out.println("Se está ejecutando el test del ejercicio 10" );
        ExerciseTenPage = new ExerciseTenPage(driver);
    }
    @Test
    public void TestExerciseTen() throws Exception {

        /* Utilizo los métodos definidos en el pageObject del ejercicio 10 */

        ExerciseTenPage.acceptCookies();
        ExerciseTenPage.fillInputs();
        ExerciseTenPage.validateForm();
    }
    @After
    public void tearDown() {
        //driver.quit();
        System.out.println("Ha finalizado la ejecución del test.");
    }
}
