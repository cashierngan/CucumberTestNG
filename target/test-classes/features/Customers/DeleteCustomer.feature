Feature: Delete customer from CRM page
  As a user, I want to delete a new customer from the CRM page

  Background:
    Given user logged in the CRM system with "Admin" role

  Scenario: Delete customer
    Given user has access to the Customer page
    When user search for a new customer
    And user click on Delete button at a new company
    And user click on OK
    Then delete message be displayed
