package pages;

import base.CucumberWorld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage extends BasePage {

    public CucumberWorld world;

    public ForgotPasswordPage(CucumberWorld world) {
        super(world);
    }

    @FindBy(how = How.ID, using = "email")
    public WebElement emailid;

    public void emailIdIsDisplayed() {
        world.getDriver().findElement(By.id("email")).click();
    }
}
