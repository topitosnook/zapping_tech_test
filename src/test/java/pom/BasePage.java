package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected static WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    public void click (By element) throws Exception {
        try {
            driver.findElement(element).click();
        }catch (Exception e){
            throw new Exception("was not able to click on element: "+element);
        }
    }

    public boolean isDisplayed (By element) throws Exception {
        try {
            return driver.findElement(element).isDisplayed();
        }catch (Exception e){
            throw new Exception("No se pudo encontra el elemento: "+element);
        }
    }

    public static String getTitle() throws Exception {
        try {
            return driver.getTitle();
        }catch (Exception e){
            throw new Exception("No se pudo obtener el titulo del driver ");
        }
    }


}
