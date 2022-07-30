package utilsweb;

import org.openqa.selenium.By;

public interface Locators {
    String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    By lLoginUsername = By.id("txtUsername");
    By lLoginPassword = By.id("txtPassword");
    By lLoginSubmitButton = By.id("btnLogin");
    By lWelcome = By.id("welcome");
}
