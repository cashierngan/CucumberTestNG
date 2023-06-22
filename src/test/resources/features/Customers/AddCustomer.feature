Feature: Add customers to the CRM page
  As a user, I want to add a new customer into the CRM page

  Background:
    Given user logged in the CRM system with "Admin" role

  @AddCustomerSuccess
  Scenario Outline: Add a new customer success
    Given user has access to the Customer page
    When user has finished entering Company "<Company>", Phone "<Phone>", Website "<Website>" the customer information
    And user click on the Save button
    Then A new customer with phone "<phone>", website "<website>" would be displayed
    Examples:
      | Company | Phone      | Website         |
      | MoMo    | 0869905206 | https://momo.vn |


 # Sử dụng data table
  @InvalidAddCustomers
  Scenario: Validation add customers
    Given user has access to the Customer page
    When user entes  invalid credentials to add customers
      | Company      | VAT Number | Phone     | Website       | Group  | Currency | Default Language | Address                            | City | State  | ZipCode | Country |
      |   [blank]    | 3x389220AD | 098863731 | anhtester.com | Silver | USD      | German           | 1172A, Đường số 1, Tân Phú, Quận 7 | HCM  | Quận 7 | 056X    | VietNam |
      | Cucumber2023 | 3x389220AD | 098863731 | anhtester.com | Silver | USD      | German           | 1172A, Đường số 1, Tân Phú, Quận 7 | HCM  | Quận 7 | 056X    | VietNam |

    Then user should see an error message



