package co.com.automation.testing.questions;

import co.com.automation.testing.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

public class ErrorLogin implements Question<Boolean> {
    private final String message;
    private final Target element;

    public ErrorLogin(String message, Target element) {
        this.message = message;
        this.element = element;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(element).isDisplayed(),
                Ensure.that(element).text().contains(message)
        );
        return true;
    }

    public static ErrorLogin porCredencialesInvalidas(String message) {
        return new ErrorLogin(message, LoginPage.ERROR_MESSAGE);
    }

    public static ErrorLogin porNombreDeUsuarioFaltante(String message) {
        return new ErrorLogin(message, LoginPage.MISSING_USERNAME);
    }

    public static ErrorLogin porFaltaDeContrasena(String expectedErrorMessage) {
        return new ErrorLogin(expectedErrorMessage, LoginPage.MISSING_PASSWORD);
    }
}


/*
📄 Documentación Clase: ErrorLogin

📦 Paquete:

co.com.automation.testing.questions


---

🧠 Descripción General:

La clase ErrorLogin es una implementación del patrón Question<Boolean> de Serenity BDD + Screenplay. Su propósito es validar la aparición de mensajes
de error durante el proceso de inicio de sesión, permitiendo verificar diferentes tipos de fallos como credenciales inválidas o campos obligatorios vacíos.

Se usa en pasos Then para afirmar que el mensaje de error mostrado en la UI coincide con el texto esperado.


---

🔧 Implementación:

public class ErrorLogin implements Question<Boolean> {
    private final String message;
    private final Target element;

    public ErrorLogin(String message, Target element) {
        this.message = message;
        this.element = element;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
            Ensure.that(element).isDisplayed(),
            Ensure.that(element).text().contains(message)
        );
        return true;
    }

    public static ErrorLogin byInvalidCredentials(String message) {
        return new ErrorLogin(message, LoginPage.ERROR_MESSAGE);
    }

    public static ErrorLogin byMissingUsername(String message) {
        return new ErrorLogin(message, LoginPage.MISSING_USERNAME);
    }

    public static ErrorLogin byMissingPassword(String message) {
        return new ErrorLogin(message, LoginPage.MISSING_PASSWORD);
    }
}


---

🧱 Componentes Clave:

Componente Descripción

message Texto esperado en el mensaje de error.
element Elemento de la UI (Target) que contiene el mensaje de error.
Ensure.that(element).isDisplayed() Verifica que el mensaje de error esté visible en la interfaz.
Ensure.that(element).text().contains(message) Confirma que el texto del mensaje de error contenga el valor esperado.
Métodos estáticos como byInvalidCredentials(...) Simplifican la creación de preguntas específicas para distintos errores.



---

🧪 Ejemplo de uso en StepDefinition:

@Then("should see the error message {string} for invalid credentials")
public void shouldSeeErrorMessage(String expectedMessage) {
    theActorInTheSpotlight().should(
        seeThat(ErrorLogin.byInvalidCredentials(expectedMessage))
    );
}


---

✅ Casos que cubre:

❌ Usuario o contraseña incorrectos → LoginPage.ERROR_MESSAGE

❌ Usuario faltante → LoginPage.MISSING_USERNAME

❌ Contraseña faltante → LoginPage.MISSING_PASSWORD



---

🎯 Ventajas:

Reutilizable: Soporta múltiples tipos de errores con una sola clase.

Flexible: Permite validar mensajes específicos para distintos campos.

Legible y mantenible: Usa Ensure para validaciones expresivas, fáciles de rastrear en reportes Serenity.

Modular: Sigue el principio de responsabilidad única (SRP) para verificar errores.
 */





