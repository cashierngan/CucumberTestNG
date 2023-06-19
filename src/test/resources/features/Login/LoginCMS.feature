Feature: Login CMS

  @success
  Scenario: Login success
    Given user navigation to Login page "https://cms.anhtester.com/"
    When user enter email "admin@example.com" and password "123456"
    And click on Login button
    Then user redirect to admin page "https://cms.anhtester.com/admin"

  Scenario: Invalid Login
    Given user navigation to Login page "https://cms.anhtester.com/"
    When user enter email "admin@gmail.com" and password "123456"
    And click on Login button
    Then user should see an error message
    And stay on the login page

#  Scenario: Empty Username
#    Given user on the login page
#    When user leave the username field empty
#    And enter a valid password
#    And click on the login button
#    Then user should see an error message
#    And stay on the login page
#
#  Scenario: Empty Password
#    Given user on the login page
#    When user leave the password field empty
#    And enter a valid username
#    And click on the login button
#    Then user should see an error message
#    And stay on the login page
#
#  Scenario: Locked Account
#    Given user on the login page
#    And my account has been locked
#    When user enter valid username and password
#    And click on the login button
#    Then user should see an error message
#    And stay on the login page
#
#  Scenario: Forgotten Password
#    Given user on the login page
#    And user have forgotten my password
#    When user click on the "Forgot Password" link
#    And enter my email address
#    And click on the "Reset Password" button
#    Then user should receive an email with instructions to reset my password.

#  @invalid
#  Scenario Outline: Login failed with invalid credentials
#    Given I am on the login page
#    When I enter my invalid username and password
#    And I click on Login button
#    Then I should see an error message
#    And I should still be on the login page
#    Examples:
#      | EMAIL             | PASSWORD | PIN |
#      | admin@gmail.com   | 123456   | 123 |
#      | admin@example.com | 123456   | 123 |
