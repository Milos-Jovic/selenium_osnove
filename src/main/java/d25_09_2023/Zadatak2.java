package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

        ArrayList<String> toDo = new ArrayList<>();
        toDo.add("Visit Paris");
        toDo.add("Visit Prague");
        toDo.add("Visit London");
        toDo.add("Visit New York");
        toDo.add("Visit Belgrade");

        for (int i = 0; i <toDo.size() ; i++) {
            WebElement input = driver.findElement(By.className("new-todo"));
            input.sendKeys(toDo.get(i));
            input.sendKeys(Keys.ENTER);
        }

        List<WebElement> toDoList = driver.findElements(
          By.xpath("//ul[@class='todo-list']/li/div/input"));
        for (int i = 0; i <toDoList.size() ; i++) {
            toDoList.get(i).click();
        }

        Thread.sleep(5000);
        driver.quit();

    }
}
