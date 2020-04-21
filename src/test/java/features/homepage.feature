@homepage @all
  Feature: Homepage
    Scenario: The look and feel of the home page is as expected
      Given I browse to webpage https://the-internet.herokuapp.com
      Then The title of the page is The Internet
      And The homepage text Welcome to the-internet is displayed

