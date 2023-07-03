package nganxd.hooks;

import nganxd.drivers.DriverFactory;
import nganxd.drivers.DriverManager;
import nganxd.pages.*;
import nganxd.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
//import pages.*;

public class TestContext {
    private WebDriver driver;
    private CommonPage commonPage;
    private LoginPage loginPage;
    private LoginCRMPage loginCRMPage;
    private LoginCMSPage loginCMSPage;
    private CategoriesPage categoryPage;
    private CustomersPage customersPage;


    public TestContext() {
        ThreadGuard.protect(new DriverFactory().createDriver());
        Log.info("Driver in TestContext: " + getDriver());
    }

    public CommonPage getCommonPage() {
        if (commonPage == null) {
            commonPage = new CommonPage();
        }
        return commonPage;
    }

    public LoginCRMPage getLoginCRMPage() {
        if (loginCRMPage == null) {
            loginCRMPage = new LoginCRMPage();
        }
        return loginCRMPage;
    }
    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public LoginCMSPage getLoginCMSPage() {
        if (loginCMSPage == null) {
            loginCMSPage = new LoginCMSPage();
        }
        return loginCMSPage;
    }

    public CategoriesPage getCategoryPage() {
        if (categoryPage == null) {
            categoryPage = new CategoriesPage();
        }
        return categoryPage;
    }

    public CustomersPage getCustomersPage() {
        if (customersPage == null) {
            customersPage = new CustomersPage();
        }
        return customersPage;
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}
