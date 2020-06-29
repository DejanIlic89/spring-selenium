Feature: Login feature
  This feature deals with the login functionality of the application

  @login
  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter the following for Login
      | Username | Password |
      | admin    | admin    |
    And I click login button
    Then I should see the user form page