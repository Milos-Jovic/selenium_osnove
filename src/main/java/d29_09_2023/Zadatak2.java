package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://docs.katalon.com/");


        wait.until(ExpectedConditions.attributeToBe(By.tagName("html"),"data-theme", "light"));
        System.out.println("light");
        driver.findElement(By.cssSelector(".toggleButton_rCf9")).click();
        wait.until(ExpectedConditions.attributeToBe(By.tagName("html"),"data-theme", "dark"));
        System.out.println("dark");

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("k")
                .keyUp(Keys.CONTROL).perform();

        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".DocSearch-Input"),"type", "search"));
        System.out.println("input");

        driver.quit();
    }
}
