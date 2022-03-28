package com.super_peer.step_definitions;

import com.super_peer.pages.HomePage;
import com.super_peer.utilities.BrowserUtils;
import com.super_peer.utilities.ConfigurationReader;
import com.super_peer.utilities.Driver;
import io.cucumber.java.en.Given;

public class HomePageStep {

 HomePage homePage = new HomePage();

    @Given("User is on the home youtube page")
    public void user_is_on_the_home_youtube_page() {

        Driver.get().get(ConfigurationReader.get("url"));

        homePage.waitUntilLoaderScreenDisappear();

        homePage.verifyHomePageUrl();

    }

}
