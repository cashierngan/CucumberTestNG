Feature: Login to CRM
  As a user, I want to be able to log into the CRM system
  So that I can manage customer information


  Scenario Outline: Login success
    Given User navigate to Login "CRM" Page
    When User input email "<Email>" and "<Password>"
    And User click on the Login button
    Then The Customers page should be displayed
    Examples:
      | Email             | Password |
      | admin@example.com | 123456   |

  Scenario Outline: Login fails with email incorrect format
    Given User navigate to Login "CRM" Page
    When User input email "<Email>" and "<Password>"
    And User click on the Login button
    Then The invalid message "<Message>" should be displayed
    Examples:
      | Email       | Password | Message                                                     |
      | admin@gmail | 123456   | The Email Address field must contain a valid email address. |

  Scenario Outline: Login fails with email incorrect format 2
    Given User navigate to Login "CRM" Page
    When User input email "<Email>" and "<Password>"
    And User click on the Login button
    Then The verification message should be displayed
    Examples:
      | Email | Password |
      | admin | 123456   |

  Scenario Outline: Login fails with an incorrect password
    Given User navigate to Login "CRM" Page
    When User input email "<Email>" and "<Password>"
    And User click on the Login button
    Then The invalid message "<Message>" should be displayed
    Examples:
      | Email             | Password | Message                   |
      | admin@example.com | 12345678 | Invalid email or password |
