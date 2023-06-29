Feature: Edit customers on the CRM page
  As a user, I want to edit customers on the CRM page

  Background:
    Given user logged in the CRM system with "Admin" role

  @EditCustomersSuccess
  Scenario: Edit customers successfully on the CRM page
    Given user has access to the Customer page
    When users looking for customers to edit
      | Company       | Phone     | Website                |
      | Ngăn Ngăn M_M | 098863000 | momo.com.vn            |
      | Cucumber M_M  | 098863921 | https://www.fahasa.com |

    Then user should see successful edit customer message