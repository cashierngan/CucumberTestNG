package nganxd.pages;

import nganxd.common.BaseTest;
import nganxd.helpers.PropertiesHelper;
import nganxd.utils.WebUI;
import org.openqa.selenium.By;

//import static nganxd.utils.WebUI.openURL;
//import static nganxd.utils.WebUI.verifyAssertTrueIsDisplayed;

public class LoginCMSPage extends CommonPage{
    static {
        PropertiesHelper.loadAllFiles();
    }

    //Khai báo Objects
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By messageAlert = By.xpath("//div[@role='alert']");
    private String URL = "https://cms.anhtester.com/login";
    private By labelLogin = By.xpath("//p[normalize-space()='Login to your account.']");

    public void openLoginPage(){
        WebUI.openURL(URL);
        WebUI.verifyAssertTrueIsDisplayed(labelLogin, "Login page is NOT displayed");
    }

    public void verifyRedirectLoginPage(){
        WebUI.verifyAssertTrueIsDisplayed(avtProfile, "Can NOT redirect to AdminPage");
    }

    //Hàm xử lý đặc trưng cho Login Page
    public void enterEmailAndPassword(String email, String password) {
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
    }

    public void clickLoginButton() {
        WebUI.clickElement(buttonLogin);
    }

    public CommonPage loginAdminRole() {
        BaseTest.createDriver("chrome");
        WebUI.openURL(PropertiesHelper.getValue("URL_ADMIN"));
        WebUI.setText(inputEmail, PropertiesHelper.getValue("EMAIL"));
        WebUI.setText(inputPassword, PropertiesHelper.getValue("PASSWORD"));
        clickLoginButton();
        return new CommonPage();
    }

    public CommonPage loginProjectRole() {
        WebUI.openURL(PropertiesHelper.getValue("URL"));
        WebUI.setText(inputEmail, PropertiesHelper.getValue("EMAIL"));
        WebUI.setText(inputPassword, PropertiesHelper.getValue("PASSWORD"));
        clickLoginButton();
        return new CommonPage();
    }
}
