package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By username = By.id("username");
    private By email = By.id("email");
    private By password = By.id("password");
    private By registerBtn = By.id("register");
    private By successMsg = By.id("success-message");

    public void navigate() {
        navigateTo("http://127.0.0.1:5500/ex6_slot19/index.html");
    }

    public void register(String user, String mail, String pass) {
        type(username, user);
        type(email, mail);
        type(password, pass);
        click(registerBtn);
    }

    public boolean isSuccessDisplayed() {
        return waitForVisibility(successMsg).isDisplayed();
    }
}
