package d03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BootstrapTableTests {

        private WebDriver driver;
        private WebDriverWait wait;
        @BeforeClass
    public void setup(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        @BeforeMethod

    public void beforeMethod(){
            driver.get("https://s.bootsnipp.com/iframe/K5yrx ");
            Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                    "Title of the page is incorrect");
        }
        @Test
        private void editRow(){

            String firstName = "Milos";
            String lastName = "Jovic";
            String middleName = "Jovan";

            driver.findElement(By.xpath("//*[@id='d1']/td[5]/button")).click();

            wait
                    .withMessage("error")
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.modal-content")));

            WebElement firstNameInput = driver.findElement(By.id("fn"));
            WebElement lastNameInput = driver.findElement(By.id("ln"));
            WebElement middleNameInput = driver.findElement(By.id("mn"));

            firstNameInput.clear();
            firstNameInput.sendKeys(firstName);
            lastNameInput.clear();
            lastNameInput.sendKeys(lastName);
            middleNameInput.clear();
            middleNameInput.sendKeys(middleName);
            driver.findElement(By.xpath("//button[text()='Update']")).click();

            wait
                    .withMessage("Modal is still visible")
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='edit']/div[2]")));
            Assert.assertEquals(driver.findElement(By.id("f1")).getText(), firstName, "First name is "+firstName);
            Assert.assertEquals(driver.findElement(By.id("l1")).getText(), lastName, "Last name is "+lastName);
            Assert.assertEquals(driver.findElement(By.id("m1")).getText(), middleName, "Middle name is "+middleName);


    }

    @Test
    private void deleteRow(){


            driver.findElement(By.xpath("//*[@id='d1']/td[6]/button")).click();

        wait
                .withMessage("Model is not wisible")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='delete']/div[2]/div")));
                driver.findElement(By.id("del")).click();

        wait
                .withMessage("Modal is still visible")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='delete']/div[2]/div")));

        int cellsInRow = driver.findElements(By.cssSelector(".table>tbody>tr:first-child>td")).size();
        int cellsInTable = driver.findElements(By.cssSelector(".table>tbody>tr>td")).size();

        Assert.assertEquals(driver.findElements(By.cssSelector(".table>tbody>tr>td")).size(),
                cellsInRow-cellsInTable, "Row is still visible after deletion");
    }


}
