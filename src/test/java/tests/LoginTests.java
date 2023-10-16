package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
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
        String emailType = "email";
        String passwordType = "password";
        navPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getEmailInputAttribute("type"),
                emailType, "Attribute type should be email.");
        Assert.assertEquals(loginPage.getPasswordInputAttribute("type"),
                passwordType, "Attribute type should be password.");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist() {
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.clickOnLoginButton();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        wait
                .withMessage("Error message is invisible.")
                .until(ExpectedConditions.visibilityOf(messagePopUpPage.getStatusPopUp()));

        Assert.assertEquals(messagePopUpPage.getStatusErrorMessage(),
                "User does not exists",
                "Error message is incorrect");

        navPage.checkUrl();
    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenPasswordIsWrong(){
        String email = "admin@admin.com";
        String password = "password123";

        navPage.clickOnLoginButton();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        wait
                .withMessage("Error message is invisible.")
                .until(ExpectedConditions.visibilityOf(messagePopUpPage.getStatusPopUp()));

        Assert.assertEquals(messagePopUpPage.getStatusErrorMessage(),
                "Wrong password",
                "Error message is incorrect");

        navPage.checkUrl();
    }
}