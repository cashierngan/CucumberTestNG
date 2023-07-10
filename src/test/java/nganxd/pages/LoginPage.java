package nganxd.pages;

import nganxd.helpers.PropertiesHelper;
import nganxd.utils.WebUI;
import org.openqa.selenium.By;

public class LoginPage {
    //Khai báo Objects
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By messageAlert = By.xpath("//div[@class='text-center alert alert-danger']");


    //Hàm xử lý đặc trưng cho Login Page
    public void enterEmailAndPassword(String email, String password) {
        WebUI.openURL(PropertiesHelper.getValue("URL"));
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
    }

    public void clickLoginButton() {
        WebUI.clickElement(buttonLogin);
    }
}
