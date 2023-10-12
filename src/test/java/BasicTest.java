import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.DeleteDialogPage;
import pages.TabelPage;
import pages.UpdateDialogPage;

import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://s.bootsnipp.com/iframe/K5yrx ";

    protected TabelPage tabelPage;
    protected UpdateDialogPage updateDialogPage;

    protected DeleteDialogPage deleteDialogPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        tabelPage = new TabelPage(driver, wait);
        updateDialogPage = new UpdateDialogPage(driver, wait);
        deleteDialogPage = new DeleteDialogPage(driver, wait);

    }

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(baseUrl);
    }

    @AfterMethod
    public void afterMethod() {

        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}