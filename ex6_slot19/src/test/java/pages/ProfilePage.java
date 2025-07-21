package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private By nameField = By.id("name");
    private By saveBtn = By.id("save");
    private By uploadAvatar = By.id("avatar");
    private By successAlert = By.id("profile-updated");

    public void navigate() {
        navigateTo("http://127.0.0.1:5500/ex6_slot19/index2.html");
    }

    public void updateName(String name) {
        type(nameField, name);
        click(saveBtn);
    }

    public void uploadAvatar(String filePath) {
        driver.findElement(uploadAvatar).sendKeys(filePath);
    }

    public boolean isProfileUpdated() {
        return waitForVisibility(successAlert).isDisplayed();
    }

    public void typeNameOnly(String name) {
        type(nameField, name);
    }
}
