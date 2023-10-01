package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@id='type-options']")).click();
        driver.findElement(By.xpath("// div [@class = 'SelectMenu-list']/label[2] ")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#org-repositories a.issues-reset-query"))).click();

        driver.quit();
    }
}
