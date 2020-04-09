package steps;

import base.CucumberWorld;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Hooks {

    CucumberWorld world;

    public Hooks(CucumberWorld world) {
        this.world = world;
    }

    @Before
    public void initialiseTests() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ross\\Desktop\\Repos\\JavaCucumberTAF\\src\\main\\resources\\chromedriver.exe");
        world.setupWorld();

    }

    @After
    public void teardown() {
        world.teardownWorld();
    }

    @AfterStep
    public void recordFailure(Scenario scenario) {

        if(scenario.isFailed()) {
            // Take a screenshot
           byte[] screenshot = ((TakesScreenshot) world.getDriver()).getScreenshotAs(OutputType.BYTES);
           String fileName = scenario.getName();
           scenario.embed(screenshot, "image/png");

        }


   }
}
