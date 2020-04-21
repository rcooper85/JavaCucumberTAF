package steps;

import base.CucumberWorld;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;
import pages.HomePage;

public class ForgotPasswordSteps {

    private CucumberWorld world;
    private HomePage homepage;
    private ForgotPasswordPage forgotPasswordPage;
    private EmailSentPage emailSentPage;

    public ForgotPasswordSteps(CucumberWorld world) {
        this.world = world;
    }

    @Given("^I browse to webpage (.*)$")
    public void iBrowseToWebpageHttpsTheInternetHerokuappCom(String webpage) {
        world.getDriver().navigate().to(webpage);
        //System.out.println("The url is: " + testEnvironment.url());

    }

    @When("^I click on the link (.*)$")
    public void iClickOnTheLinkForgotPassword(String link) throws InterruptedException {
        homepage = new HomePage(this.world);
        homepage.clickForgotPassword(link);
    }

    @Then("^I see email field present$")
    public void iSeeEmailFieldPresent() {
        //forgotPasswordPage = new ForgotPasswordPage(this.world);

        Assert.assertTrue("The email field is not displayed", forgotPasswordPage.emailIdIsDisplayed());
    }

    @And("^The retrieve password button is present$")
    public void theRetrievePasswordButtonIsPresent() {
    }

    @When("^I enter the email address (.+)$")
    public void iEnterTheEmailAddressEmail(String email) {
        forgotPasswordPage = new ForgotPasswordPage(this.world);
        forgotPasswordPage.enterEmailAddress(email);
    }

    @And("I click the retrieve password button")
    public void iClickTheRetrievePasswordButton() {
        //forgotPasswordPage = new ForgotPasswordPage(this.world);
        forgotPasswordPage.clickRetrieveButton();

    }

    @Then("^The text (.+) is displayed$")
    public void theTextYourEMailSBeenSentIsDisplayed(String message) {
        emailSentPage = new EmailSentPage(this.world);
        String actualresult = emailSentPage.getMessage();

        Assert.assertEquals("The message was incorrect", message, actualresult);


    }

}
