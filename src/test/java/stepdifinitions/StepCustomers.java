package stepdifinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ngan.xd.driver.DriverManager;
import ngan.xd.utils.WebUI;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import pages.CustomersPage;
import pages.LoginCRMPage;

import java.util.Random;

import static pages.CustomersPage.companyName;

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
        WebUI.scrollToElement(customersPage.buttonSave);
        WebUI.clickElement(customersPage.buttonSave);
        WebUI.waitForElementVisible(customersPage.messageAddCustomerSuccess);
    }


    @Given("user logged in the CRM system with {string} role")
    public void userLoggedInTheCRMSystemWithRole(String arg0) {
        loginCRMPage = new LoginCRMPage();
        loginCRMPage.login("admin@example.com", "123456");
    }


    @Then("A new customer with phone {string}, website {string} would be displayed")
    public void aNewCustomerWouldBeDisplayed(String phone, String website) {
        customersPage = new CustomersPage();
        customersPage.verifyNewCustomer(phone, website);
    }

    @When("user search for a new customer")
    public void userSearchForCustomer() {
        System.out.println("____________________________________________________________________");
        System.out.println("____________________________________________________________________");
        System.out.println(companyName);
        WebUI.setText(By.xpath("//input[@class='form-control input-sm']"), companyName);
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
