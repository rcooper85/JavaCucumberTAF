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

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CucumberWorld {

    Date date = new Date();

    //ReadConfig config = new ReadConfig();
    protected WebDriver driver;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static final String USERNAME = System.getProperty("username");
    private final String AUTOMATE_KEY = System.getProperty("seleniumgridkey");
    private final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private final String BUILD_DATE = sdf.format(date);

    public CucumberWorld() throws FileNotFoundException {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setupWorld() throws MalformedURLException {

       String pombrowser = System.getProperty("browser");
       //LocalDate date = LocalDate.now();

        // IF statement to determine which browser to instantiate
        if ("chrome".equals(pombrowser)) {
            System.out.println("Loading chromedriver for Chrome " + BUILD_DATE);
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ross\\Desktop\\Repos\\JavaCucumberTAF\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        } else if ("edge".equals(pombrowser)) {
            System.out.println("Loading the msedgedriver for Microsoft Edge");
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Ross\\Desktop\\Repos\\JavaCucumberTAF\\src\\main\\resources\\msedgedriver.exe");
            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else if ("remote".equals(pombrowser)) {
            System.out.println("Tests running in the cloud on BrowserStack");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "81.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("resolution", "1024x768");
            caps.setCapability("name", "Bstack- Java Framework for Ross");
            caps.setCapability("build", "Test build for Ross - " + BUILD_DATE);
            caps.setCapability("project", "Java Cucumber Framework");
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        } else throw new RuntimeException("Set the browser property to be chrome, edge or remote in the config.properties file.");

    }

    public void teardownWorld() {
        if (driver != null) {
            driver.quit();
        }
    }

}
