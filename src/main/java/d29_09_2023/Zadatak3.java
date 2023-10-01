package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.findElement(By.xpath("//div[@class='container text-center']/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='container text-center']/button[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='container text-center']/button[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='container text-center']/button[4]")).click();
        Thread.sleep(2000);

        boolean provera = true;
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='basic-success-example']"),4));
            provera = true;
        } catch (Exception e){

        }

        if (provera){
            System.out.println("toast se prikazao");
        }


        boolean vidljivost = true;

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("//*[@id='basic-success-example']")));
            vidljivost = true;
        } catch (Exception e){

        }

        if (vidljivost){
            System.out.println("toasts su se izgubili");
        }

        driver.quit();
    }
}
