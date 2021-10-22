#7. Story: As a user, I should be able to access to Files module.
#AC #1 - verify users can delete a file/folder.
#1. Login as a user
#2. Click action-icon from any file on the page
#3. Choose “delete files” option
#4. Click deleted files on the left bottom corner
#5. Verify the deleted file is displayed no the page.
#(Pre-condition: there should be at least 1 file is uploaded inside files page)
@wip
Feature: Access to Files module
  As a user, I should be able to access to Files module.

  Background:
    Given user on the login page

  Scenario Outline: user should be able to access Files module

    When  user use username "<username>" and password "<password>"
    And   user click login button
    When  Clicks action-icon from any file on the page
    And   Choose “delete files” option
    Then  Verify the deleted file is displayed on the page.

    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user37   | Userpass123 |
      | user67   | Userpass123 |
      | user97   | Userpass123 |