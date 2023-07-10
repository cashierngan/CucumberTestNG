package nganxd.pages;

import nganxd.drivers.DriverManager;
import nganxd.utils.WebUI;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

public class CustomersPage {
    public static By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public static By titleCustomers = By.xpath("//span[normalize-space()='Customers Summary']");
    public static By buttonNewCustomers = By.xpath("//a[normalize-space()='New Customer']");
    public static By inputCompany = By.xpath("//input[@id='company']");
    public static By inputPhone = By.xpath("//input[@id='phonenumber']");
    public static By inputWebsite = By.xpath("//input[@id='website']");
    public static By buttonSave = By.xpath("//button[@class='btn btn-primary only-save customer-form-submiter']");
    public static By messageAddCustomerSuccess = By.xpath("//div[normalize-space()='×Customer added successfully.']");
    private static By inputSearchCustomer = By.xpath("//input[@id='search_input']");
    private By profileScreen = By.xpath("//h4[normalize-space()='Profile']");
    public static By searchCustomer = By.xpath("//input[@class='form-control input-sm']");
    public static String companyName;
    public static By VATNumber = By.xpath("//input[@id='vat']");
    public static By selectGroup = By.xpath("//button[@aria-owns= 'bs-select-1']");
    public static By inputGroup = By.xpath("//input[@type = 'search' and @aria-controls = 'bs-select-1']");
    public static By inputVAT = By.xpath("//input[@id='vat']");
    public static By selectCurrency = By.xpath("//button[@aria-owns= 'bs-select-2']");
    public static By inputCurrency = By.xpath("(//input[@aria-label='Search'])[2]");
    public static By selectLanguage = By.xpath("//button[@aria-owns= 'bs-select-3']");
    public static By inputAddress = By.xpath("//textarea[@id='address']");
    public static By inputCity = By.xpath("//input[@id='city']");
    public static By inputState = By.xpath("//input[@id='state']");
    public static By inputZip = By.xpath("//input[@id='zip']");
    public static By selectCountry = By.xpath("//button[@aria-owns= 'bs-select-4']");
    public static By inputCountry = By.xpath("(//input[@aria-label='Search'])[3]");
    public static By buttonViewCustomer = By.xpath("(//a[contains(text(),'View')])[1]");
    public static By messageEditCustomerSucess = By.xpath("//span[normalize-space()='Customer updated successfully.']");
    public static By hoverCompanySearch = By.xpath("//td[@class='sorting_1']");
    public static By messageValidCompany = By.xpath("//p[@id='company-error' and text()= 'This field is required.']");





    public void addCustomerSuccess(String company, String phone, String website){
        String randomString = RandomStringUtils.randomAlphabetic(7);
//        WebUI.clickElement(buttonNewCustomers);
        WebUI.setTextEnter(inputCompany,company + " " + randomString);
        WebUI.setTextEnter(inputPhone,phone);
        WebUI.setTextEnter(inputWebsite,website);
        companyName = DriverManager.getDriver().findElement(By.xpath("//input[@id='company']")).getAttribute("value");
    }


    public void verifyNewCustomer(String phone, String website){
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//span[contains(text(),'" + companyName + "')]"), "Customer is NOT displayed");
        WebUI.verifyAssertTrueIsDisplayed(profileScreen, "Profile screen is not displayed");
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//input[@value='" + companyName + "']"), "Failed to display the customer name");
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//input[@value='" + phone + "']"), "Failed to display the phone");
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//input[@value='" + website + "']"), "Failed to display the phone");
    }

    public void deleteCustomer(String company){
//        WebUI.sleep(4);
        System.out.println(companyName);
        WebUI.waitForElementVisible(By.xpath("//tr[@class='has-row-options odd']//a[contains(text(),'" + company + "')]"));
        WebUI.hoverElement(By.xpath("//tr[@class='has-row-options odd']//a[contains(text(),'" + company + "')]"));
        WebUI.clickElement(By.xpath("//tr[@class='has-row-options odd']//a[@class='text-danger _delete'][normalize-space()='Delete']"));
    }

}
