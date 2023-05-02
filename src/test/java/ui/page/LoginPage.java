package ui.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//input[@data-testid='login-username']")
    private WebElement userEmailInput;
    @FindBy(id = "login-password")
    private WebElement userPasswordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@data-testid='username-error']")
    private WebElement usernameErrorMessage;
    @FindBy(xpath = "//div[@data-testid='password-error']")
    private WebElement passwordErrorMessage;
    @FindBy(xpath = "//span[contains(text(),'Incorrect username or password.')]")
    private WebElement usernameAndPasswordErrorMessage;
    @FindBy(xpath = "//button[@data-testid='login-button']")
    private WebElement loginInButton;

    @FindBy(xpath = "//*[contains(@class,'banner-close-button ot-close-icon')]")
    private WebElement cookieButton;
    public LoginPage clickToLoginIn() {
        waitForElementToBeClickable(loginInButton).click();
        return this;
    }
    public LoginPage clickToCloseCookie() {
        waitForElementToBeClickable(cookieButton).click();
        return this;
    }
    public LoginPage typeEmail(String userEmail) {
        waitForElementToBeClickable(userEmailInput).clear();
        userEmailInput.sendKeys(userEmail);
        return this;
    }
    public LoginPage typePassword(String password) {
        waitForElementToBeClickable(userPasswordInput).clear();
        userPasswordInput.sendKeys(password);
        return this;
    }
    public void clickOnSubmitButton() {
        waitForElementToBeClickable(loginButton);
        loginButton.click();
    }
    public LoginPage clearFilledField(WebElement webElement) {
        webElement.sendKeys(Keys.CONTROL + "A");
        webElement.sendKeys(Keys.DELETE);
        return this;
    }
    public LoginPage clearInputEmail() {
        clearFilledField(userEmailInput);
        return this;
    }
    public LoginPage clearInputPassword() {
        clearFilledField(userPasswordInput);
        return this;
    }
    public String getUserEmailErrorMessage() {
        return usernameErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    public String getUsernameAndPasswordErrorMessage() {
        return usernameAndPasswordErrorMessage.getText();
    }
}
