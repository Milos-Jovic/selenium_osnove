package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Zadatk3 {
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
        driver.navigate().to("https://cms.demo.katalon.com/");
        driver.findElement(By.xpath("/input[@id='username']")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.xpath("/input[@id='password']")).sendKeys("invalid123");

    }
    @Test
    private void displayErrorWhenCredentialsAreWrong(){

        driver.get("https://cms.demo.katalon.com/");



    }


}
