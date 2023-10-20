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

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void createNewCity() {
        String city = "Ksenija Beocanin's city";

        navPage.clickAdminButton();
        navPage.clickCitiesButton();
        citiesPage.clickNewItemButton();

        citiesPage.waitCreateEditDialog();
        citiesPage.enterCityOfCurrentUser(city);
        citiesPage.clickToSaveCity();
        citiesPage.waitForSuccessDialog();
        Assert.assertTrue(citiesPage.getMessageFromSuccessPopUpText()
                .contains("Saved successfully"), "Message is incorrect");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void editCity() {
        String oldCityName = "Ksenija Beocanin's city";
        String newCityName = "Ksenija Beocanin's city Edited";
        int rowsNo = 1;

        navPage.clickAdminButton();
        navPage.clickCitiesButton();
        citiesPage.clearAndEnterCityInSearchInput(oldCityName);

        citiesPage.waitForNumberOfRows(rowsNo);
        citiesPage.clickEditButtonForRow(rowsNo);

        citiesPage.getCityInput().clear();
        citiesPage.getCityInput().sendKeys(newCityName);
        citiesPage.clearAndEnterCityOfCurrentUser(newCityName);
        citiesPage.clickToSaveCity();

        citiesPage.waitForSuccessDialog();
        Assert.assertTrue(citiesPage.getMessageFromSuccessPopUpText()
                .contains("Saved successfully"), "Message is incorrect");
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void searchCity() {
        String cityName = "Ksenija Beocanin's city Edited";
        int rowsNo = 1;

        navPage.clickAdminButton();
        navPage.clickCitiesButton();
        citiesPage.clearAndEnterCityInSearchInput(cityName);
        citiesPage.waitForNumberOfRows(rowsNo);

        Assert.assertEquals(citiesPage.getCityNameText(), cityName,
                "The name of the city in the top row should be equal to searched city name.");
    }

    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void deleteCity() {
        String cityName = "Ksenija Beocanin's city Edited";
        int rowsNo = 1;

        navPage.clickAdminButton();
        navPage.clickCitiesButton();
        citiesPage.clearAndEnterCityInSearchInput(cityName);
        citiesPage.waitForNumberOfRows(rowsNo);

        Assert.assertEquals(citiesPage.getCityNameText(), cityName,
                "The name of the city in the top row should be equal to searched city name.");

        citiesPage.clickDeleteButtonForRow(rowsNo);
        citiesPage.waitDeleteDialogueVisibility();
        citiesPage.clickDeleteButtonFromDialogue();

        citiesPage.waitForSuccessDialog();
        Assert.assertTrue(citiesPage.getMessageFromSuccessPopUpText()
                .contains("Deleted successfully"), "Message is incorrect");
    }
}
