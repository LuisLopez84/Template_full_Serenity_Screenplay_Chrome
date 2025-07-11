package co.com.automation.testing.questions;

import co.com.automation.testing.ui.ConsultarUsuarioPage;
import co.com.automation.testing.ui.CrearUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarUsuarioConsultado implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(ConsultarUsuarioPage.SUCCESS_MESSAGE, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(ConsultarUsuarioPage.SUCCESS_MESSAGE).isDisplayed(),
                Ensure.that(ConsultarUsuarioPage.SUCCESS_MESSAGE).text().contains("LLOPEZ5")
        );
        return true;
    }

    public static ValidarUsuarioConsultado validacionUsuarioConsultado () {

        return new ValidarUsuarioConsultado();
    }
}
