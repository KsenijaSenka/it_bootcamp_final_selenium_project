package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListCities(){
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";

        navPage.clickOnLoginButton();
        loginPage.enterEmail(adminEmail);
        loginPage.enterPassword(adminPassword);
        loginPage.clickLoginButton();
        navPage.clickAdminButton();
        navPage.clickCitiesButton();

        wait
                .withMessage("Url doesn't contain text: /admin/cities.")
                .until(ExpectedConditions.urlToBe(baseUrl + "/admin/cities"));
    }
}
