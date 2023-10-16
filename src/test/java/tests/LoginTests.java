package tests;
import org.testng.Assert;
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
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        String emailType="email";
        String passwordType="password";
        navPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getEmailInputAttribute("type"),
                emailType, "Attribute type should be email.");
        Assert.assertEquals(loginPage.getPasswordInputAttribute("type"),
                passwordType, "Attribute type should be password.");
    }
}