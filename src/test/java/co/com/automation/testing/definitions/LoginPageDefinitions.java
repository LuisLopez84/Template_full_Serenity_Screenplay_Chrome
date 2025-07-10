package co.com.automation.testing.definitions;

import co.com.automation.testing.questions.ErrorLogin;
import co.com.automation.testing.tasks.Login;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import co.com.automation.testing.questions.SuccessLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginPageDefinitions {

    @Then("Debe iniciar sesión correctamente")
    public void debeIniciarSesiónCorrectamente() {
        theActorInTheSpotlight().should(seeThat(SuccessLogin.loginExitoso()));
    }

    @Then("Debe ver el mensaje de error {string}")
    public void debeVerElMensajeDeError(String expectedErrorMessage) {
        theActorInTheSpotlight().should(seeThat(ErrorLogin.porCredencialesInvalidas(expectedErrorMessage)));

    }

    @Then("Debe ver el mensaje de error {string} debajo del nombre de usuario")
    public void debeVerElMensajeDeErrorDebajoDelNombreDeUsuario(String expectedErrorMessage) {
        theActorInTheSpotlight().should(seeThat(ErrorLogin.porNombreDeUsuarioFaltante(expectedErrorMessage)));
    }

    @When("Inicia sesión con las credenciales {string} y {string}")
    public void iniciaSesiónConLasCredencialesY(String username, String password) {
        OnStage.withCurrentActor(Login.conCredenciales(username, password));
    }

    @Then("Debe ver el mensaje de error {string} debajo de la contrasena")
    public void debeVerElMensajeDeErrorDebajoDeLaContrasena(String expectedErrorMessage) {
        theActorInTheSpotlight().should(seeThat(ErrorLogin.porFaltaDeContrasena(expectedErrorMessage)));
    }
}


/*
📄 Documentación Clase: LoginPageDefinitions

📦 Paquete :

co.com.automation.testing.definitions


---

🧠 Descripción General:

Esta clase define los pasos ejecutables en lenguaje Gherkin para el flujo de login. Cada método está vinculado a una línea en un archivo .feature y
                                                                                            ejecuta acciones o verificaciones dentro del modelo Screenplay de Serenity.


---

🎯 Propósito:

Traducir las frases escritas en Gherkin en acciones (@When) y verificaciones (@Then) que ejecuta un actor en el escenario de pruebas.

Delegar la ejecución de tareas y validaciones a las clases Tasks y Questions correspondientes, como Login, SuccessLogin y ErrorLogin.



---

🔍 Análisis de métodos:

✅ clickOnLoginButton()

@Then("should be able to login successfully")

Propósito: Verifica que el login haya sido exitoso.

Depende de: SuccessLogin.isSuccessful() (una Question que valida el éxito del login).

Relación con feature: Se ejecuta luego de intentar hacer login con credenciales válidas.



---

❌ unsuccessfulLogin(String expectedErrorMessage)

@Then("should be able to see error message {string}")

Propósito: Verifica si se muestra un mensaje de error específico al fallar el login.

Depende de: ErrorLogin.byInvalidCredentials(expectedErrorMessage).



---

⚠️ missingUsername(String expectedErrorMessage)

@Then("should be able to see error message {string} below username")

Propósito: Valida que se muestre el mensaje "Required" cuando el nombre de usuario está en blanco.

Depende de: ErrorLogin.byMissingUsername(...).



---

👤 userLoginWithCredentialsAnd(String username, String password)

@When("login with credentials {string} and {string}")

Propósito: Ejecuta la tarea de login con usuario y contraseña provistos desde el feature.

Depende de: Login.withCredentials(username, password) (una Task que realiza la interacción con el formulario de login).

Rol del actor: Se utiliza OnStage.withCurrentActor(...) para ejecutar la acción.



---

🔒 shouldBeAbleToSeeErrorMessageBelowPassword(String expectedErrorMessage)

@Then("should be able to see error message {string} below password")

Propósito: Verifica que se muestre un mensaje de error si la contraseña está en blanco.

Depende de: ErrorLogin.byMissingPassword(...).



---

📎 Clases Relacionadas / Dependencias:

🔹 Login (Task): ejecuta el ingreso de credenciales.

🔹 SuccessLogin (Question): valida login exitoso.

🔹 ErrorLogin (Question): valida errores en login según el tipo (credenciales inválidas, campos vacíos).

🔹 features/example/LoginPage.feature: contiene las frases en lenguaje natural que invocan estos métodos.

🔹 Hooks.java: inicializa los actores necesarios para que theActorInTheSpotlight() tenga contexto.



---

🧩 Observaciones:

Sigue el patrón de diseño Screenplay separando acciones (Tasks) de validaciones (Questions).

Cada método está alineado 1:1 con una frase Gherkin.

Muy útil para mantener trazabilidad clara entre prueba funcional y automatización.

Actualizacion 002
 */
