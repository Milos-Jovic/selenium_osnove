package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        for (int i = 0; i <5 ; i++) {

            driver.findElement(By.cssSelector("button.add-new")).click();
            WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
            name.sendKeys("Milos");
            WebElement department = driver.findElement(By.cssSelector("input[name='department']"));
            department.sendKeys("Quality assurance");
            WebElement phone = driver.findElement(By.cssSelector("input[name='phone']"));
            phone.sendKeys("123/456-789");
            driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]/a[@class='add']")).click();
            Thread.sleep(500);

        }
            driver.quit();
    }
}
