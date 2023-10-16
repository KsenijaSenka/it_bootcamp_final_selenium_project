package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getConfirmPasswordInput() {
        return driver.findElement(By.id("confirmPassword"));
    }
    public String getConfirmPasswordInputAttribute(String name) {
        return getConfirmPasswordInput().getAttribute(name);
    }
}
