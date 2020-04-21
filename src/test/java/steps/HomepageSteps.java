package steps;

import base.CucumberWorld;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BasePage;
import pages.HomePage;

public class HomepageSteps {

    private CucumberWorld world;
    private HomePage homepage;

    public HomepageSteps(CucumberWorld world) {
        this.world = world;
            }


    @Then("^The title of the page is (.+)$")
    public void theTitleOfThePageIsTheInternet(String expectedTitle) {
        homepage = new HomePage(this.world);
        String actualTitle = homepage.getTitle();

        Assert.assertEquals("The actual title did not match expected title ", expectedTitle, actualTitle);
    }

    @And("^The homepage text (.+) is displayed$")
    public void theHomepageTextWelcomeToTheInternetIsDisplayed(String expectedText) {
        String actualText = this.homepage.getHomepageHeaderText();

        Assert.assertEquals("The expected text did not match the actual text ", expectedText, actualText);
    }
}
