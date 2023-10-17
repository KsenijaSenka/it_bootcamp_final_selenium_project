package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class SignupTests extends BasicTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage() {
        navPage.clickSignupButton();
        wait
                .withMessage("Url doesn't contain text: signup.")
                .until(ExpectedConditions.urlContains("/signup"));
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        String emailType = "email";
        String passwordType = "password";

        navPage.clickSignupButton();
        Assert.assertEquals(loginPage.getEmailInputAttribute("type"),
                emailType, "Attribute type should be email.");
        Assert.assertEquals(loginPage.getPasswordInputAttribute("type"),
                passwordType, "Attribute type should be password.");
        Assert.assertEquals(signupPage.getConfirmPasswordInputAttribute("type"),
                passwordType, "Attribute type password should be the type for Confirm Password Input.");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserAlreadyExists (){
        String name= "Another User";
        String email= "admin@admin.com";
        String password= "12345";
        String confirmPassword ="12345";

        navPage.clickSignupButton();
        wait
                .withMessage("Url doesn't contain text: signup.")
                .until(ExpectedConditions.urlContains("/signup"));
        signupPage.enterName(name);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        signupPage.enterConfirmedPassword(confirmPassword);
        signupPage.clickSignMeUpButton();

        wait
                .withMessage("Error message is invisible.")
                .until(ExpectedConditions.visibilityOf(messagePopUpPage.getStatusPopUp()));
        Assert.assertEquals(messagePopUpPage.getStatusErrorMessage(),
                "E-mail already exists",
                "Error message for non-existing email address is incorrect");
        wait
                .withMessage("Url doesn't contain text: signup.")
                .until(ExpectedConditions.urlContains("/signup"));
    }

}
