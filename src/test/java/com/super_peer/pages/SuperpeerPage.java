package com.super_peer.pages;

import com.super_peer.utilities.BrowserUtils;
import com.super_peer.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SuperpeerPage extends BasePage {

    @FindBy(xpath ="//*[@id=\"video-title\"]/yt-formatted-string")
    public List<WebElement> list;

    @FindBy(xpath ="//*[@id=\"video-title\"]/yt-formatted-string")
    public WebElement listTwo;

    @FindBy(xpath = "(//h1[@class='title style-scope ytd-video-primary-info-renderer'])//yt-formatted-string")
    public WebElement videoTitle;


    @FindBy(css = "#info-strings > yt-formatted-string")
    public WebElement videoAddedDate;


    @FindBy(css = "div[id='upload-info'] a[class='yt-simple-endpoint style-scope yt-formatted-string']")
    public WebElement ownerOfVideoName;

    @FindBy(xpath = "(//*[@id='text' and @class='style-scope ytd-toggle-button-renderer style-text'])[1]")
    public WebElement likeNumber;

    @FindBy(css = "#dismissible > div > div.metadata.style-scope.ytd-compact-video-renderer > a")
    public WebElement randomVideo;

    @FindBy(id = "movie_player")
    public WebElement stop;

    @FindBy(xpath= "//*[@id=\"container\"]/h1/yt-formatted-string")
    public WebElement randomVideoTitle;




    public void stopVideo(){
        BrowserUtils.waitFor(3);
        stop.sendKeys(Keys.SPACE);

    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0,1000)");
        BrowserUtils.waitFor(3);

    }



    public void randomVideo(){
        //BrowserUtils.waitFor(10);
        BrowserUtils.waitForVisibility(randomVideo,10);

        Actions action = new Actions(Driver.get());

        action.doubleClick(randomVideo).build().perform();

    }

    public void verifyRandomVideoTitle(){


        BrowserUtils.waitFor(10);
        String randomVideoText = randomVideoTitle.getAttribute(("innerHTML"));
        System.out.println(randomVideoText);
        verifyVideoTitle(randomVideoText);

    }


    public void verifyOwnerOfVideoName(String arg){
        String actualTitle = arg;
        String expectedTitle = ownerOfVideoName.getText();
        System.out.println("Video's Owner = " + expectedTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
    }



    public void verifyVideoAddedDate(String arg){
        String actualTitle = arg;
        String expectedTitle = videoAddedDate.getText();
        System.out.println("Video's Added Date = " + expectedTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public void verifyVideoTitle(String arg){
        String actualTitle = arg;
        BrowserUtils.waitFor(5);
        String expectedTitle = videoTitle.getText();
        System.out.println("Video's Title = " + expectedTitle);
        BrowserUtils.waitFor(2);
        Assert.assertEquals(actualTitle,expectedTitle);
    }


    //verify page link
    public void verifyTypedUrl(String arg){
        BrowserUtils.waitFor(10);
        String actualUrl = arg;
        String expectedtURL = Driver.get().getCurrentUrl();
        Assert.assertTrue(expectedtURL.contains(arg));

    }



    //open for listed video
    public void clickListedVideoLink(String videoName){
        for(int i =0;i<list.size();i++) {
            String elementText = list.get(i).getText();
            if (elementText.toLowerCase().contentEquals(videoName.toLowerCase())){
                BrowserUtils.waitFor(2);
                list.get(i).click();
                break;
            }else {
                System.out.println("searched video not yet founded");
            }

        }
    }


}
