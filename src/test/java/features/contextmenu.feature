@contextmenu @all

  Feature: Context menu right click functionality
    Scenario: Test that the right click works
      Given I browse to webpage https://the-internet.herokuapp.com/context_menu
      When I right click in the box
      And An alert box is present with the text "You selected a context menu"
      Then I click to accept the alert