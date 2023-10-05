package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://itbootcamp.rs/");


        List<WebElement> menu = driver.findElements(By.xpath("//*[@id='menu-item-6408']/a"));
        List<WebElement> lists = driver.findElements(By.xpath("//*[@id='menu-item-6408']/ul"));

        for (int i = 0; i < 3; i++) {
            new Actions(driver)
                    .moveToElement(menu.get(i))
                    .perform();
            wait
                    .until(ExpectedConditions.visibilityOf(lists.get(i)));


            Thread.sleep(2000);
        }

    }
}
