package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberWorld {

    public static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setupWorld() {
        this.driver = new ChromeDriver();
    }

    public void teardownWorld() {
        if (driver != null) {
            driver.quit();
        }
    }

}
