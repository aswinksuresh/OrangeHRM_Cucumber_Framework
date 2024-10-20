Feature: Verify user can Login and Logout
  Background:
    Given user open website
    Then verify that user is on login page
    When user login with valid credentials

  Scenario: verify user can login
    Then verify that user is on homepage

  Scenario: verify user can logout
    Then verify that user is on homepage
    When user logout
    Then verify that user is on login page
