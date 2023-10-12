package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class InventoryPage extends BasicPage{
    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

    }
    public WebElement getProduct () {
        return driver.findElement(By.id("item_4_title_link"));
    }

    public WebElement addProductToCard() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }
    public void clickOnAdd() {
        addProductToCard().click();
    }
    public WebElement getRemoveButton() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }
    public void waitForRemoveButtonToBeVisible() {
        wait.until(ExpectedConditions.visibilityOf(getRemoveButton()));
    }

    public WebElement getSubTitle () {
        return driver.findElement(By.cssSelector("span.title"));
    }
    public String getSubTitleText () {
        return getSubTitle().getText();
    }

}
