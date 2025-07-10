package co.com.automation.testing.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class ConsultarUsuarioPage {

    public static final Target ADMIN_MENU = Target.the("Menu Admin")
            .locatedBy("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
    public static final Target SEARCH_USERNAME = Target.the("Campo Username")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    public static final Target USER_ROLE = Target.the("User Role")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");
    public static final Target EMPLOYEE_NAME_RESULT = Target.the("Employee Name")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input");
    public static final Target CLIC_STATUS = Target.the("Status")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i");
    public static final Target SELECCIONAR_STATUS = Target.the("Seleccion Status")
            .locatedBy("//div[@role='listbox']");
    public static final Target SEARCH_BUTTON = Target.the("Botón Buscar")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");

}