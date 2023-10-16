package tests;

import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest{

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheLoginPage(){
        navPage.clickOnLanguagesButton();
        navPage.clickEnLanguageFromDropdown();
        navPage.clickOnLoginButton();
        navPage.checkUrl();
    }
}
