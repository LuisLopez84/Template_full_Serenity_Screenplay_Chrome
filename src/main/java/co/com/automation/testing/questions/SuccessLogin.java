package co.com.automation.testing.questions;

import co.com.automation.testing.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

public class SuccessLogin implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(HomePage.DASHBOARD_TEXT).isDisplayed(),
                Ensure.that(HomePage.DASHBOARD_TEXT).text().contains("Dashboard")
        );
        return true;
    }

    public static SuccessLogin loginExitoso() {
        return new SuccessLogin();
    }
}

/*
📄 Documentación Clase: SuccessLogin

📦 Paquete:

co.com.automation.testing.questions


---

🧠 Descripción General:

La clase SuccessLogin es una pregunta (Question) del patrón Screenplay de Serenity BDD que verifica si un inicio de sesión ha sido exitoso. La validación se realiza
asegurándose de que el texto "Dashboard" esté visible en la página de inicio.

Este tipo de Question<Boolean> se utiliza en los Then de los escenarios Gherkin para confirmar si la acción previa (como iniciar sesión) tuvo el resultado esperado.


---

🔧 Implementación:

public class SuccessLogin implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
            Ensure.that(HomePage.DASHBOARD_TEXT).isDisplayed(),
            Ensure.that(HomePage.DASHBOARD_TEXT).text().contains("Dashboard")
        );
        return true;
    }

    public static SuccessLogin isSuccessful() {
        return new SuccessLogin();
    }
}


---

🧱 Componentes principales:

Elemento Descripción

answeredBy Método que ejecuta las verificaciones necesarias para saber si el login fue exitoso. Devuelve true si ambas validaciones pasan.
Ensure.that(...).isDisplayed() Verifica que el elemento del dashboard esté visible en el DOM.
Ensure.that(...).text().contains("Dashboard") Verifica que el texto del elemento contenga la palabra "Dashboard".
isSuccessful() Método de fábrica estático que retorna una instancia de SuccessLogin para ser usada fácilmente en assertions.



---

✅ Ejemplo de uso en un StepDefinition:

@Then("should be able to login successfully")
public void clickOnLoginButton() {
    theActorInTheSpotlight().should(seeThat(SuccessLogin.isSuccessful()));
}


---

🎯 ¿Qué valida exactamente?

Que el elemento identificado por HomePage.DASHBOARD_TEXT esté presente y visible.

Que el texto de ese elemento contenga la palabra "Dashboard", lo cual es una indicación clara de que el login fue exitoso y que el usuario fue redirigido al home.



---

💡 Ventajas:

Explícito y seguro: Usa Ensure para hacer validaciones fuertes y legibles.

Reutilizable: Puede ser usado en distintos escenarios donde se necesite validar el acceso correcto al sistema.

Compatible con reporting de Serenity: Las tareas Ensure generan pasos claros en los reportes HTML.
 */








