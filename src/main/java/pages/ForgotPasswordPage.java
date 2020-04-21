package pages;

import base.CucumberWorld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage extends BasePage {

    private By emailField = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");

    public ForgotPasswordPage(CucumberWorld world) {
        super(world);
        this.world = world;
    }

    @FindBy(how = How.ID, using = "email")
    public WebElement emailid;

    public boolean emailIdIsDisplayed() {
        return world.getDriver().findElement(emailField).isDisplayed();
    }

    public void enterEmailAddress(String email) {
        world.getDriver().findElement(emailField).sendKeys(email);
    }

    public EmailSentPage clickRetrieveButton() {
        world.getDriver().findElement(retrievePasswordButton).submit();
        return new EmailSentPage(world);
    }
}
