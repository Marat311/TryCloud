@us4
Feature:As a user, I should be able to access to Files module.
  Story4: As a user, I should be able to access to Files module.
  AC #1 - users can add a file to favorites.
  1. Login as a user
  2. Click action-icon from any file on the page
  3. Choose “Add to Favorites” option
  4. Click “Favorites” sub-module on the lest side
  5. Verify the chosen file is listed on the table
  (Pre-condition: there should be at least 1 file is uploaded)

  Background:
    Given user on the login page

  Scenario Outline: Login with valid credentials

    When user use username "<username>" and password "<password>"
    Then user should be at dashboard page

    When user click the "Files" module on the page
    And Click action-icon from any file on the page
    And Choose "Add to favorites" option
    And Click "Favorites" sub-module on the left side
    Then Verify the chosen file "JamesBond" is listed on the table

    Examples:
      | username | password    |
      | user7    | Userpass123 |
     # | user37   | Userpass123 |
    #  | user67   | Userpass123 |
    #  | user97   | Userpass123 |
