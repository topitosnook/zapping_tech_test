package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import pom.HomePage;

public class TestBase {

    protected WebDriver driver=Hooks.getDriver();
    protected HomePage homePage = new HomePage(driver);

}
