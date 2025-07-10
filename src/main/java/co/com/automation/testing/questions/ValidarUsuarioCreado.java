package co.com.automation.testing.questions;

import co.com.automation.testing.ui.CrearUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarUsuarioCreado implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CrearUsuarioPage.SUCCESS_MESSAGE, isVisible()).forNoMoreThan(5).seconds(),
                Ensure.that(CrearUsuarioPage.SUCCESS_MESSAGE).isDisplayed(),
                Ensure.that(CrearUsuarioPage.SUCCESS_MESSAGE).text().contains("Successfully Saved")
        );
        return true;
    }

    public static ValidarUsuarioCreado usuarioCreadoExitoso () {
        return new ValidarUsuarioCreado();
    }
}