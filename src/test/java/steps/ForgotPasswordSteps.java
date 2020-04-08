package steps;

import base.CucumberWorld;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.ForgotPasswordPage;

public class ForgotPasswordSteps {

    private CucumberWorld world;
    private BasePage homepage;
    private ForgotPasswordPage forgotPasswordPage;

    public ForgotPasswordSteps(CucumberWorld world) {
        this.world = world;
        homepage = new BasePage(this.world);
        forgotPasswordPage = new ForgotPasswordPage(this.world);
    }

    @Given("^I browse to webpage (.*)$")
    public void iBrowseToWebpageHttpsTheInternetHerokuappCom(String webpage) {
        world.getDriver().navigate().to(webpage);

    }

    @When("^I click on the link (.*)$")
    public void iClickOnTheLinkForgotPassword(String link) throws InterruptedException {
        this.homepage.clickForgotPassword();
    }

    @Then("^I see email field present$")
    public void iSeeEmailFieldPresent() {
        //forgotPasswordPage = new ForgotPasswordPage(this.world);
        this.forgotPasswordPage.emailIdIsDisplayed();


    }

    @And("^The retrieve password button is present$")
    public void theRetrievePasswordButtonIsPresent() {
    }
}
