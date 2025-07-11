package co.com.automation.testing.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CrearUsuarioPage {

    public static final Target ADMIN_MENU = Target.the("Admin menu")
            .locatedBy("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
    public static final Target ADD_USER_BUTTON = Target.the("Add button")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    public static final Target USER_ROLE = Target.the("User Role")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i");
    public static final Target USER_ROLE_ADMIN = Target.the("Seleccionar Role Admin")
            .locatedBy("//div[@role='listbox']");
    public static final Target EMPLOYEE_NAME_INPUT = Target.the("Employee Name")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    public static final Target CLIC_STATUS = Target.the("Clic en Status")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i");
    public static final Target SELECCIONAR_STATUS = Target.the("Seleccion Status")
            .locatedBy("//div[@role='listbox']");
    public static final Target USERNAME_INPUT = Target.the("Username")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    public static final Target INGRESAR_PASSWORD = Target.the("Ingresar password")
            .locatedBy("//label[text()='Password']/following::input[1]");
    public static final Target CONFIRMAR_PASSWORD = Target.the("Confirmar Password")
            .locatedBy("//label[text()='Confirm Password']/following::input[1]");
    public static final Target SAVE_BUTTON = Target.the("Save")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    public static final Target SUCCESS_MESSAGE = Target.the("Success message")
            .locatedBy("//div[contains(@class,'oxd-toast') and contains(., 'Successfully Saved')]");
}