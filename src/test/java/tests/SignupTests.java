package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
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
}
