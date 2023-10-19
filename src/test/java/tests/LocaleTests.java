package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LocaleTests extends BasicTest{
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToES() {
        navPage.clickOnLanguagesButton();
        navPage.clickEsLanguageFromDropdown();
        Assert.assertEquals(navPage.getHeaderText(), "Página de aterrizaje",
                "Header text should be Página de aterrizaje");
    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEN() {
        navPage.clickOnLanguagesButton();
        navPage.clickEnLanguageFromDropdown();
        Assert.assertEquals(navPage.getHeaderText(), "Landing",
                "Header text should be Landing");
    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToCN() {
        navPage.clickOnLanguagesButton();
        navPage.clickCnLanguageFromDropdown();
        Assert.assertEquals(navPage.getHeaderText(), "首页",
                "Header text should be 首页");
    }
}
