Feature: Crystal Service test

  Scenario: Check of the mail in gmail
    Given I open "https://www.gmail.com" url
    And "Gmail login" page should be shown
    When I type "crystalservicetest@gmail.com" in "Email" field
    And I click "Next" button
    And "Password" field should be shown
    And I type "_password1999" in "Password" field
    When I click "Sign in" button
    And "Gmail inbox list" page should be shown
    When I click on "Hello" item in "Subjects emails" list
    And "Gmail inbox mail" page should be shown
    And "Email sender" label should be shown
    Then "Email sender" label should have text "crystalservicetest@gmail.com"
    Then "Email subject" label should have text "Hello"
    Then "Email content" label should have text "Hello, Crystal Service)"
    And I click "Google account" button
    And I click "Sign out" button