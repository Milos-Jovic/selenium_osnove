package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TabelPage extends BasicPage{

    public TabelPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public int getRowNumber() {
            return driver.findElements(By.cssSelector("tbody tr")).size();
        }

    public int getVisibleRowNumber() {
        return driver.findElements(By.cssSelector("tbody tr")).size();
    }


    public void clickOnDeleteButtonByRowIndex(int rowIndex){
        driver.findElements(By.className("delete")).get(rowIndex).click();
    }

        public String getFirstNameColumnValue(int rowIndex){
        return driver.findElements(By.xpath("//tbody/tr/td[2]"))
                .get(rowIndex).getText();
        }
    public String getLastNameColumnValue(int rowIndex){
        return driver.findElements(By.xpath("//tbody/tr/td[3]"))
                .get(rowIndex).getText();
    }

    public String getMiddleNameColumnValue(int rowIndex){
        return driver.findElements(By.xpath("//tbody/tr/td[4]"))
                .get(rowIndex).getText();
    }

}
