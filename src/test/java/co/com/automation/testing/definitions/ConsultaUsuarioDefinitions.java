package co.com.automation.testing.definitions;

import co.com.automation.testing.questions.ValidarUsuarioConsultado;
import co.com.automation.testing.questions.ValidarUsuarioCreado;
import co.com.automation.testing.tasks.ConsultarUsuario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaUsuarioDefinitions {

    @When("consulta al usuario con username {string}")
    public void consultarUsuario(String username) {
        theActorInTheSpotlight().attemptsTo(
                ConsultarUsuario.byUsername(username)
        );
    }

    @Then("debería ver el usuario con nombre {string}")
    public void verificarInformacionUsuario(String nombreEsperado) {
        theActorInTheSpotlight().should(seeThat(ValidarUsuarioConsultado.validacionUsuarioConsultado()));
    }
}
