@test

Feature: Forgot Password
  Scenario Outline: Retrieve passwords for different email addresses
    Given I browse to webpage https://the-internet.herokuapp.com/forgot_password
    When I enter the email address <email>
    And I click the retrieve password button
    Then The text Your e-mail's been sent! is displayed

    Examples:
    | email           |
    | test@email.com  |
    | test2@gmail.com |