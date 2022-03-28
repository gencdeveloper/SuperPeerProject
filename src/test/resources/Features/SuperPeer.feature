@positiveTest
Feature: User should be able to go youtube and type superpeer to search box

  Background:
    Given User is on the home youtube page


  Scenario: User click and should be verify that Superpeer'in kuruluş hikayesi

    When  User should be able to type "Superpeer" to search box
    Then  User should be able to verify that "Superpeer'in kuruluş hikayesi" content from the listed content
    Then  User should be able to open video title with "Superpeer'in kuruluş hikayesi"
    And   User should be able to verify that url opening as with "/watch?v=ZNe-TIiLiEI"
    And   User should be able to verify that the video’s title is the same as the opened from the list "Superpeer'in kuruluş hikayesi"
    And   User should be able to verify that the video’s added date is "11 Dec 2020"
    And   User should be able to verify that the video’s owner is "Fatih Acet"
    And   User should be able to verify that the number of likes is more than “100”
    Then  User should be able to stop the video
    Then  User should be able to scroll down to page
    And   User should be able to verify that Page header is fixed at the top.
    Then  User should be able to Click a “random” video which is listed in the suggested videos list at the right of the page.
    And   User should be able to verify that the video’s title is the same as the random choice video.


