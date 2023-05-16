package seleniumgluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static
    WebDriver driver;
    private static int numberOfCase = 0;

    @Before
    public void setUp(){
        numberOfCase++;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://videojs.com/advanced/?video=disneys-oceans");
    }

    @After
    public void tearDown(){
        System.out.println("scenario nro: "+ numberOfCase+" was successful");
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
