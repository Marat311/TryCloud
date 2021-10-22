@wip
Feature: As a user, I should be able to access to Files module
#Story: As a user, I should be able to access to Files module.
#AC #1 - verify users can write comments to files/folders.
#1. Login as a user
#2. Click action-icon from any file on the page
#3. Click details
#4. Write a comment inside to the input box
#5. Click the submit button to post it
#6. Verify the comment is displayed in the comment section.
#(Pre-condition: t

  Background:
    Given user on the login page

  Scenario Outline: Login with valid credentials


    When user use username "<username>" and password "<password>"

    Then user should be at dashboard page


    When user click the "Files" module on the page
    And Click action-icon from any file on the page
    And Click details
    And Write a comment inside to the input box
    And Click the submit button to post it
    Then Verify the comment is displayed in the comment section.

    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user37   | Userpass123 |
      | user67   | Userpass123 |
      | user97   | Userpass123 |
