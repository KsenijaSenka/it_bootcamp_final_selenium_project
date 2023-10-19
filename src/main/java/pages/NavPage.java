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

    public WebElement getEnLanguageFromDropdown() {
        return driver.findElement(By.className("btnEN"));
    }
    public void clickEnLanguageFromDropdown() {
        getEnLanguageFromDropdown().click();
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

    public void getLogoutButton() {
        wait.withMessage("Logout button is invisible.")
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".btnLogout"))));
    }

    public void clickLogout() {
        getLogoutButton();
        driver.findElement(By.cssSelector(".btnLogout")).click();
    }
    public WebElement getSignupLink(){
        return driver.findElement(By.cssSelector("a[href='/signup']"));
    }
    public void clickSignupButton(){
        getSignupLink().click();
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }
    public void clickAdminButton() {
        getAdminButton().click();
    }
    public WebElement getCitiesButton(){
        return driver.findElement(By.className("btnAdminCities"));
    }
    public void clickCitiesButton() {
        getCitiesButton().click();
    }

    public void getHomepage() {
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/home");
    }
    public void getProfilePage() {
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/profile");
    }
    public void getAdminCitiesPage(){
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/admin/cities");
    }
    public void getAdminUsersPage(){
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/admin/users");
    }
    public WebElement getEsLanguageFromDropdown() {
        return driver.findElement(By.className("btnES"));
    }
    public void clickEsLanguageFromDropdown() {
        getEsLanguageFromDropdown().click();
    }
    public String getHeaderText() {
        return driver.findElement(By.xpath("//*[@id='app']//h1")).getText();
    }
    public WebElement getCnLanguageFromDropdown() {
        return driver.findElement(By.className("btnCN"));
    }
    public void clickCnLanguageFromDropdown() {
        getCnLanguageFromDropdown().click();
    }
}
