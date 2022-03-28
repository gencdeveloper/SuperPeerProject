package com.super_peer.pages;

import com.super_peer.utilities.BrowserUtils;
import com.super_peer.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    //AgreeButton for pop up
    @FindBy(xpath = "//a//*[text()='I agree']")
    public WebElement agreeButton;

    @FindBy(xpath = "//input[@id='search']")
    public WebElement searchInput;


    @FindBy(css = "#search-icon-legacy.style-scope")
    public WebElement searchButton;


    //verify page link
    public void verifyHomePageUrl(){
        String actualUrl = "https://www.youtube.com/";
        String expectedtURL = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);
    }

    public void searchText(String actualText){
        searchInput.sendKeys(actualText);
        searchButton.click();
    }


    /**
     * Waits until loader screen present. if loader saw the pop up it will handled
     * if not it is going on well
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 20);
            wait.until(ExpectedConditions.elementToBeClickable(agreeButton)).click();
            BrowserUtils.waitFor(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
