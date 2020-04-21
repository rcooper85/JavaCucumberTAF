package pages;

import base.CucumberWorld;
import org.openqa.selenium.By;

public class AlertsPage extends BasePage {

    private By jsAlertButton = By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");


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

    public void clickPrimptButton() {
        world.getDriver().findElement(triggerPromptButton).click();
    }

    public void acceptAlert() {
        world.getDriver().switchTo().alert().accept();
    }


    public String getAlertText() {
        return world.getDriver().switchTo().alert().getText();
    }
}
