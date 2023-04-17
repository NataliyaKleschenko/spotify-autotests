package ui.step;
import ui.model.User;
import ui.page.LoginPage;
public class LoginPageStep {
    public void openPageCloseCookieAndClickLoginButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.clickToCloseCookie()
                .clickToLoginIn();
    }
    public void loginIn(User user) {
        LoginPage loginPage = new LoginPage();
        loginPage.clickToLoginIn();
        loginPage.typeEmail(user.getUserName())
                .typePassword(user.getPassword())
                .clickOnSubmitButton();
    }
    public void loginInWithEmptyEmailAndEmptyPassword(User user) {
        LoginPage loginPage = new LoginPage();
        loginPage.clickToLoginIn();
        loginPage.typeEmail(user.getUserName())
                .clearInputEmail()
                .typePassword(user.getPassword())
                .clearInputPassword()
                .clickOnSubmitButton();
    }
}
