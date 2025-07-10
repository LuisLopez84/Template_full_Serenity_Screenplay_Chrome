package co.com.automation.testing.definitions.hooks;

import co.com.automation.testing.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static co.com.automation.testing.utils.EnvironmentProperties.getProperty;
import static net.serenitybdd.core.Serenity.getDriver;

public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = DriverFactory.createDriver();
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario").can(BrowseTheWeb.with(driver));
        System.setProperty("java.io.tmpdir", System.getProperty("user.home") + "/.tmp-serenity"); //mvn clean install -U

    }

    @Before
    public void ConfigurarElEscenarioWeb(Scenario scenario) {
        Serenity.setSessionVariable("ScenarioName").to(scenario.getName());
    }

    @After
    public void VerificarCasoDePrueba(Scenario scenario) {
        if (getProperty("environment").startsWith("BS")) {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            if (scenario.isFailed()) {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\","
                        + " \"arguments\": {\"status\": \"failed\", \"reason\": \"TestFailed\"}}");
            } else {
                jse.executeScript(
                        "browserstack_executor: {\"action\": \"setSessionStatus\","
                                + " \"arguments\": {\"status\": \"passed\", \"reason\": \"TestPassed\"}}");
            }
        }
    }
}

/*
📄 Documentación Clase: Hooks

📦 Paquete:

co.com.automation.testing.definitions.hooks


---

🧠 Descripción General:

La clase Hooks configura y administra el ciclo de vida de cada escenario de prueba. Define acciones que deben ejecutarse antes y después de cada Scenario, tales
como la inicialización del navegador, creación del actor principal y el reporte de estado a BrowserStack si aplica.


---

🎯 Propósito:

Preparar el entorno antes de ejecutar cada escenario (@Before).

Registrar el nombre del escenario para su posterior uso en reportes o evidencias.

Reportar el resultado del escenario a BrowserStack, en caso de estar ejecutando allí.



---

🔍 Análisis de métodos:

🧱 setUp()

@Before
public void setUp()

Propósito: Inicializa el navegador y configura el actor que ejecutará las acciones.

Qué hace:

Crea una instancia de WebDriver usando DriverFactory.

Configura una "escena" (OnlineCast) para el patrón Screenplay.

Crea un actor llamado "Usuario" con la habilidad de navegar en la web (BrowseTheWeb.with(driver)).


Dependencias: DriverFactory.



---

🏷 setTheStageWeb(Scenario scenario)

@Before
public void setTheStageWeb(Scenario scenario)

Propósito: Guarda el nombre del escenario actual como una variable de sesión en Serenity.

Para qué sirve: Facilita la generación de reportes, evidencias, logs o trazabilidad basada en el nombre del escenario.



---

🔁 checkTestCase(Scenario scenario)

@After
public void checkTestCase(Scenario scenario)

Propósito: Informa a BrowserStack si el escenario pasó o falló, usando comandos especiales de JavascriptExecutor.

Qué hace:

Verifica si el entorno (environment) inicia con "BS".

Usa JavascriptExecutor para marcar el estado del test en BrowserStack como passed o failed según el resultado.


Dependencias: EnvironmentProperties.getProperty(...) y Serenity.getDriver().



---

🌐 Clases y Componentes Relacionados:

🔹 DriverFactory – Crea e inicializa el WebDriver según configuración.

🔹 Serenity.setSessionVariable() – Permite almacenar datos persistentes durante la ejecución del escenario.

🔹 OnlineCast y OnStage – Parte del modelo Screenplay para gestionar actores y habilidades.

🔹 BrowserStack – Plataforma externa donde se ejecutan las pruebas si se especifica un entorno remoto.



---

🧩 Beneficios:

Separa claramente la lógica de configuración del ciclo de vida de los escenarios.

Compatible tanto con ejecución local como remota (BrowserStack).

Modular y reutilizable en cualquier conjunto de pruebas Cucumber.

Reforzado por buenas prácticas de Screenplay.
 */