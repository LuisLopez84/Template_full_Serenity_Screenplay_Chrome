package co.com.automation.testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarEmpleado implements Task {


    private final String letraInicialNombre;

    public SeleccionarEmpleado(String letraInicialNombre) {

        this.letraInicialNombre = letraInicialNombre;
    }

    public static SeleccionarEmpleado conTexto(String letraInicialNombre) {
        return new SeleccionarEmpleado(letraInicialNombre);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        By campoEmployee = By.xpath("//input[contains(@placeholder,'Type for hints')]");

        actor.attemptsTo(
                Click.on(campoEmployee), // Asegura que se active el campo
                Enter.theValue(letraInicialNombre).into(campoEmployee),
                WaitUntil.the(campoEmployee, isVisible()).forNoMoreThan(25).seconds(),

                // En lugar de hacer clic, simula que baja una vez y da ENTER
                SendKeys.of(Keys.ARROW_DOWN).into(campoEmployee),
                SendKeys.of(Keys.ARROW_DOWN).into(campoEmployee),
                SendKeys.of(Keys.ARROW_DOWN).into(campoEmployee),
                SendKeys.of(Keys.ARROW_DOWN).into(campoEmployee),
                SendKeys.of(Keys.ENTER).into(campoEmployee)
        );
    }
}
