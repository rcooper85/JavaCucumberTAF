package steps;

import base.CucumberWorld;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasePage;

import java.io.IOException;

public class CommonSteps {

    private CucumberWorld world;
    private BasePage basePage;

    public CommonSteps(CucumberWorld world) {

        this.world = world;
        basePage = new BasePage(world);
    }

    @Given("^I browse to webpage (.*)$")
    public void iBrowseToWebpageHttpsTheInternetHerokuappCom(String webpage) {
        world.getDriver().navigate().to(webpage);
    }

    @And("I wait {int} seconds")
    public void iWaitSeconds(long arg0) throws InterruptedException {
        Long seconds = arg0 * 1000;
        Thread.sleep(seconds);
    }

    @Then("^I take a screenshot with filename (.+)$")
    public void iTakeAScreenshot(String filename) throws IOException {
        basePage.takeScreenshot(filename);
    }
}
