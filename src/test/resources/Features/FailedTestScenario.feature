@failedTest
Feature: User should be able to try failed scenario

  Background:
    Given User is on the home youtube page


    ##The scenarios on this page are designed to fail. Thus, a screenshot will be created for the error points in the html report.

  Scenario: User should be able to type "Medium" to youtube search box and open Superpeer'in kuruluş hikayesi

    When  User should be able to type "Medium" to search box
    Then  User should be able to verify that "Superpeer'in kuruluş hikayesi" content from the listed content
    Then  User should be able to open video title with "Superpeer'in kuruluş hikayesi"



#In this scenario added wrong video's date
  Scenario:User click and should be verify that video's added date is 11 Dec 2020
    When  User should be able to type "Superpeer" to search box
    Then  User should be able to verify that "Superpeer'in kuruluş hikayesi" content from the listed content
    Then  User should be able to open video title with "Superpeer'in kuruluş hikayesi"
    And   User should be able to verify that url opening as with "/watch?v=ZNe-TIiLiEI"
    And   User should be able to verify that the video’s title is the same as the opened from the list "Superpeer'in kuruluş hikayesi"
    And   User should be able to verify that the video’s added date is "11 Dec 2099"
    And   User should be able to verify that the video’s owner is "Fatih Acet"






