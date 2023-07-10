Feature: Add, Edit And Delete Customers
  As a user, I want to add a new customer, edit inf customer, delete customer on the CRM page

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
      | Company | Phone      | Website       | Groups | Currency | Default Language | Address                            | City | State  | ZipCode | Country |
      | [blank] | 0988637310 | anhtester.com | Silver | USD      | French           | 1172A, Đường số 1, Tân Phú, Quận 7 | HCM  | Quận 7 | 056X    | VietNam |
#      | Cucumber2023 | 098863731 | anhtester.com | VIP    | VNĐ      | Indonesia        | 83 Tổng Lung                       | HCM  | Quận 11 | 0987X   | VietNam |

    Then user should see an error message add customers

  @DeleteCustomer
  Scenario: Delete customer
    Given user has access to the Customer page
    When user search for a new customer
    And user click on Delete button at a new company
    And user click on OK
    Then delete message be displayed


  @EditCustomer
  Scenario: Edit customers successfully on the CRM page
    Given user has access to the Customer page
    When users looking for customers to edit
      | Company       | Phone     | Website                |
      | Ngăn Ngăn M_M | 098863000 | momo.com.vn            |
      | Cucumber M_M  | 098863921 | https://www.fahasa.com |

    Then user should see successful edit customer message



