package d02_10_2023;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import p02_10_2023.Helper;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;
public class Zadatak4 {
    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://itbootcamp.rs/");

        new Actions(driver).scrollToElement(driver.findElement(By.className("slider_bkgd"))).perform();

        List<WebElement> logos = driver.findElements(By.cssSelector("div.owl-item img"));

        for (int i = 0; i < logos.size(); i++) {
            URL imageLink = new URL(logos.get(i).getAttribute("src"));
            String URL = logos.get(i).getAttribute("src");
            HttpURLConnection http = (HttpURLConnection) imageLink.openConnection();
            int statusCode = http.getResponseCode();
            if (statusCode >= 200 & statusCode < 300) {
                Helper.downloadUsingStream(URL, "itbootcamp_slider/image" + i + ".png");
            }
        }
        driver.quit();
    }

    }

