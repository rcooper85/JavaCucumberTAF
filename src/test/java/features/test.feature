@test
  Feature: My test feature
    Scenario: This is a test scenario
      Given I browse to webpage https://the-internet.herokuapp.com/
      When I click on the link Forgot Password
      Then I see email field present
      And The retrieve password button is present