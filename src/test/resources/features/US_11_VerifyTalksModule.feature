Feature: US_11 As a user, I should be able to access to Talks module
@US-159 @US-162
  Scenario: verify users to access to Talks module
    Given user on the dashboard page
    When the user clicks the "Talk" module
    Then verify the page title is "Talk - Trycloud QA"
@US-160 @US-162
  Scenario: verify users to send a message
    Given user on the dashboard page
    When the user clicks the "Talk" module
    And user search "User19" user from the search box
    And user writes  "Cool Cool Cool" in the message box
    And user clicks to submit button
    Then the user should be able to see the "Cool Cool Cool" message is displayed on the conversation log
