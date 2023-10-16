package tests;

import Helper.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.NavPage;

import java.io.IOException;
import java.time.Duration;

public abstract class BasicTest {
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected NavPage navPage;
    protected LoginPage loginPage;
    @BeforeClass
    public void BeforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        navPage=new NavPage(driver,wait);
        loginPage=new LoginPage(driver,wait);
    }
    @BeforeMethod
    public void setup() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseUrl);
    }
    @AfterMethod
    public void afterMethod(ITestResult testResult) throws NullPointerException, IOException {
        //js.executeScript("window.localStorage.clear();");
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Helper.captureScreenshot(driver, "screenshots/" + testResult.getName() + ".jpg");
        }
    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }
}