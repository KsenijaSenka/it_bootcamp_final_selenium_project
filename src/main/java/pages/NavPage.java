package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getLanguagesButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public void clickOnLanguagesButton(){
        getLanguagesButton().click();
    }
    public void clickEnLanguageFromDropdown(){
               driver.findElements(By.xpath("//*[@id='list-item-150']/div"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("a[href='/login']"));
    }
    public void clickOnLoginButton(){
        getLoginButton().click();
    }
    public void checkUrl(){
        wait.until(ExpectedConditions.urlContains("/login"));
        wait.withMessage("Url doesn't contain /login");
    }
}