@us_05
Feature: As a user, I should be able to access to Files module - Favorites button
  Background:
    Given user on the dashboard page
    When the user clicks the "Files" module

  Scenario: Verify users to add files to Favorites
    When the user clicks action-icon from any file on the page
    And user choose the "Add to favorites" option
    And user click the "Favorites" sub-module
    Then Verify the chosen file is listed on the table