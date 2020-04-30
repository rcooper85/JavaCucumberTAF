package pages;

import base.CucumberWorld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage {

    private By box = By.id("hot-spot");

    public ContextMenuPage(CucumberWorld world) {
        super(world);
        this.world = world;
    }

    public void rightClickInBox() {
        Actions actions = new Actions(world.getDriver());
        actions.contextClick(world.getDriver().findElement(box)).perform();
    }

    public String getPopUpText() {
        return world.getDriver().switchTo().alert().getText();
    }

    public void acceptPopUp() {
        world.getDriver().switchTo().alert().accept();
    }

}
