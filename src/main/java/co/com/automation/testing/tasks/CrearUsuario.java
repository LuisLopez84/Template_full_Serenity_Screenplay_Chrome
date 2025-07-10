package co.com.automation.testing.tasks;

import co.com.automation.testing.ui.CrearUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

public class CrearUsuario implements Task {

//    private final String nombre;
    private final String username;
    private final String password;
    private static String confirPass = "";

    public CrearUsuario(String username, String password, String confirPass) {
//        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.confirPass = confirPass;
    }

    public static CrearUsuario with(String username, String password, String confirPass) {
        return Tasks.instrumented(CrearUsuario.class, username, password, confirPass);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CrearUsuarioPage.ADMIN_MENU),
                Click.on(CrearUsuarioPage.ADD_USER_BUTTON),
                Click.on(CrearUsuarioPage.USER_ROLE),
                Click.on(CrearUsuarioPage.USER_ROLE_ADMIN),
                SeleccionarEmpleado.conTexto("K"),
    //            Enter.theValue(nombre).into(CrearUsuarioPage.EMPLOYEE_NAME_INPUT),
                Hit.the(Keys.ARROW_DOWN).into(CrearUsuarioPage.EMPLOYEE_NAME_INPUT),
                Hit.the(Keys.ENTER).into(CrearUsuarioPage.EMPLOYEE_NAME_INPUT),
                Click.on(CrearUsuarioPage.CLIC_STATUS),
                Click.on(CrearUsuarioPage.SELECCIONAR_STATUS),
                Enter.theValue(username).into(CrearUsuarioPage.USERNAME_INPUT),
                Enter.theValue(password).into(CrearUsuarioPage.INGRESAR_PASSWORD),
                Enter.theValue(confirPass).into(CrearUsuarioPage.CONFIRMAR_PASSWORD),
                Click.on(CrearUsuarioPage.SAVE_BUTTON)
        );
    }
}