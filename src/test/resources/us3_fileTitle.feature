@smoke
Feature:As a user, I should be able to access to Files module.
  3. Story: As a user, I should be able to access to Files module.
  AC#1 - verify users can access to Files module
  1. Login as a user
  2. Verify the page tile is “Files - Trycloud”

  AC#2 - verify users can select all the uploaded files from the page
  1. Login as a user
  2. Click the top left checkbox of the table
  3. Assert all the files are selected
  (Pre-condition: there should be at least 2 files are uploaded the page)

  Background:
    Given user on the login page

  Scenario Outline: Login with valid credentials


    When user use username "<username>" and password "<password>"
    Then user should be at dashboard page
    When user click the "Files" module on the page
    Then Verify the page tile is "Files - Trycloud"
    When user click the top left checkbox of the table
    Then user should see all the files are selected

    Examples:
      | username | password    |
      | user7    | Userpass123 |
   #   | user37   | Userpass123 |
   #   | user67   | Userpass123 |
    #  | user97   | Userpass123 |