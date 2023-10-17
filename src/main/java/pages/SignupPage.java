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
    public WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }
    public void enterName(String name){
        getNameInput().sendKeys(name);
    }
    public WebElement getSignMeUpButton(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
    public void enterConfirmedPassword(String password){
        getConfirmPasswordInput().sendKeys(password);
    }
    public void clickSignMeUpButton(){
        getSignMeUpButton().click();
    }
}
