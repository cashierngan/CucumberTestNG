package pages;

import ngan.xd.helpers.PropertiesHelpers;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;

public class LoginCRMPage {
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    public void login(String username, String password){
        WebUI.openURL(PropertiesHelpers.getValue("URL"));
        WebUI.setText(inputEmail, username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(By.xpath("//button[normalize-space() = 'Login']"));
    }
}
