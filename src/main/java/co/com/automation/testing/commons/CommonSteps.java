package co.com.automation.testing.commons;

import co.com.automation.testing.tasks.Login;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class CommonSteps {

    @When("Inicia sesión con las credenciales {string} y {string}")
    public void iniciaSesiónConLasCredencialesY(String username, String password) {
        OnStage.withCurrentActor(Login.conCredenciales(username, password));
    }
}