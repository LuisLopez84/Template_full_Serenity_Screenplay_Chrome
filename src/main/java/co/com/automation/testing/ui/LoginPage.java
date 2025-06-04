package co.com.automation.testing.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class LoginPage {

    private LoginPage() { }

    public static final Target SUBMIT_BUTTON = Target.the("Boton login")
            .locatedBy("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    public static final Target ERROR_MESSAGE = Target.the("Mensaje de error")
            .locatedBy("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");
    public static final Target MISSING_USERNAME = Target.the("Mensaje de error por usuario faltante")
            .locatedBy("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span");
    public static final Target USERNAME = Target.the("Campo de usuario")
            .located(By.name("username"));
    public static final Target PASSWORD = Target.the("Campo de contraseña")
            .located(By.name("password"));
    public static final Target MISSING_PASSWORD = Target.the("Mensaje de error por contraseña faltante")
            .locatedBy("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span");
}

/*
📄 Documentación Clase: LoginPage

📦 Paquete:

co.com.automation.testing.ui


---

🧠 Descripción General:

Esta clase representa la interfaz de usuario de la pantalla de login y define los elementos web (Target) que serán utilizados por los actores durante la ejecución de
los escenarios de prueba. Sigue el patrón Page Object Model (POM) para mantener una separación clara entre la lógica de prueba y la estructura de la interfaz.


---

🧱 Implementación:

public class LoginPage {

    private LoginPage() { }

    public static final Target SUBMIT_BUTTON = ...
    public static final Target ERROR_MESSAGE = ...
    public static final Target MISSING_USERNAME = ...
    public static final Target USERNAME = ...
    public static final Target PASSWORD = ...
    public static final Target MISSING_PASSWORD = ...
}


---

🔍 Elementos definidos:

Campo Descripción

SUBMIT_BUTTON Representa el botón de login que el usuario presiona para autenticar.
ERROR_MESSAGE Captura el mensaje de error que aparece cuando las credenciales son incorrectas.
MISSING_USERNAME Elemento que muestra el mensaje de validación cuando el campo de usuario está vacío.
USERNAME Campo de entrada para el nombre de usuario. Se identifica por el atributo name="username".
PASSWORD Campo de entrada para la contraseña. Se identifica por el atributo name="password".
MISSING_PASSWORD Mensaje de error que aparece si el campo de contraseña está vacío.



---

💡 Notas Técnicas:

Los Target de Serenity describen elementos interactuables en la UI, permitiendo que los tasks y questions los utilicen de forma reutilizable.

Se usa By.name() para localizar los campos de usuario y contraseña, mientras que los mensajes y botones se localizan con expresiones XPath, lo cual es útil cuando
no hay atributos únicos disponibles.

El constructor privado (private LoginPage()) impide la creación de instancias de esta clase, ya que su propósito es estático y referencial.



---

🎯 Ejemplo de uso en una Task:

Enter.theValue("Admin").into(LoginPage.USERNAME);
Enter.theValue("admin123").into(LoginPage.PASSWORD);
Click.on(LoginPage.SUBMIT_BUTTON);


---

✅ Beneficios:

Mantenibilidad: Centraliza todos los elementos de la página en una sola clase, facilitando cambios futuros si la UI se modifica.

Legibilidad: Usa nombres descriptivos y claros para cada elemento, lo que mejora la comprensión de los scripts de prueba.

Reutilización: Los elementos pueden ser utilizados en múltiples escenarios y definiciones de pasos sin duplicar código.
 */




