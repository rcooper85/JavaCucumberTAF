package steps;

import base.CucumberWorld;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AlertsPage;

import java.io.IOException;

public class AlertsSteps {

    private CucumberWorld world;
    private AlertsPage alertsPage;

    public AlertsSteps(CucumberWorld world) {
        this.world = world;
        alertsPage = new AlertsPage(this.world);
    }

    @When("I click on the button Click for JS Alert")
    public void iClickOnTheButtonClickForJSAlert() {
        //alertsPage = new AlertsPage(this.world);
        alertsPage.clickAlertButton();
    }

    @Then("^The alert text (.+) is displayed$")
    public void theAlertIsDisplayed(String expectedAlertText) {
        String actualAlertText = alertsPage.getAlertText();

        Assert.assertEquals("The text in the alert does not match the expected text. ", expectedAlertText, actualAlertText);

    }

    @And("I click to accept the alert")
    public void iClickToAcceptTheAlert() {
        alertsPage.acceptAlert();
    }

    @Then("^I take a screenshot with filename (.+)$")
    public void iTakeAScreenshot(String filename) throws IOException {
        alertsPage.takeScreenshot(filename);
    }

    @When("I click on the button Click for JS Prompt")
    public void iClickOnTheButtonClickForJSPrompt() {
        alertsPage.clickPromptButton();
        
    }

    @And("I enter the text {string}")
    public void iEnterTheText(String arg0) {
        alertsPage.alert_setInput(arg0);
        
    }

    @Then("The text {string} is displayed in the result section")
    public void theTextIsDisplayedInTheResultSection(String arg0) {
        String actualText = alertsPage.getResult();

        Assert.assertEquals("The text you entered does not match what was expected.", arg0, actualText);


    }
}
