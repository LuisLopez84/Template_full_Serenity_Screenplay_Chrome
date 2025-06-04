package co.com.automation.testing.utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.configuration.SystemPropertiesConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public final class EnvironmentProperties {

    private static final SystemPropertiesConfiguration CONFIGURATION = new SystemPropertiesConfiguration(SystemEnvironmentVariables.createEnvironmentVariables());
    private static final EnvironmentVariables ENV_VARIABLES = CONFIGURATION.getEnvironmentVariables();

    private EnvironmentProperties() {
    }

    public static String getProperty(String nameProperty) {
        return EnvironmentSpecificConfiguration.from(ENV_VARIABLES).getProperty(nameProperty);
    }

    public static String getProperties() {

        return EnvironmentProperties.getProperties();
    }
}


/*
📄 Documentación Clase: EnvironmentProperties

📦 Paquete:

co.com.automation.testing.utils


---

🧠 Descripción General:

Esta clase utilitaria proporciona métodos para acceder a propiedades definidas en el entorno de ejecución de Serenity, como las que están configuradas en
serenity.conf, en system environment variables, o proporcionadas por línea de comandos con -D.


---

🎯 Propósito:

Facilitar el acceso centralizado a las propiedades de configuración del entorno.

Abstraer la lógica de carga y lectura de propiedades desde serenity.conf.

Ser usada por otras clases para adaptar comportamientos dinámicamente, como en pruebas para BrowserStack u otros entornos.



---

🔍 Análisis de Componentes:

🔹 Atributos:

private static final SystemPropertiesConfiguration CONFIGURATION =
    new SystemPropertiesConfiguration(SystemEnvironmentVariables.createEnvironmentVariables());
private static final EnvironmentVariables ENV_VARIABLES = CONFIGURATION.getEnvironmentVariables();

CONFIGURATION: Carga la configuración del sistema y del archivo serenity.conf.

ENV_VARIABLES: Contiene todas las variables del entorno disponibles para Serenity.



---

🔹 Constructor privado:

private EnvironmentProperties() { }

Evita que la clase sea instanciada, ya que todos sus métodos son estáticos (patrón utility class).



---

✅ Método: getProperty(String nameProperty)

public static String getProperty(String nameProperty) {
    return EnvironmentSpecificConfiguration.from(ENV_VARIABLES).getProperty(nameProperty);
}

Descripción: Retorna el valor de una propiedad específica del archivo serenity.conf o de variables de entorno del sistema.

Ejemplo de uso:

String url = EnvironmentProperties.getProperty("pages.url");



---

⚠️ Método con error: getProperties()

public static String getProperties() {
    return EnvironmentProperties.getProperties();
}

❌ Problema: El método se llama recursivamente a sí mismo sin condición de salida, lo que produce un StackOverflowError si se llama.

✔️ Solución sugerida: Si la intención es retornar todas las propiedades como String, deberías hacer algo como:

public static String getProperties() {
    return ENV_VARIABLES.toString();
}



---

🌐 Clases Relacionadas:

serenity.conf: Archivo de configuración base.

SystemEnvironmentVariables: Clase de Serenity que obtiene todas las variables de entorno.

EnvironmentSpecificConfiguration: Permite leer propiedades específicas desde Serenity.

Usada en clases como Hooks.java para obtener propiedades como environment.



---

📌 Ejemplo de uso:

if (EnvironmentProperties.getProperty("environment").startsWith("BS")) {
    // Ejecutar lógica específica para BrowserStack
}


---

✅ Beneficios:

Encapsula y centraliza la lógica de configuración.

Facilita el uso de entornos dinámicos (dev, QA, prod, BrowserStack).

Reduce el acoplamiento entre clases al acceder a configuración.
 */
