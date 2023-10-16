package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
     public WebElement getStatusPopUp(){
        return driver.findElement(By.cssSelector("div.v-snack__content"));
    }
    public String getStatusErrorMessage(){
        return driver.findElement(By.cssSelector("*[role='status'] li")).getText();
    }
}
