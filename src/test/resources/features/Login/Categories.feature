Feature: Manage Categories
  Background:
    Given user logged in the CMS system with "Admin" role

  Scenario: Add new Category
    Given user has access to the Customers page
    When user has finished entering the customer information
    And click the Save button
    Then the message "Category has been created successfully" successfully displays