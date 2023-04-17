package ui.page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizedUserPage extends BasePage{
    @FindBy(xpath = "//figure")
    private WebElement labelUserName;
    public String getTextFromLabelUserName() {
        return waitForVisibilityOfElement(labelUserName).getAttribute("title");
    }
}
