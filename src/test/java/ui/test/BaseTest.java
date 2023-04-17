package ui.test;

import org.testng.annotations.AfterMethod;
import ui.driver.WebDriverSingleton;

public class BaseTest {
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
