package pages;

import common.BaseTest;
import ngan.xd.helpers.PropertiesHelpers;
import org.openqa.selenium.By;

import static ngan.xd.utils.WebUI.*;

public class LoginCMSPage {
    static {
        PropertiesHelpers.loadAllFiles();
    }

    //Khai báo Objects
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By messageAlert = By.xpath("//div[@role='alert']");


    //Hàm xử lý đặc trưng cho Login Page
    public void enterEmailAndPassword(String email, String password) {
        setText(inputEmail, email);
        setText(inputPassword, password);
    }

    public void clickLoginButton() {
        clickElement(buttonLogin);
    }

    public CommonPage loginAdminRole() {
        BaseTest.createDriver("chrome");
        openURL(PropertiesHelpers.getValue("URL_ADMIN"));
        setText(inputEmail, PropertiesHelpers.getValue("EMAIL"));
        setText(inputPassword, PropertiesHelpers.getValue("PASSWORD"));
        clickLoginButton();
        return new CommonPage();
    }

    public CommonPage loginProjectRole() {
        openURL(PropertiesHelpers.getValue("URL"));
        setText(inputEmail, PropertiesHelpers.getValue("EMAIL"));
        setText(inputPassword, PropertiesHelpers.getValue("PASSWORD"));
        clickLoginButton();
        return new CommonPage();
    }
}
