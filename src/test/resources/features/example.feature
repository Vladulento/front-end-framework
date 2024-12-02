Feature: Visibility of the elements

  Scenario: Error message while login

    Given I open the login page
    When I enter the credentials
    Then I should see the error message

