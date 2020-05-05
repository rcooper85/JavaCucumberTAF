package steps;

import base.CucumberWorld;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DropdownPage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class DropdownSteps {

    private CucumberWorld world;
    private DropdownPage dropdownPage;

    public DropdownSteps(CucumberWorld world) {
        this.world = world;
        dropdownPage = new DropdownPage(world);
    }

    @When("I select the dropdown item {string}")
    public void iSelectTheDropdownItem(String arg0) {
        dropdownPage.selectFromDropdown(arg0);

    }


    @Then("The selected option {string} is displayed")
    public void theSelectedOptionIsDisplayed(String option) {
        List<String> selectedOptions = dropdownPage.getSelectedOptions();

        Assert.assertTrue("The expected Option could not be found", selectedOptions.contains(option));

    }

}
