package pages;

import base.CucumberWorld;
import org.openqa.selenium.By;

public class AlertsPage extends BasePage {

    private By jsAlertButton = By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private By results = By.id("result");


    public AlertsPage(CucumberWorld world) {
        super(world);
        this.world = world;
    }

    public void clickAlertButton() {
        world.getDriver().findElement(jsAlertButton).click();
    }

    public void clickConfirmButton() {
        world.getDriver().findElement(triggerConfirmButton).click();
    }

    public void clickPromptButton() {
        world.getDriver().findElement(triggerPromptButton).click();
    }

    public void alert_setInput(String text) {
        world.getDriver().switchTo().alert().sendKeys(text);
    }

    public void acceptAlert() {
        world.getDriver().switchTo().alert().accept();
    }


    public String getAlertText() {
        return world.getDriver().switchTo().alert().getText();
    }

    public String getResult() {
        return world.getDriver().findElement(results).getText();
    }
}
