package co.com.automation.testing.definitions;

import co.com.automation.testing.questions.ValidarUsuarioCreado;
import co.com.automation.testing.tasks.CrearUsuario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearUsuarioDefinitions {


    @And("navega al modulo de administracion de usuarios")
    public void navegaAlModuloDeAdministracionDeUsuarios() {

    }

    @And("crea un nuevo usuario con username {string} y password {string} y confirPass {string}")
    public void crearUsuario(String username, String password, String confirPass) {
        theActorInTheSpotlight().attemptsTo(
                CrearUsuario.with(username, password, confirPass)
        );
    }

    @Then("debería ver el mensaje {string}")
    public void verificarMensajeCreacion(String usuarioCreadoExitoso) {
                theActorInTheSpotlight().should(seeThat(ValidarUsuarioCreado.usuarioCreadoExitoso()));
    }
}
