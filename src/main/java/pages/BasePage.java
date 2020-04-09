package pages;

import base.CucumberWorld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public String baseUrl = "https://the-internet.herokuapp.com/";
    protected WebDriver driver;
    public CucumberWorld world;

    public BasePage(CucumberWorld world) {
        this.world = world;
    }


    public ForgotPasswordPage clickForgotPassword(String link) {
        world.getDriver().findElement(By.linkText(link)).click();
        return new ForgotPasswordPage(world);

    }

    public LoginPage clickLoginPage() {
        world.getDriver().findElement(By.linkText("Form Authentication")).click();
        return new LoginPage(world);
    }

}
