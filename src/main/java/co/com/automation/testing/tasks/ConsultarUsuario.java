package co.com.automation.testing.tasks;

import co.com.automation.testing.ui.ConsultarUsuarioPage;
import co.com.automation.testing.ui.CrearUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

public class ConsultarUsuario implements Task {

    private final String username;


    public ConsultarUsuario(String username) {

        this.username = username;
    }

    public static ConsultarUsuario byUsername(String username) {
        return Tasks.instrumented(ConsultarUsuario.class, username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ConsultarUsuarioPage.ADMIN_MENU),
                Enter.theValue(username).into(ConsultarUsuarioPage.SEARCH_USERNAME),
                Click.on(ConsultarUsuarioPage.USER_ROLE),
                Click.on(ConsultarUsuarioPage.USER_ROLE_ADMIN),

                SeleccionarEmpleado.conTexto("K"),
                Hit.the(Keys.ARROW_DOWN).into(ConsultarUsuarioPage.EMPLOYEE_NAME_INPUT),
                Hit.the(Keys.ENTER).into(ConsultarUsuarioPage.EMPLOYEE_NAME_INPUT),



        //        Enter.theValue(employye).into(ConsultarUsuarioPage.EMPLOYEE_NAME_RESULT),
                Click.on(ConsultarUsuarioPage.CLIC_STATUS),
                Click.on(ConsultarUsuarioPage.SELECCIONAR_STATUS),
                Click.on(ConsultarUsuarioPage.SEARCH_BUTTON)
        );
    }
}
