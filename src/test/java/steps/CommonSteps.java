package steps;

import base.CucumberWorld;
import io.cucumber.java.en.And;
import pages.BasePage;

public class CommonSteps {

    private CucumberWorld world;
    private BasePage homepage;

    public CommonSteps(CucumberWorld world) {
        this.world = world;
    }

    @And("I wait {int} seconds")
    public void iWaitSeconds(long arg0) throws InterruptedException {
        Long seconds = arg0 * 1000;
        Thread.sleep(seconds);
    }
}
