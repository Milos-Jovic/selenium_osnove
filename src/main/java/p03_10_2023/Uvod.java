package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Uvod {

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforMethod() {
        driver.navigate().to("https://google.com");
    }

    @Test
    public void googleTitleTest() {
        Assert.assertEquals(driver.getTitle(), "Google", "Home page title should be google");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");


        WebElement searchInput = driver.findElement(By.name("q"));

        searchInput.sendKeys("it bootcamp");
        searchInput.sendKeys(Keys.ENTER);


        wait.until(ExpectedConditions.titleContains("it bootcamp"));



    }
    @Test
    public void googleSearchTest() {
        driver
                .findElement(By.name("qjksdjksdkj"))
                .sendKeys("IT Bootcamp");
        driver.navigate().to("https://youtube.com");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
