package pages;

import base.CucumberWorld;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private String loginUrl = baseUrl + "login";
    CucumberWorld world;

//    public LoginPage(WebDriver driver) {
//         PageFactory.initElements(driver, this);
//    }

    public LoginPage(CucumberWorld world) {
        super(world);
    }

    @FindBy(how = How.ID, using = "username")
    public WebElement usernameid;

    @FindBy(how = How.ID, using = "password")
    public WebElement passwordid;

    @FindBy(how = How.ID, using = "login")
    public WebElement loginbuttonid;

    public void login(String username, String password) {
        usernameid.sendKeys(username);
        passwordid.sendKeys(password);
        loginbuttonid.submit();
    }

}
