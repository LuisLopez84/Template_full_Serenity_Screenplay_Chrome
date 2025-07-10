package co.com.automation.testing.questions;

import co.com.automation.testing.ui.ConsultarUsuarioPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarUsuarioConsultado {

    public static Question<String> name() {
        return actor -> Text.of(ConsultarUsuarioPage.EMPLOYEE_NAME_RESULT).answeredBy(actor);
    }
}
