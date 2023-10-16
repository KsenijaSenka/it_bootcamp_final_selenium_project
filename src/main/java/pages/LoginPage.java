package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.cssSelector("input#email"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.cssSelector("#password"));
    }

    public String getEmailInputAttribute(String name) {
        return getEmailInput().getAttribute(name);
    }
    public String getPasswordInputAttribute(String name) {
        return getPasswordInput().getAttribute(name);
    }
}
