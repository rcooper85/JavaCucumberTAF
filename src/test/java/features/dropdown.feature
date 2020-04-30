@dropdown @all
  
  Feature: Test the dropdown page
    Scenario: Test the functionality of the dropdown menu
      Given I browse to webpage https://the-internet.herokuapp.com/dropdown
      When I select the dropdown item "Option 1"
      Then The selected option "Option 1" is displayed
