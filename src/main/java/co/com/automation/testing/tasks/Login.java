package co.com.automation.testing.tasks;

import co.com.automation.testing.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.username).into(LoginPage.USERNAME),
                Enter.theValue(this.password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.SUBMIT_BUTTON)
        );
    }

    public static Login conCredenciales(String username, String password) {
        return instrumented(Login.class, username, password);
    }
}

/*
📄 Documentación Clase: Login

📦 Paquete:

co.com.automation.testing.tasks


---

🧠 Descripción General:

La clase Login es una implementación de una tarea (Task) del patrón Screenplay de Serenity BDD. Representa el proceso de inicio de sesión en la
aplicación, ingresando un nombre de usuario y una contraseña, y haciendo clic en el botón de envío.

Está diseñada para ser utilizada por un actor como parte de un flujo de pruebas automatizadas en el que se necesita validar el acceso al sistema.


---

🔧 Implementación:

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.username).into(LoginPage.USERNAME),
                Enter.theValue(this.password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.SUBMIT_BUTTON)
        );
    }

    public static Login withCredentials(String username, String password) {
        return instrumented(Login.class, username, password);
    }
}


---

🧱 Componentes principales:

Elemento Descripción

username, password Campos privados que almacenan las credenciales que serán utilizadas por el actor.
performAs Método principal que define la secuencia de acciones del actor: ingresar usuario, ingresar contraseña y hacer clic en el botón.
withCredentials Método de factoría que utiliza instrumented para que Serenity cree correctamente la instancia del task con inyección de parámetros.



---

🔄 Flujo de acciones realizado por esta tarea:

1. Ingresar el nombre de usuario en el campo correspondiente.


2. Ingresar la contraseña en el campo correspondiente.


3. Hacer clic en el botón de login para enviar el formulario.




---

✅ Ejemplo de uso en un paso (StepDefinition):

@When("login with credentials {string} and {string}")
public void loginWithCredentials(String username, String password) {
    OnStage.withCurrentActor(Login.withCredentials(username, password));
}


---

🎯 Beneficios:

Reutilizable: Esta tarea se puede reutilizar en múltiples escenarios de prueba donde se necesite iniciar sesión.

Legible: Usa una sintaxis fluida y fácil de entender, ideal para equipos que siguen BDD.

Mantenible: Si cambia la lógica de inicio de sesión, solo necesitas actualizar esta clase.



---

🔐 Buenas prácticas:

Asegúrate de tener los Target bien definidos en LoginPage para evitar flakiness.

Puedes extender esta clase para login con errores o campos vacíos, si necesitas variantes.
 */

