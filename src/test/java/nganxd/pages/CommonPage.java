package nganxd.pages;

import nganxd.utils.WebUI;
import org.openqa.selenium.By;

public class CommonPage {
    private By menuProduct = By.xpath("//span[normalize-space()='Products']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    public By avtProfile = By.xpath("//span[@class='avatar avatar-sm mr-md-2']");

    public void clickMenuProduct(){
        WebUI.clickElement(menuProduct);
    }

    public CategoriesPage openCategoryPage(){
        WebUI.clickElement(menuCategory);
        return new CategoriesPage();
    }
}
