package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Zadatak1 {

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
        driver.navigate().to("https://cms.demo.katalon.com");
    }

    @Test
    public void VisitLoginPageFromNavBar(){
        driver.findElement(By.linkText("My account")).click();

        Assert.assertEquals(driver.getTitle(), "Katalon Shop", "Home page title should be Katalon Shop");
        Assert.assertEquals(driver.getCurrentUrl().contains("/my-account"), "https://cms.demo.katalon.com/");




    }
      @AfterClass
    public void AfterClass(){
        driver.quit();
    }


}
