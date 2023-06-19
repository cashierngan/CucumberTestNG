package nganxd.common;

import io.cucumber.java.en.And;

public class CommonStepDefinitations {
    @And("I should see the notification displays")
    public void iShouldSeeTheNotificationDisplays() {
        BaseTest.closeDriver();
    }
}
