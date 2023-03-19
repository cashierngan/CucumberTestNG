package stepdifinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ngan.xd.driver.DriverManager;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;
import pages.CustomersPage;
import pages.LoginCRMPage;

public class StepCustomers {
    public CustomersPage customersPage;
    public LoginCRMPage loginCRMPage;
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
        WebUI.clickElement(customersPage.buttonSave);
        WebUI.waitForElementVisible(customersPage.messageAddCustomerSuccess);
    }


    @Given("user logged in the CRM system with {string} role")
    public void userLoggedInTheCRMSystemWithRole(String arg0) {
        loginCRMPage = new LoginCRMPage();
        loginCRMPage.login("admin@example.com", "123456");
    }


    @Then("A new customer {string}, phone {string}, website {string} would be displayed")
    public void aNewCustomerWouldBeDisplayed(String company, String phone, String website) {
        customersPage = new CustomersPage();
        customersPage.verifyNewCustomer(company, phone, website);
    }

    @When("user search for customer {string}")
    public void userSearchForCustomer(String company) {
        WebUI.setText(By.xpath("//input[@class='form-control input-sm']"), company);
    }

    @And("user click on Delete button at company {string}")
    public void userClickOnDeleteButton(String company) {
        customersPage = new CustomersPage();
        customersPage.deleteCustomer(company);
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
