package co.com.automation.testing.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver createDriver() {
        // Forzar uso de carpeta segura para caché
        WebDriverManager.chromedriver()
                .cachePath(System.getProperty("user.home") + "/.wdm-cache")
                .setup();
        return new ChromeDriver();
    }
}

/*
📄 Documentación Clase: DriverFactory

📦 Paquete:

co.com.automation.testing.utils


---

🧠 Descripción General:

Clase utilitaria responsable de configurar y retornar una instancia del navegador Chrome usando WebDriverManager.
Esta clase encapsula la lógica de inicialización del WebDriver y asegura una configuración limpia y centralizada para los tests.


---

🎯 Propósito:

Crear una instancia de WebDriver para ser utilizada por los actores de Screenplay.

Asegurar que el controlador de Chrome (chromedriver) esté disponible automáticamente sin necesidad de manejarlo manualmente.

Establecer un directorio de caché seguro para la descarga del driver, ideal para entornos controlados o sin privilegios elevados.



---

🧱 Implementación:

🔧 Método público:

public static WebDriver createDriver() {
    WebDriverManager.chromedriver()
        .cachePath(System.getProperty("user.home") + "/.wdm-cache")
        .setup();
    return new ChromeDriver();
}


---

🔍 Detalles clave:

Elemento Descripción

WebDriverManager.chromedriver() Automatiza la descarga del ejecutable de ChromeDriver.
.cachePath(...) Define un directorio personalizado de caché (~/.wdm-cache), útil para evitar errores en entornos con restricciones de escritura.
.setup() Descarga y configura el driver si no está presente.
return new ChromeDriver() Crea y retorna una nueva instancia del navegador Chrome.



---

🚀 ¿Dónde se utiliza?

En la clase Hooks.java, dentro del método setUp():

WebDriver driver = DriverFactory.createDriver();

Esta instancia luego se asigna al actor principal con:

OnStage.theActorCalled("Usuario").can(BrowseTheWeb.with(driver));



---

✅ Beneficios:

Automatización: Evita problemas comunes como incompatibilidad entre Chrome y su driver.

Portabilidad: Funciona sin necesidad de agregar manualmente chromedriver.exe al proyecto o al PATH.

Mantenibilidad: Permite centralizar la lógica de creación del navegador, facilitando su modificación futura (por ejemplo, si se desea usar Firefox o
un navegador sin interfaz gráfica como ChromeHeadless).



---

📌 Posible Mejora:

Agregar soporte para diferentes navegadores o modos (por ejemplo: headless, grid, remoto, etc.) usando un parámetro o propiedad de entorno:

public static WebDriver createDriver() {
    String browser = System.getProperty("browser", "chrome");

    if (browser.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().cachePath(System.getProperty("user.home") + "/.wdm-cache").setup();
        return new ChromeDriver();
    }
    // Aquí se podrían agregar FirefoxDriver, EdgeDriver, etc.
    throw new UnsupportedOperationException("Browser no soportado: " + browser);
}
 */




