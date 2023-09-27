package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        String username = "Admin";
        String password = "admin123";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(2000);
        WebElement userInput = driver.findElement(
                By.xpath("//input[@name='username']"));
                userInput.clear();
                userInput.sendKeys(username);

        WebElement  passwoedInput = driver.findElement(
                By.xpath("//input[@name='password']"));
                passwoedInput.clear();
                passwoedInput.sendKeys(password);

              WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
              logIn.click();

        Thread.sleep(5000);


            WebElement search = driver.findElement(
                By.xpath("//input[@placeholder='Search']"));
        search.clear();
        search.sendKeys("Me");

        Thread.sleep(2000);

        WebElement menuLink = driver.findElement(
                By.xpath("//ul[@class='oxd-main-menu']/li/a"));
                menuLink.click();

            Thread.sleep(1000);

        WebElement avatar = driver.findElement(
                By.xpath("//img[@alt='profile picture']"));
                avatar.click();

        WebElement logout = driver.findElement(
                By.xpath("//ul[@role='menu']/li[4]/a"));
        logout.click();


        Thread.sleep(5000);

        driver.quit();

    }
}
