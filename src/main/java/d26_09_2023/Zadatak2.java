package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");
        Thread.sleep(1000);

        List<WebElement> x = driver.findElements(By.xpath("//button[@type='button']"));

        for (int i = 0; i <x.size() ; i++) {
            int list = x.size();
            System.out.println(list);
            x.get(i).click();
            x = driver.findElements(By.xpath("//button[@type='button']"));
            Thread.sleep(1000);
            }

        }

    }
d