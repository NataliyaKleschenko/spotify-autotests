package ui.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.WebDriverSingleton;
import java.time.Duration;
public class BasePage {
    protected WebDriver driver;
    private static final String URL = "https://open.spotify.com/";
    private static final int WAIT_FOR_ELEMENT = 4;

    protected BasePage() {
        driver = WebDriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    public BasePage openPage() {
        driver.navigate().to(URL);
        return this;
    }
    protected WebElement waitForElementToBeClickable(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT)).until(ExpectedConditions.elementToBeClickable(webElement));
    }
    protected WebElement waitForVisibilityOfElement(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT)).until(ExpectedConditions.visibilityOf(webElement));
    }
}
