package seleniumgluecode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;


public class TestSteps extends TestBase {

    @Given("I enter url")
    public void setUpPage(){
        // i could choose the driver her be it firefox or chrome, etc
        driver.manage().window().maximize();
    }

    @Then("I should see page title {string}")
    public void pageTitle(String title) throws Exception {
        Assert.assertEquals(title,homePage.getTitle());
    }

    @Then("I scroll down to video player")
    public void scrollToPlayerPixels() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", homePage.playerLoc());
    }

    @Then("I click player")
    public void clickVideoPlayer() throws Exception {
        homePage.playVideo();
    }
    @And("Video is {string}")
    public void playerOff(String string) throws InterruptedException {
        if(string.equals("off")){
            Assert.assertFalse("Video is not Off", homePage.isVideoPlaying());
        }else if(string.equals("on")){
            Assert.assertTrue("Video is not On", homePage.isVideoPlaying());
        }
    }
    @When("I click the next video")
    public void nextVideo() throws Exception {
        homePage.changeToNextVideo();
        Thread.sleep(3000);
    }

    @Then("I click a random video")
    public void randomVideo() throws InterruptedException {
        homePage.getRandomVideo();
        Thread.sleep(3000);
    }




}
