@FilipFirstTests
Feature: Filip Tests with Cucumber

  Background:
    Given The user opens up the automation testing store website

  @StartingTheTestsBelow
  Scenario: Guest user sees Sign In and Create Account options
    When The user is on the homepage
    Then The Sign In and Create Account buttons should be visible
