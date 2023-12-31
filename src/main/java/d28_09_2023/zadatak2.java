package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


        List<WebElement> button = driver.findElements(By.xpath("//button[contains(@id,'basic')]"));
        List<WebElement>toasts = driver.findElements(By.cssSelector("div.toast[id*='basic'] "));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        for (int i = 0; i < button.size(); i++) {
            button.get(i).click();
            wait.until(ExpectedConditions.visibilityOf(toasts.get(i)));

            Thread.sleep(1000);
        }


        driver.quit();
    }
}
