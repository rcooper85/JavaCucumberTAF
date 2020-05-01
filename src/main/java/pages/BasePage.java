package pages;

import base.CucumberWorld;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class BasePage {

    public String baseUrl = "https://the-internet.herokuapp.com/";
    protected WebDriver driver;
    public CucumberWorld world;

    public BasePage(CucumberWorld world) {
        this.world = world;
    }

    public void takeScreenshot(String filename) throws IOException {
       File srcFile = ((TakesScreenshot)world.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Ross\\Desktop\\Repos\\JavaCucumberTAF\\src\\test\\screenshots\\" + filename + ".jpg"));
    }

}
