@CY19-172
Feature: As a user, I should be able to remove files from the favorites and upload a file directly

	# As a user, I should be able to add the folder.
	# As a user, I should be able to upload a file inside a folder.

  Background:
    Given user on the dashboard page

  @CY19-150
  Scenario: As a user, I should be able to add the folder
    When the user clicks the "Files" module
    And user clicks the add icon on the top
    And user click "new folder”
    And user write a folder name
    When the user click submit icon
    Then Verify the folder is displayed on the page

	# As a user, I should be able to add the folder.
	# As a user, I should be able to upload a file inside a folder.

  @CY19-151
  Scenario: As a user, I should be able to upload a file inside a folder
    When the user clicks the "Files" module
    And user choose a folder from the page
    And user clicks the add icon on the top
    When the user uploads a file with the upload file option
    Then Verify the file is displayed on the page