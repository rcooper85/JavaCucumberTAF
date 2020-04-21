package pages;

import base.CucumberWorld;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By homepageHeader = By.xpath("//*[@id=\"content\"]/h1");

    public HomePage(CucumberWorld world) {
        super(world);
        this.world = world;
    }

    public ForgotPasswordPage clickForgotPassword(String link) {
        world.getDriver().findElement(By.linkText(link)).click();
        return new ForgotPasswordPage(world);
    }

    public LoginPage clickLoginPage() {
        clickLink("Form Authentication");
        return new LoginPage(world);
    }

    public InputsPage clickInputsPage() {
        clickLink("Inputs");
        return new InputsPage(world);
    }

    public void clickLink(String linktext) {
        world.getDriver().findElement(By.linkText(linktext)).click();

    }

    public String getTitle() {
        return world.getDriver().getTitle();
    }

    public String getHomepageHeaderText() {
        return world.getDriver().findElement(homepageHeader).getText();
    }
}
