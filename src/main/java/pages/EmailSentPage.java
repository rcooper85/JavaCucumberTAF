package pages;

import base.CucumberWorld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmailSentPage extends BasePage {

    public CucumberWorld world;
    private By contentArea = By.id("content");


    public EmailSentPage(CucumberWorld world) {
        super(world);
        this.world = world;
    }

    public String getMessage() {
        return world.getDriver().findElement(contentArea).getText();
    }
}
