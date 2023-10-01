package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class zadatak5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com/?product=bdd-cucumber");

        driver.findElement(By.xpath("//a[@title='View your shopping cart']")).click();
        wait.until(ExpectedConditions.titleIs("Cart – Selenium Demo Page"));

        boolean test = true;

        try {
            driver.findElement(By.cssSelector(".cart-empty"));
            test = true;
        } catch (Exception e){
            test = false;
        }

        if(test){
            System.out.println("Empty");
        } else {
            System.out.println("Cart is full");
        }
    }
}
