package ui.test;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.model.UserCreator;
import ui.page.AuthorizedUserPage;
import ui.page.LoginPage;
import ui.step.LoginPageStep;

public class LoginPageTest extends BaseTest {
    @BeforeMethod
    public void openPageAndCloseCookieAndClickOnLoginButton() {
        LoginPageStep loginPageStep = new LoginPageStep();
        loginPageStep.openPageCloseCookieAndClickLoginButton();
    }

    @Test
    @Description("Test Login form with empty credentials")
    public void testLoginWithEmptyEmailAndPassword() {
        LoginPageStep loginPageStep = new LoginPageStep();
        LoginPage loginPage = new LoginPage();
        loginPageStep.loginInWithEmptyEmailAndEmptyPassword(UserCreator.createRandomUser());

        Assert.assertEquals(loginPage.getUserEmailErrorMessage(), "Please enter your Spotify username or email address.");
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Please enter your password.");
    }

    @Test
    @Description("Test Login form with incorrect credentials")
    public void testLoginWithInvalidEmailAndPassword() {
        LoginPage loginPage = new LoginPage();
        LoginPageStep loginPageStep = new LoginPageStep();
        loginPageStep.loginIn(UserCreator.createRandomUser());

        Assert.assertEquals(loginPage.getUsernameAndPasswordErrorMessage(), "Incorrect username or password.");
    }

    @Test
    @Description("Test Login form with correct credentials")
    public void testLoginInWithValidUser() {
        LoginPageStep loginPageStep = new LoginPageStep();
        AuthorizedUserPage authorizedUserPage = new AuthorizedUserPage();
        loginPageStep.loginIn(UserCreator.createCorrectUser());

        Assert.assertEquals(authorizedUserPage.getTextFromLabelUserName(), "Selena");
    }
}
