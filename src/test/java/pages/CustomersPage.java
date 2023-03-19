package pages;

import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;

public class CustomersPage {
    public static By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public static By titleCustomers = By.xpath("//span[normalize-space()='Customers Summary']");
    private By buttonNewCustomers = By.xpath("//a[normalize-space()='New Customer']");
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    public static By buttonSave = By.xpath("//button[@class='btn btn-primary only-save customer-form-submiter']");
    public static By messageAddCustomerSuccess = By.xpath("//div[normalize-space()='×Customer added successfully.']");
    private static By inputSearchCustomer = By.xpath("//input[@id='search_input']");
    private By profileScreen = By.xpath("//h4[normalize-space()='Profile']");
    public void addCustomerSuccess(String company, String phone, String website){
        WebUI.clickElement(buttonNewCustomers);
        WebUI.setTextEnter(inputCompany,company);
        WebUI.setTextEnter(inputPhone,phone);
        WebUI.setTextEnter(inputWebsite,website);
    }

    public void verifyNewCustomer(String customer, String phone, String website){
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//span[contains(text(),'" + customer + "')]"), "Customer is NOT displayed");
        WebUI.verifyAssertTrueIsDisplayed(profileScreen, "Profile screen is not displayed");
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//input[@value='" + customer + "']"), "Failed to display the customer name");
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//input[@value='" + phone + "']"), "Failed to display the phone");
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//input[@value='" + website + "']"), "Failed to display the phone");
    }

    public void deleteCustomer(String company){
//        WebUI.sleep(4);
        WebUI.waitForElementVisible(By.xpath("//tr[@class='has-row-options odd']//a[contains(text(),'" + company + "')]"));
        WebUI.hoverElement(By.xpath("//tr[@class='has-row-options odd']//a[contains(text(),'" + company + "')]"));
        WebUI.clickElement(By.xpath("//tr[@class='has-row-options odd']//a[@class='text-danger _delete'][normalize-space()='Delete']"));
    }

}
