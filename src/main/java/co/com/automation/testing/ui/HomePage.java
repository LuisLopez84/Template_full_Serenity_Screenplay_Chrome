package co.com.automation.testing.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    private HomePage() { }

    public static final Target DASHBOARD_TEXT = Target.the("Mensaje de bienvenida")
            .locatedBy(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");

}

/*
📄 Documentación Clase: HomePage

📦 Paquete:

co.com.automation.testing.ui


---

🧠 Descripción General:

La clase HomePage representa la pantalla de inicio o dashboard principal de la aplicación después de un inicio de sesión exitoso. Define el elemento clave que confirma
que el usuario ha sido autenticado correctamente y ha accedido a la interfaz principal.

Esta clase sigue el patrón Page Object Model (POM) y permite una clara separación entre los objetos de la interfaz de usuario y la lógica de automatización.


---

🧱 Implementación:

public class HomePage {

    private HomePage() { }

    public static final Target DASHBOARD_TEXT = Target.the("Mensaje de bienvenida")
            .locatedBy(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");

}


---

🔍 Elementos definidos:

Campo Descripción

DASHBOARD_TEXT Representa el texto del encabezado o módulo del dashboard que usualmente se muestra al iniciar sesión correctamente. Este texto se utiliza
como indicador visual de que el login fue exitoso y el usuario ha llegado a la página principal. Se localiza mediante un selector CSS.



---

💡 Notas Técnicas:

La clase tiene un constructor privado, lo que impide su instanciación y refuerza su propósito como contenedor estático de elementos.

El Target está localizado por un selector CSS, lo cual suele ser más eficiente y robusto que usar XPath en este caso.

Es común usar este tipo de elemento como punto de validación en una Question que confirme el acceso exitoso al sistema.



---

🎯 Ejemplo de uso en una Question:

Text.of(HomePage.DASHBOARD_TEXT).asString()

O como validación:

theActorInTheSpotlight().should(seeThat(SuccessLogin.isSuccessful()));


---

✅ Beneficios:

Claridad: El nombre DASHBOARD_TEXT refleja claramente el propósito del elemento.

Centralización: Agrupar los elementos en una clase específica permite que los cambios de UI se manejen fácilmente sin tocar la lógica de los pasos o tareas.

Facilita las pruebas de regresión: Tener este tipo de elementos bien definidos ayuda a detectar fallas funcionales en la navegación después del login.
 */


