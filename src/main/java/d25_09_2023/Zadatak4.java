package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://artplayer.org/");


        Thread.sleep(3000);
       WebElement play = driver.findElement(By.cssSelector("div.art-control-playAndPause"));
        play.click();
        WebElement mute = driver.findElement(By.cssSelector("div.art-control-volume"));
        mute.click();
        Thread.sleep(3000);
        WebElement screenshot = driver.findElement(By.cssSelector("div.art-control-screenshot"));
        screenshot.click();
        WebElement pip = driver.findElement(By.cssSelector("div.art-control-pip"));
        pip.click();
        WebElement exit = driver.findElement(By.cssSelector("div.art-control-pip"));
        exit.click();
        Thread.sleep(1000);
        WebElement fullscreen = driver.findElement(By.className("art-icon-fullscreenWebOn"));
        fullscreen.click();
        Thread.sleep(2000);
        WebElement exitFullscreen = driver.findElement(By.cssSelector("div[aria-label='Exit Fullscreen']"));
        exitFullscreen.click();
        Thread.sleep(5000);


        driver.quit();
    }
}
