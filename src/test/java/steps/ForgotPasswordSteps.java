package steps;

import base.CucumberWorld;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

public class ForgotPasswordSteps {

    private CucumberWorld world;
    private BasePage homepage;
    private ForgotPasswordPage forgotPasswordPage;
    private EmailSentPage emailSentPage;

    public ForgotPasswordSteps(CucumberWorld world) {
        this.world = world;
        homepage = new BasePage(this.world);
        forgotPasswordPage = new ForgotPasswordPage(this.world);
        emailSentPage = new EmailSentPage(this.world);
    }

    @Given("^I browse to webpage (.*)$")
    public void iBrowseToWebpageHttpsTheInternetHerokuappCom(String webpage) {
        world.getDriver().navigate().to(webpage);

    }

    @When("^I click on the link (.*)$")
    public void iClickOnTheLinkForgotPassword(String link) throws InterruptedException {
        this.homepage.clickForgotPassword(link);
    }

    @Then("^I see email field present$")
    public void iSeeEmailFieldPresent() {
        //forgotPasswordPage = new ForgotPasswordPage(this.world);
        //this.forgotPasswordPage.emailIdIsDisplayed();
        this.forgotPasswordPage.emailIdIsDisplayed();


    }

    @And("^The retrieve password button is present$")
    public void theRetrievePasswordButtonIsPresent() {
    }

    @When("^I enter the email address (.+)$")
    public void iEnterTheEmailAddressEmail(String email) {
        this.forgotPasswordPage.enterEmailAddress(email);
    }

    @And("I click the retrieve password button")
    public void iClickTheRetrievePasswordButton() {
        this.forgotPasswordPage.clickRetrieveButton();

    }

    @Then("^The text (.+) is displayed$")
    public void theTextYourEMailSBeenSentIsDisplayed(String message) {
        String actualresult = this.emailSentPage.getMessage();
        Assert.assertEquals("The message was incorrect", message, actualresult);


    }

}
