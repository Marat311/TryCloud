@wip
Feature:As a user, I should be access all the main modules of the app.
  2. Story: As a user, I should be access all the main modules of the app.
  AC#1 - verify users access to the main modules
  1. Login as a user
  2. Verify the user see the following modules:
  Dashboard
  Files
  Photos
  Activity
  Talk
  Contacts
  Circles
  Calendar
  Desk


  Background:
    Given user on the login page

  Scenario Outline: Login with valid credentials


    When user use username "<username>" and password "<password>"
    Then verify the user see the following modules
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |


    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user37   | Userpass123 |
      | user67   | Userpass123 |
      | user97   | Userpass123 |