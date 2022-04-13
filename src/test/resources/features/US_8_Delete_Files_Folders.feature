@CY19-169
Feature: As a user, I should be able to delete a file/folder.
  @CY19-168
  Scenario: Verify users can delete a file/folder
    Given user on the dashboard page
    When the user clicks the "Files" module
    And user click action-icon from any file on the page
    And user choose the "Delete files" option
    When the user clicks the "Deleted f" sub-module on the left side
    Then Verify the deleted file is displayed on the page