package steps;

import base.CucumberWorld;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ContextMenuPage;

public class ContextmenuSteps {

    private CucumberWorld world;
    private ContextMenuPage contextMenuPage;

    public ContextmenuSteps(CucumberWorld world, ContextMenuPage contextMenuPage) {
        this.world = world;
    }

    @When("I right click in the box")
    public void iRightClickInTheBox() {
        contextMenuPage = new ContextMenuPage(this.world);
        contextMenuPage.rightClickInBox();
    }

    @And("An alert box is present with the text {string}")
    public void anAlertBoxIsPresentWithTheText(String arg0) {
        String actualText = contextMenuPage.getPopUpText();

        Assert.assertEquals("The expected alert text is incorrect", arg0, actualText);
    }
}
