package steps;

import base.CucumberWorld;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;

public class Hooks {

    CucumberWorld world;

    public Hooks(CucumberWorld world) {
        this.world = world;
    }

    @Before
    public void initialiseTests() throws MalformedURLException {

        world.setupWorld();
    }

    @After
    public void teardown() {
        world.teardownWorld();
    }

    @AfterStep
    public void recordFailure(Scenario scenario) {
        String fileName = scenario.getName();
        if(scenario.isFailed()) {
            // Take a screenshot
           byte[] screenshot = ((TakesScreenshot) world.getDriver()).getScreenshotAs(OutputType.BYTES);
           scenario.embed(screenshot, "image/png", fileName);

        }
   }
}
