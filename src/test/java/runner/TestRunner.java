package runner;


import base.CucumberWorld;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"}, glue = "steps", plugin = {"json:target/cucumber-report/cucumber.json"}, monochrome = true)
public class TestRunner {

//    private static CucumberWorld world;
//
//    @BeforeClass
//    public static void setup() throws MalformedURLException {
//        world.setupWorld();
//    }
//
//    @AfterClass
//    public static void teardown() {
//        world.teardownWorld();
//    }

}
