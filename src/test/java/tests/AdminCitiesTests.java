package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListCities() {
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

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypesForCreateEditNewCity() {
        navPage.clickAdminButton();
        navPage.clickCitiesButton();
        citiesPage.clickNewItemButton();

        wait
                .withMessage("Create and Edit Dialogue is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class, 'dlgNewEditItem')]")));

        Assert.assertEquals(citiesPage.getCityInputAttribute("type"),
                "text", "Attribute type should be text.");
    }
}
