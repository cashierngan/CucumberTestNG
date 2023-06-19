package nganxd.stepdifinitions;

import nganxd.common.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nganxd.pages.CommonPage;
import nganxd.pages.LoginCMSPage;

public class StepCategory {
    LoginCMSPage loginCMSPage;
    CommonPage commonPage;

    @Given("user logged in the CMS system with {string} role")
    public void userLoggedInTheCMSSystemWithRole(String arg0) {
        loginCMSPage = new LoginCMSPage();
        commonPage = loginCMSPage.loginAdminRole();
    }

    @Given("user has access to the Category page")
    public void userHasAccessToTheCategoryPage() {
        commonPage.clickMenuProduct();
        commonPage.openCategoryPage();
    }

    @When("user has finished entering the category information")
    public void userHasFinishedEnteringTheCategoryInformation(DataTable dataTable) {
        //Đọc data từ excel
        //Đọc data từ Datatable
    }

    @And("click the Save button")
    public void clickTheSaveButton() {
    }

    @Then("the message {string} successfully displays")
    public void theMessageSuccessfullyDisplays(String message) {
        BaseTest.closeDriver();
    }
}
