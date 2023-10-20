package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage {
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

    public void clickToSaveCity() {
        driver.findElement(By.className("btnSave")).click();
    }

    public void waitCreateEditDialog() {
        wait
                .withMessage("Create and Edit Dialogue is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class, 'dlgNewEditItem')]")));
    }

    public void waitForSuccessDialog() {
        wait
                .withMessage("Save Dialogue is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class, 'success')]")));
    }

    public String getMessageFromSuccessPopUpText() {
        return driver.findElement(By.xpath(
                "//div[contains(@class, 'success')]")).getText();
    }

    public WebElement getSearchInput() {
        return driver.findElement(By.id("search"));
    }

    public void clearAndEnterCityInSearchInput(String city) {
        getSearchInput().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        getSearchInput().sendKeys(city);
    }

    public void waitForNumberOfRows(int rowsNo) {
        wait.until(ExpectedConditions.numberOfElementsToBe
                (By.xpath("//div[@class='v-data-table__wrapper']//tbody/tr"), rowsNo));
    }

    public void clickEditButtonForRow(int rowsNo) {
        driver.findElement(By.xpath("//tr[" + rowsNo + "]/td[1]/div/button[@id='edit']")).click();
    }

    public void clearAndEnterCityOfCurrentUser(String city) {
        getCityInput().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        getCityInput().sendKeys(city);
    }
    public String getCityNameText(){
        return driver.findElement(By.xpath("//*[@id='app']//tr[1]/td[2]")).getText();
    }

    public void clickDeleteButtonForRow(int rowsNo) {
        driver.findElement(By.xpath("//tr[" + rowsNo  + "]/td[1]/div/button[@id='delete']")).click();
    }
    public void waitDeleteDialogueVisibility(){
         wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'v-dialog')]//header[contains(@class, 'warning')]")));
    }
    public WebElement getCell(int row, int column){
        return driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td["+column+"]"));
    }
    public String getCellText(int row, int column){
        return getCell(row, column).getText();
    }
    public WebElement getDeleteButtonFromDialogue() {
        return driver.findElement(By.xpath("//*[@id='app']//div[2]/button[2]"));
    }
    public void clickDeleteButtonFromDialogue(){
        getDeleteButtonFromDialogue().click();
    }
}
