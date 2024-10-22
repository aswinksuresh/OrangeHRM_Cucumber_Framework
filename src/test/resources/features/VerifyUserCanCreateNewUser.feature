Feature: Verify user can create new user

  Scenario:
    Given user open website
    Then verify that user is on login page
    When user login with valid credentials
    Then verify that user is on homepage
    When user clicks on admin link
    Then verify user is on admin page
    When user clicks on add button
    Then verify add user page loaded
    Then user select user role as ESS
    Then user add employee name
    Then user make the status enabled
    Then user sets username and password
    When user clicks on save button
    Then verify success message is displayed
    Then verify system users page loaded
    When user search newly created user
    Then verify newly created user is displayed in search list
    Then user click on delete icon of the newly created user
    When user click on Yes, Delete button
    Then verify the success message  is displayed

