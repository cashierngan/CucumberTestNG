package nganxd.stepdifinitions;

import nganxd.hooks.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nganxd.drivers.DriverManager;
import nganxd.util.WebUI;
import org.openqa.selenium.By;
import nganxd.pages.CustomersPage;
import nganxd.pages.LoginCRMPage;

import static nganxd.pages.CustomersPage.companyName;
import static nganxd.pages.CustomersPage.searchCustomer;

public class StepCustomers {
    TestContext testContext;
    CustomersPage customersPage;
    LoginCRMPage loginCRMPage;

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
}
