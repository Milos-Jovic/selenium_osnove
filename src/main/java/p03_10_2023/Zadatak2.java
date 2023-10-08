package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Zadatak2 {

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
    }


    @Test
    public void checkInputTypes(){

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[3]/a")).click();

      WebElement text = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertEquals(text.getAttribute("type"), "text", "should be text");

        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        Assert.assertEquals(pass.getAttribute("type"), "password", "should be password");

        WebElement box = driver.findElement(By.xpath("//input[@id='rememberme']"));
        Assert.assertEquals(box.getAttribute("type"), "checkbox", "should be checkbox");


        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='rememberme']")).isSelected());


    }

    @AfterClass
    private void displayErrorWhenCredentialsAreWrong(){

        driver.findElement(By.xpath("/input[@id='username']")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.xpath("/input[@id='password']")).sendKeys("invalidemail@gmail.com");



    }






}
