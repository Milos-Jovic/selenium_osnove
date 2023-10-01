package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com/?post_type=product");

        driver.findElement(By.cssSelector("li.nav__search > a")).click();
        WebElement search = driver.findElement(By.cssSelector(".mobile-navbar__wrapper input[title = 'Search …']"));
        wait.until(ExpectedConditions.visibilityOf(search));
        search.sendKeys("BDD Cucumber");
        Thread.sleep(1000);
        search.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("article:first-child .czr-title")));
        System.out.println("text");

        driver.quit();
    }


}
