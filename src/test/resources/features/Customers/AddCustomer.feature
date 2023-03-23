Feature: Add customers to the CRM page
  As a user, I want to add a new customer into the CRM page

  Background:
    Given user logged in the CRM system with "Admin" role

  Scenario Outline: Add a new customer success
    Given user has access to the Customer page
    When user has finished entering Company "<company>", Phone "<phone>", Website "<website>" the customer information
    And user click on the Save button
    Then A new customer with phone "<phone>", website "<website>" would be displayed
    Examples:
      | company | phone      | website         |
      | MoMo    | 0869905206 | https://momo.vn |


