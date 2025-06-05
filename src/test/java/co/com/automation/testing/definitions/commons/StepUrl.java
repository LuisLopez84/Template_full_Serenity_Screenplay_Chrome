package co.com.automation.testing.definitions.commons;


import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

public class StepUrl {
    private static final String PAGE_URL = "pages.url";

    @Given("{string} abre la página web")
    public void abreLaPáginaWeb(String actor) {
        OnStage.theActorCalled(actor);
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.browserOn().thePageNamed(PAGE_URL));
    }
}

/*
📄 Documentación Clase: StepUrl

📦 Paquete:

co.com.automation.testing.definitions.commons


---

🧠 Descripción General:

Esta clase contiene los pasos comunes de Cucumber asociados a la acción de abrir la página web especificada en el archivo de configuración de Serenity. Se encarga
de inicializar al actor con un nombre determinado y dirigirlo a la URL base configurada para la prueba.


---

🎯 Propósito:

Definir el paso de apertura de la aplicación web en el archivo .feature.

Registrar al actor que interactuará con la aplicación.

Abrir el navegador en la URL definida mediante la clave pages.url.



---

🔍 Análisis del método:

✅ openApplication(String actor)

@Given("{string} open Web Page")
public void openApplication(String actor)

Propósito: Implementa el step de Gherkin que abre la aplicación en el navegador para el actor proporcionado.

Qué hace:

Crea un nuevo actor con el nombre recibido (por ejemplo, "User").

Lanza el navegador y abre la página web mapeada por la clave "pages.url" en el archivo serenity.conf.


Clave de configuración utilizada: pages.url, que se define típicamente así:

pages {
url = "https://opensource-demo.orangehrmlive.com/"
}

Relación con Cucumber: Corresponde al step:

Given "User" open Web Page

en los archivos .feature.



---

🌐 Clases y Componentes Relacionados:

🔹 Open.browserOn() – Acción de Serenity para abrir una página en el navegador.

🔹 OnStage.theActorCalled(...) – Registra al actor para que participe en el escenario.

🔹 OnStage.theActorInTheSpotlight() – Retorna al actor activo para asignarle habilidades o tareas.

🔹 serenity.conf – Archivo de configuración donde se define pages.url.



---

🧩 Ventajas:

Centraliza la apertura de la página web en una sola clase.

Utiliza el nombre del actor dinámicamente, lo que permite ejecutar múltiples escenarios con distintos nombres.

Integra perfectamente el patrón Screenplay con Gherkin y Serenity.



---

📌 Ejemplo de uso en feature:

Given "User" open Web Page

El cual está directamente vinculado a esta clase.
 */
