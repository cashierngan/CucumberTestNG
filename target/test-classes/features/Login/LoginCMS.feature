Feature: Login CMS

  @success
  Scenario: Login success
    Given navigation to Login page "https://cms.anhtester.com/"
    When enter email "admin@example.com" and password "123456"
    And click on Login button
    Then redirect to admin page "https://cms.anhtester.com/admin"

  @invalid
  Scenario Outline: Login failed with invalid credentials
    Given I am on the login page
    When I enter my invalid username and password
    And I click on Login button
    Then I should see an error message
    And I should still be on the login page
    Examples:
      | EMAIL             | PASSWORD | PIN |
      | admin@gmail.com   | 123456   | 123 |
      | admin@example.com | 123456   | 123 |
