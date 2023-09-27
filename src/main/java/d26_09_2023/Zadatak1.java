package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        Scanner s = new Scanner(System.in);


        System.out.println("Enter First Name");
        String name = s.next();
        WebElement firsName = driver.findElement(By.xpath("//input[@id='firstName']"));
        firsName.sendKeys(name);
        System.out.println("Enter Last Name");
        String lastN = s.next();
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys(lastN);
        System.out.println("Enter email");
        String email = s.next();
        WebElement Email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        Email.sendKeys(email);
        System.out.println("Gender");
        WebElement genderRadio = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        genderRadio.click();
        System.out.println("Mobile");
        String mobile = s.next();
        WebElement Mobile = driver.findElement(By.xpath("//input[@id='userNumber']"));
        Mobile.sendKeys(mobile);
        System.out.println("Subject");
        String subject = s.next();
        WebElement Subject = driver.findElement(By.id("subjectsInput"));
        Subject.sendKeys(subject);
        System.out.println("Hobby");
        WebElement hobby = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        hobby.click();
        System.out.println("Choose file");
        WebElement file = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
        file.sendKeys("file");
        System.out.println("Current addres");
        String current = s.next();
        WebElement Current = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        Current.sendKeys(current);
    }
}
