Feature: Add customers to the CRM page
  As a user, I want to add a new customer into the CRM page

  Background:
    Given user logged in the CRM system with "Admin" role

  @AddCustomerSuccess
  Scenario Outline: Add a new customer success
    Given user has access to the add Customer page
    When user has finished entering Company "<Company>", Phone "<Phone>", Website "<Website>" the customer information
    And user click on the Save button
    Then A new customer with phone "<Phone>", website "<Website>" would be displayed
    Examples:
      | Company | Phone      | Website         |
      | MoMo    | 0869905206 | https://momo.vn |


 # Sử dụng data table
  @InvalidAddCustomers
  Scenario: Validation add customers
    Given user has access to the add Customer page
    When user enter invalid credentials to add customers
      | Company      | Phone     | Website       | Groups | Currency | Default Language | Address                            | City | State   | ZipCode | Country |
      | [blank]      | 098863731 | anhtester.com | Silver | USD      | French           | 1172A, Đường số 1, Tân Phú, Quận 7 | HCM  | Quận 7  | 056X    | VietNam |
#      | Cucumber2023 | 098863731 | anhtester.com | VIP    | VNĐ      | Indonesia        | 83 Tổng Lung                       | HCM  | Quận 11 | 0987X   | VietNam |

    Then user should see an error message



