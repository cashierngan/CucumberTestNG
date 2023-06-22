package nganxd.stepdifinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import nganxd.hooks.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nganxd.drivers.DriverManager;
import nganxd.util.WebUI;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import nganxd.pages.CustomersPage;
import nganxd.pages.LoginCRMPage;

import java.util.List;
import java.util.Map;

import static nganxd.pages.CustomersPage.companyName;
import static nganxd.pages.CustomersPage.searchCustomer;

public class StepCustomers {
    TestContext testContext;
    CustomersPage customersPage;
    LoginCRMPage loginCRMPage;

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String listOfStringListsType(String cell) {
        return cell;
    }
    public StepCustomers(TestContext testContext){
        this.testContext = testContext;
        customersPage = testContext.getCustomersPage();
        loginCRMPage = testContext.getLoginCRMPage();
    }

    @Given("user has access to the Customer page")
    public void userHasAccessToTheCustomerPage() {
        WebUI.clickElement(CustomersPage.menuCustomers);
        WebUI.waitForElementVisible(CustomersPage.titleCustomers);
    }

    @When("user has finished entering Company {string}, Phone {string}, Website {string} the customer information")
    public void userHasFinishedEnteringCompanyPhoneWebsiteTheCustomerInformation(String company, String phone, String website) {
        customersPage = new CustomersPage();
        customersPage.addCustomerSuccess(company,phone,website);
    }

    @And("user click on the Save button")
    public void userClickOnTheSaveButton() {
        customersPage = new CustomersPage();
        WebUI.scrollToElement(customersPage.buttonSave);
        WebUI.clickElement(customersPage.buttonSave);
        WebUI.waitForElementVisible(customersPage.messageAddCustomerSuccess);
    }

    @Then("A new customer with phone {string}, website {string} would be displayed")
    public void aNewCustomerWouldBeDisplayed(String phone, String website) {
        customersPage = new CustomersPage();
        customersPage.verifyNewCustomer(phone, website);
    }

    @When("user search for a new customer")
    public void userSearchForCustomer() {
        WebUI.setText(searchCustomer, companyName);
    }

    @And("user click on Delete button at a new company")
    public void userClickOnDeleteButton() {
        customersPage = new CustomersPage();
        customersPage.deleteCustomer(companyName);
    }

    @And("user click on OK")
    public void userClickOnOK() {
        WebUI.sleep(2);
        DriverManager.getDriver().switchTo().alert().accept();
    }

    @Then("delete message be displayed")
    public void deleteMessageBeDisplayed() {
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//span[normalize-space()='Customer deleted']"), "Delete customer is failed");

    }

    @When("user entes  invalid credentials to add customers")
    public void userEntesInvalidCredentialsToAddCustomers(DataTable dataTable) {
        List < Map < String, String >> items = dataTable.asMaps();

        for (Map < String, String > item: items){
            String company = item.get("Company");
            String VATNumber = item.get("VAT Number");
            String phone = item.get("Phone");
            String website = item.get("Website");
            String group = item.get("Groups");
            String currency = item.get("Currency");
            String defaultLanguage = item.get("Default Language");
            String address = item.get("Address");
            String city = item.get("City");
            String state = item.get("State");
            String zipCode = item.get("ZipCode");
            String country = item.get("Country");

            WebUI.clickElement(CustomersPage.menuCustomers);
            WebUI.waitForElementVisible(CustomersPage.titleCustomers);
            WebUI.clickElement(CustomersPage.buttonNewCustomers);
            WebUI.setTextEnter(CustomersPage.inputCompany, company);
            WebUI.sleep(5);
            WebUI.setTextEnter(CustomersPage.VATNumber,VATNumber);
            WebUI.sleep(5);
//            WebUI.setTextEnter(inputWebsite,website);
//            companyName = DriverManager.getDriver().findElement(By.xpath("//input[@id='company']")).getAttribute("value");
//            System.out.println(companyName);
        }
    }
}