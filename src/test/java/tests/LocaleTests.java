package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LocaleTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToES() {
        navPage.clickOnLanguagesButton();
        navPage.clickEsLanguageFromDropdown();
        Assert.assertEquals(navPage.getHeaderText(), "Página de aterrizaje",
                "Header text should be Página de aterrizaje");
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEN() {
        navPage.clickOnLanguagesButton();
        navPage.clickEnLanguageFromDropdown();
        Assert.assertEquals(navPage.getHeaderText(), "Landing",
                "Header text should be Landing");
    }
}
