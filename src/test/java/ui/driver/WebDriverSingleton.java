package ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverSingleton {
    private static WebDriver driver;
    private static ChromeOptions options;
    private static final long IMPLICITLY_WAIT = 10;

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        options = new ChromeOptions()
                .addArguments("--lang=en")
                .addArguments("--incognito")
                .addArguments("--headless")
                .addArguments("--remote-allow-origins=*");

        if (driver == null) {
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
