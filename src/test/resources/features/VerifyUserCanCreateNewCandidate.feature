Feature: Verify User can create new candidate
  Scenario:
    Given user open website
    Then verify that user is on login page
    When user login with valid credentials
    Then verify that user is on homepage
    When user click on recruitment link
    Then verify recruitment page is loaded
    Then user clicks on add button
    Then user fill required details with upload on doc file in resume
    When user clicks on save button
    Then verify success message is displayed
    When user search by candidate name
    Then verify search result displays candidate name

