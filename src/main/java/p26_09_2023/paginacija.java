package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class zadatak {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://s.bootsnipp.com/iframe/oV91g");
        driver.manage().window().maximize();



        List<WebElement> link = driver.findElements(By.cssSelector("ul.pagination a.page_link"));



        for (int i = 0; i <link.size(); i++) {
            link.get(i).click();
            Thread.sleep(1000);
        }
        driver.quit();
    }



}
