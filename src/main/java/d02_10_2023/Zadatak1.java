package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");

        driver.findElement(By.className("edit-image"))
                .click();
        wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("image-option-remove")));

        driver.findElement(By.id("image-option-remove"))
                .click();

        ArrayList<File> imgFile = new ArrayList<>();
        imgFile.add(new File("photos/front.jpg"));
        imgFile.add(new File("photos/right.jpg"));
        imgFile.add(new File("photos/left.jpg"));
        imgFile.add(new File("photos/back.jpg"));

        for (int i = 0; i < 4; i++) {

            driver.findElement(By.className("edit-image"))
                    .click();
            wait
                    .withMessage("Image is not visible.")
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("imageUpload")));

            driver
                    .findElement(By.id("imageUpload"))
                    .sendKeys(imgFile.get(i).getAbsolutePath());
            wait
                    .withMessage("Image is not added.")
                    .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//img[contains(@id, 'image-option-')]"), i+1));

            driver.findElement(By.id("image-option-0"))
                    .click();
            wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#image-crop-done-button > button")));
            driver.findElement(By.cssSelector("#image-crop-done-button > button"))
                    .click();

            Thread.sleep(2000);
        }

        wait
                .withMessage("Button is not clickable.")
                .until(ExpectedConditions.elementToBeClickable(By.id("next-button")));
        driver.findElement(By.id("next-button"))
                .click();

        driver.findElement(By.id("textareaID"))
                .click();
        driver.findElement(By.id("textareaID"))
                .sendKeys("test");

        driver.findElement(By.id("next-button"))
                .click();
        wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'confetti-')]")));

        driver.findElement(By.id("confetti-4"))
                .click();

        driver.findElement(By.id("next-button"))
                .click();

        WebElement box360View = driver.findElement(By.id("input-container"));

        for (int i = 0; i < 4; i++) {
            new Actions(driver)
                    .clickAndHold(box360View)
                    .moveByOffset(100, 0)
                    .release()
                    .perform();
            Thread.sleep(500);
        }

        driver.findElement(By.id("next-button"))
                .click();

        driver.findElement(By.className("close"))
                .click();

        driver.findElement(By.id("next-button"))
                .click();


        Thread.sleep(5000);

        driver.quit();

    }
}
