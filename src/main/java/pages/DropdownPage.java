package pages;

import base.CucumberWorld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DropdownPage extends BasePage {

    private CucumberWorld world;
    private By dropdown = By.id("dropdown");

    public DropdownPage(CucumberWorld world) {
        super(world);
        this.world = world;
    }

    public void selectFromDropdown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    private Select findDropDownElement() {
        return new Select(world.getDriver().findElement(dropdown));
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }


}
