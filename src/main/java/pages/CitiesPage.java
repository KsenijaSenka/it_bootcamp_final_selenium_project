package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.xpath("//div[@class='text-right']/button"));
    }

    public void clickNewItemButton() {
        getNewItemButton().click();
    }

    public WebElement getCityInput() {
        return driver.findElement(By.id("name"));
    }

    public String getCityInputAttribute(String cityAttribute) {
        return getCityInput().getAttribute(cityAttribute);
    }

    public void enterCityOfCurrentUser(String city) {
        getCityInput().sendKeys(city);
    }
    public void clickToSaveCity(){
        driver.findElement(By.className("btnSave")).click();
    }
    public void waitCreateEditDialog(){
        wait
                .withMessage("Create and Edit Dialogue is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class, 'dlgNewEditItem')]")));
    }
    public void waitForSucessDialog(){
        wait
                .withMessage("Save Dialogue is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'success')]")));
    }
    public String getMessageFromSuccessPopUpText() {
        return driver.findElement(By.xpath(
                "//div[contains(@class, 'success')]")).getText();
    }
}
