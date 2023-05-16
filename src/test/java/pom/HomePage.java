package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {

    By videoPlayerLocator = By.id("preview-player");
    By timeStampLocator = By.xpath("//span[@class='vjs-remaining-time-display']");
    By nextVideo = By.xpath("//li[@class='vjs-playlist-item vjs-up-next']");
    By listVideosLocator = By.cssSelector("ol.vjs-playlist-item-list li");
    public HomePage(WebDriver driver){
        super(driver);
    }
    public WebElement playerLoc (){
        return driver.findElement(videoPlayerLocator);
    }
    public Boolean isVideoPlaying() throws InterruptedException {
        WebElement  timeStamp =driver.findElement(timeStampLocator);
        Thread.sleep(2000);
        String firstStamp = timeStamp.getText();
        Thread.sleep(2000);
        String secondStamp = timeStamp.getText();

        if(firstStamp.equals(secondStamp)){
            return false;
        }else{
            return true;
        }
    }
    public void playVideo() throws Exception {
        this.click(videoPlayerLocator);
    }
    public void changeToNextVideo() throws Exception {
        if (this.isDisplayed(nextVideo)){
            this.click(nextVideo);
        }
    }
    public void getRandomVideo(){
        List<WebElement> list1 = driver.findElements(listVideosLocator);
        int size = list1.size();

        Random rand = new Random();
        int index = rand.nextInt(size); // between 0 (inclusive) and n (exclusive).
        System.out.println("rand number"+index);

        //index go from 0-6 (for some reason the last li doesn't have a video)
        list1.get(index).click();

    }
}
