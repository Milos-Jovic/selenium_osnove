package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class Zadatak4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tus.io/demo.html");


        driver.findElement(By.linkText("tus-js-client"));
        driver.findElement(By.linkText("tusd"));
        driver.findElement(By.linkText("Go programming language"));
        driver.findElement(By.xpath("/html/body/main/p[4]/a"));
        driver.findElement(By.linkText("GitHub"));
        driver.findElement(By.linkText("forum"));
        driver.findElement(By.linkText("Twitter"));

        new Actions(driver).scrollToElement(driver.findElement(By.id("instructions")));
        String text1 = "instructions";
        System.out.println(text1);
        new Actions(driver).scrollToElement(driver.findElement(By.id("http-traffic")));
        String text2 = "http-traffic";
        System.out.println(text2);
        new Actions(driver).scrollToElement(driver.findElement(By.id("compatibility")));
        String text3 = "compatibility";
        System.out.println(text3);
        new Actions(driver).scrollToElement(driver.findElement(By.id("source-code")));
        String text4 = "source-code";
        System.out.println(text4);


        driver.quit();
    }
}
