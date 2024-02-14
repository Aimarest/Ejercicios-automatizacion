package com.selenium.testcases;

/*      Navegar a https://demoqa.com/automation-practice-form
        Rellenar el formulario usando xpath para localizar el label de los campos y luego rellenarlos
        Confirmar los valores y en el modal comprobar que se muestran correctamente
*/

import com.selenium.pageobject.ExerciseElevenPage;
import com.selenium.pageobject.Hooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ExerciseElevenTestCase {
    String url = "https://demoqa.com/automation-practice-form";
    protected WebDriver driver = Hooks.getDriver(url);
    ExerciseElevenPage ExerciseElevenPage;

    @Before
    public void setUp() throws Exception {

        System.out.println("Se está ejecutando el test del ejercicio 11" );
        ExerciseElevenPage = new ExerciseElevenPage(driver);
    }
    @Test
    public void TestExerciseEleven() throws Exception {

        /* Utilizo los métodos definidos en el pageObject del ejercicio 11 */

        ExerciseElevenPage.acceptCookies();
        ExerciseElevenPage.fillInputs();
        ExerciseElevenPage.validateForm();

    }
    @After
    public void tearDown() {
        //driver.quit();
        System.out.println("Ha finalizado la ejecución del test.");
    }
}
