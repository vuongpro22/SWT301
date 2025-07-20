package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.time.Duration;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By userEmail = By.id("userEmail");
    private By genderMale = By.xpath("//label[text()='Male']");
    private By userNumber = By.id("userNumber");
    private By dateOfBirth = By.id("dateOfBirthInput");

    private By subjectInput = By.id("subjectsInput");
    private By hobbyMusic = By.xpath("//label[text()='Music']");
    private By uploadPicture = By.id("uploadPicture");

    private By currentAddress = By.id("currentAddress");

    private By stateDropdown = By.id("state");
    private By cityDropdown = By.id("city");

    private By stateInput = By.xpath("//div[contains(@id,'react-select-3-input')]");
    private By cityInput = By.xpath("//div[contains(@id,'react-select-4-input')]");

    private By submitButton = By.id("submit");
    private By confirmationPopup = By.id("example-modal-sizes-title-lg");

    public void navigate() {
        navigateTo("https://demoqa.com/automation-practice-form");
    }

    public void fillBasicInfo(String fname, String lname, String email, String phone) {
        type(firstName, fname);
        type(lastName, lname);
        type(userEmail, email);
        click(genderMale);
        type(userNumber, phone);
    }

    public void setDateOfBirth(String dateStr) {
        click(dateOfBirth);
        WebElement input = driver.findElement(dateOfBirth);
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(dateStr);
        input.sendKeys(Keys.ENTER);
    }

    public void selectSubject(String subject) {
        WebElement input = waitForVisibility(subjectInput);
        input.sendKeys(subject);
        input.sendKeys(Keys.ENTER);
    }

    public void selectHobbyMusic() {
        click(hobbyMusic);
    }

    public void uploadPicture(String filePath) {
        WebElement upload = driver.findElement(uploadPicture);
        upload.sendKeys(new File(filePath).getAbsolutePath());
    }

    public void fillAddress(String address) {
        type(currentAddress, address);
    }

    public void selectStateAndCity(String state, String city) {
        // Scroll to dropdown
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(stateDropdown));

        click(stateDropdown);
        WebElement stateInputField = wait.until(ExpectedConditions.elementToBeClickable(stateInput));
        stateInputField.sendKeys(state);
        stateInputField.sendKeys(Keys.ENTER);

        click(cityDropdown);
        WebElement cityInputField = wait.until(ExpectedConditions.elementToBeClickable(cityInput));
        cityInputField.sendKeys(city);
        cityInputField.sendKeys(Keys.ENTER);
    }

    public void submitForm() {
        jsClick(submitButton);
    }

    public boolean isConfirmationPopupVisible() {
        return isElementVisible(confirmationPopup);
    }

    private void jsClick(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(locator));
    }
    public void typeFirstName(String fname) {
        type(firstName, fname);
    }

    public void typeLastName(String lname) {
        type(lastName, lname);
    }

    public void typeEmail(String email) {
        type(userEmail, email);
    }

    public void typePhone(String phone) {
        type(userNumber, phone);
    }

}
