package steps;

import base.CucumberWorld;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;

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

//    @After
//    public void teardown() {
//        world.teardownWorld();
//    }
}
