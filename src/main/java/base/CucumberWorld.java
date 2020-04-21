package base;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CucumberWorld {

    public static WebDriver driver;
    public static final String USERNAME = "ross217";
    public static final String AUTOMATE_KEY = "";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setupWorld() throws MalformedURLException {
        ReadConfig config = new ReadConfig();
        String browser = config.loadConfig("browser").toLowerCase();

        if ("chrome".equals(browser)) {
            System.out.println("Loading chromedriver for Chrome");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ross\\Desktop\\Repos\\JavaCucumberTAF\\src\\main\\resources\\chromedriver.exe");
            this.driver = new ChromeDriver();

        } else if ("edge".equals(browser)) {
            System.out.println("Loading the msedgedriver for Microsoft Edge");
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Ross\\Desktop\\Repos\\JavaCucumberTAF\\src\\main\\resources\\msedgedriver.exe");
            this.driver = new EdgeDriver();
        } else if ("remote".equals(browser)) {
            System.out.println("Loading the remote Webdriver for Selenium grid");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "81.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("resolution", "1024x768");
            caps.setCapability("name", "Bstack- Java Framework for Ross");
            caps.setCapability("build", "Test build for Ross");
            caps.setCapability("project", "Java Cucumber Framework");
            this.driver = new RemoteWebDriver(new URL(URL), caps);

        } else throw new RuntimeException("The property browser is null, Please state a browser to test with in the properties file");

    }

    public void setupConfig() {
        ReadConfig config = new ReadConfig();
        String browser = config.loadConfig("browser");
//
    }

    public void teardownWorld() {
        if (driver != null) {
            driver.quit();
        }
    }

}
