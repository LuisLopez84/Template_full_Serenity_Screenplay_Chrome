package co.com.automation.testing.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
        features = "src/test/resources/features",
        glue = "co.com.automation.testing.definitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberTestSuiteTest {}




/*
📄 Documentación Clase: CucumberTestSuiteTest

📦 Paquete:

co.com.automation.testing.runner


---

        🧠 Descripción General:

Esta clase sirve como punto de entrada para ejecutar los escenarios BDD definidos en los archivos .feature mediante JUnit Platform y Cucumber. No contiene
lógica personalizada, pero utiliza anotaciones de JUnit 5 (junit-platform-suite) para orquestar la ejecución de pruebas.


        ---

        🎯 Propósito:

Permitir que el motor de pruebas Cucumber reconozca:

Qué motor utilizar (cucumber).

Dónde buscar los archivos .feature.

Dónde están ubicadas las definiciones de pasos (step definitions) y hooks.


Es una clase esencial para iniciar la ejecución desde el IDE o integraciones CI/CD como GitHub Actions o Jenkins.


        ---

        🔍 Análisis de Anotaciones:

@Suite
Marca la clase como una suite de pruebas de JUnit 5.

@IncludeEngines("cucumber")
Indica que se debe usar el motor de ejecución Cucumber, compatible con JUnit Platform.

@SelectClasspathResource("co.com.automation.testing")
Le dice a JUnit dónde buscar las clases Java con step definitions, tasks, questions, hooks, etc.

@SelectClasspathResource("/features")
Define la ubicación en el classpath donde se encuentran los archivos .feature (generalmente en src/test/resources/features).

@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "co.com.automation.testing")
Define la propiedad glue, que indica a Cucumber el paquete base donde están ubicadas las clases de step definitions, hooks y otras utilidades necesarias.



        ---

        📎 Clases relacionadas / dependencias:

Archivos .feature en el paquete features, típicamente bajo src/test/resources/features.

Step Definitions: como LoginPageDefinitions.java, bajo el paquete co.com.automation.testing.definitions.

        Hooks: como Hooks.java, bajo co.com.automation.testing.definitions.hooks.



---

        📌 Observaciones:

Esta clase no necesita lógica adicional ni método main(), ya que JUnit se encarga de ejecutarla como suite.

Si se ejecuta esta clase desde IntelliJ o con mvn test / mvn verify, se disparará toda la suite de pruebas BDD.
*/