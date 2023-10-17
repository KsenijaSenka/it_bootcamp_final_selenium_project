package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
public WebElement getNewItemButton(){
     return driver.findElement(By.xpath("//div[@class='text-right']/button"));
}
public void clickNewItemButton(){
        getNewItemButton().click();
}
    public WebElement getCityInput() {
        return driver.findElement(By.id("name"));
    }

    public String getCityInputAttribute(String cityAttribute) {
        return getCityInput().getAttribute(cityAttribute);
    }
//public WebElement getCreateEditDialogue(){
//        return driver.findElement(By.xpath("//*[@id='app']/div[5]/div"));
//}
}
