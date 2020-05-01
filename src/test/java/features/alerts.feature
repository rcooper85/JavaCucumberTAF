@alerts @all
  Feature: Alerts
    Scenario: Test that you can accept alerts
      Given I browse to webpage https://the-internet.herokuapp.com/javascript_alerts
      When I click on the button Click for JS Alert
      Then The alert text I am a JS Alert is displayed
      And I click to accept the alert
      Then I take a screenshot with filename alerts-screenshot

      Scenario: Test that you can set an input into an alert
        Given I browse to webpage https://the-internet.herokuapp.com/javascript_alerts
        When I click on the button Click for JS Prompt
        And I enter the text "Input text for alert"
        And I click to accept the alert
        Then The text "You entered: Input text for alert" is displayed in the result section
