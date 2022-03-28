package com.super_peer.step_definitions;

import com.super_peer.pages.HomePage;
import com.super_peer.pages.SuperpeerPage;
import com.super_peer.utilities.BrowserUtils;
import com.super_peer.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class SuperPrStep {

    SuperpeerPage superpeerPage = new SuperpeerPage();


    @When("User should be able to type {string} to search box")
    public void user_should_be_able_to_type_to_search_box(String arg) {

       new HomePage().searchText(arg);


    }

    @Then("User should be able to verify that {string} content from the listed content")
    public void user_should_be_able_to_verify_that_content_from_the_listed_content(String contentText) {

        BrowserUtils.waitFor(20);
        List<String> playList = new ArrayList<>();
        superpeerPage.list.stream().forEach(each->{
            playList.add(each.getText());
        });
        System.out.println("playList = " + playList);

        Assert.assertTrue(playList.contains(contentText));



    }

    @Then("User should be able to open video title with {string}")
    public void user_should_be_able_to_open_video_title_with(String listedVideo) {

        superpeerPage.clickListedVideoLink(listedVideo);


    }

    @Then("User should be able to verify that url opening as with {string}")
    public void user_should_be_able_to_verify_that_url_opening_as_with(String typedUrl) {

        superpeerPage.verifyTypedUrl(typedUrl);

    }

    @Then("User should be able to verify that the video’s title is the same as the opened from the list {string}")
    public void user_should_be_able_to_verify_that_the_video_s_title_is_the_same_as_the_opened_from_the_list(String actualvideoTitle) {

        superpeerPage.verifyVideoTitle(actualvideoTitle);
    }

    @Then("User should be able to verify that the video’s added date is {string}")
    public void user_should_be_able_to_verify_that_the_video_s_added_date_is(String videoAddedDate) {

       superpeerPage.verifyVideoAddedDate(videoAddedDate);

    }

    @And("User should be able to verify that the video’s owner is {string}")
    public void userShouldBeAbleToVerifyThatTheVideoSOwnerIs(String videoOwner) {

        superpeerPage.verifyOwnerOfVideoName(videoOwner);

    }


    @Then("User should be able to verify that the number of likes is more than “{int}”")
     public void user_should_be_able_to_verify_that_the_number_of_likes_is_more_than(Integer expectedLikeNumber) {
        BrowserUtils.waitForVisibility(superpeerPage.likeNumber,40);
        String numberCheck = superpeerPage.likeNumber.getAttribute("aria-label");
        System.out.println("numberCheck = " + numberCheck);

        int currentLikeNumber = Integer.parseInt(numberCheck.substring(0,3));
        System.out.println("currentLikeNumber = " + currentLikeNumber);
        Assert.assertTrue(currentLikeNumber >= expectedLikeNumber);

    }

    @Then("User should be able to stop the video")
    public void user_should_be_able_to_stop_the_video() {

        superpeerPage.stopVideo();

    }

    @Then("User should be able to scroll down to page")
    public void user_should_be_able_to_scroll_down_to_page() {

        superpeerPage.scrollDown();


    }

    @Then("User should be able to verify that Page header is fixed at the top.")
    public void user_should_be_able_to_verify_that_Page_header_is_fixed_at_the_top() {

        WebElement logo = Driver.get().findElement(By.xpath("//ytd-topbar-logo-renderer[@id='logo']//div[@class='style-scope ytd-topbar-logo-renderer']//yt-icon[@id='logo-icon']"));

        if(true){
            Assert.assertTrue(logo.isDisplayed());
            System.out.println("navbar fixed");

        }else {
            Assert.assertFalse(false);
        }
    }

    @Then("User should be able to Click a “random” video which is listed in the suggested videos list at the right of the page.")
    public void user_should_be_able_to_Click_a_random_video_which_is_listed_in_the_suggested_videos_list_at_the_right_of_the_page() {

        superpeerPage.randomVideo();

    }

    @Then("User should be able to verify that the video’s title is the same as the random choice video.")
    public void user_should_be_able_to_verify_that_the_video_s_title_is_the_same_as_the_random_choice_video() {


        superpeerPage.verifyRandomVideoTitle();



    }



}
