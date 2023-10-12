package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasicPage {
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForUrl() {
        wait
                .withMessage("Current url should contain 'cart'.")
                .until(ExpectedConditions.urlContains("cart"));
    }

    public void waitForProductToBeAdded() {
        wait
                .withMessage("Cart page should contain added products.")
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("cart_item"), 0));
    }

    public WebElement getSubHeaderTitle() {
        return driver.findElement(By.cssSelector("span.title"));
    }

    public String getSubHeaderTitleText() {
        return getSubHeaderTitle().getText();
    }

    public void waitForLeftNavMenuToBecomeInvisible() {
        wait
                .withMessage("Menu is still visible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("bm-menu")));
    }

    public List<WebElement> getProductsAddedToTheCart() {
        return driver.findElements(By.cssSelector("div.cart_item"));
    }

    public void waitForAddedProductsToBeVisible() {
        wait
                .withMessage("products should be visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(getProductsAddedToTheCart()));
    }

    public List<WebElement> getTitlesOfProducts() {
        return driver.findElements(By.className("inventory_item_name"));

    }

    public WebElement getTitleOfProductAddedToTheCart(int indexOfProduct) {
        return getTitlesOfProducts().get(indexOfProduct);
    }

    public void waitForAddedProductsTitlesToBeVisible() {
        wait
                .withMessage("Titles should be visible.")
                .until(ExpectedConditions.visibilityOfAllElements(getTitlesOfProducts()));
    }

    public List<WebElement> getDescriptionsOfProducts() {
        return driver.findElements(By.className("inventory_item_desc"));
    }

    public void waitForAddedProductsDescriptionsToBeVisible() {
        wait
                .withMessage("Descriptions of added products should be visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(getDescriptionsOfProducts()));
    }

    public List<WebElement> getPricesOfProducts() {
        return driver.findElements(By.className("inventory_item_price"));
    }

    public void waitForAddedProductsPricesToBeVisible() {
        wait
                .withMessage("Prices of products should be visible.")
                .until(ExpectedConditions.visibilityOfAllElements(getPricesOfProducts()));
    }

    public List<WebElement> getQuantityOfProducts() {
        return driver.findElements(By.cssSelector(".cart_item .cart_quantity"));
    }


    public void waitForAddedProductsQuantityToBeVisibleOnThePage() {
        wait
                .withMessage("Quantities of added products should be visible.")
                .until(ExpectedConditions.visibilityOfAllElements(getQuantityOfProducts()));
    }

    public void waitForItemsToBeClickable(int indexOfProduct) {
        wait
                .withMessage("Items titles should be clickable.")
                .until(ExpectedConditions.elementToBeClickable(getTitleOfProductAddedToTheCart(indexOfProduct)));
    }

    public void clickOnItemsTitle(int indexOfProduct) {
        getTitleOfProductAddedToTheCart(indexOfProduct).click();
    }

    public WebElement getRemoveButton() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }

    public void waitUntilRemoveButtonIsVisible() {
        wait
                .withMessage("Remove button should be visible.")
                .until(ExpectedConditions.visibilityOf(getRemoveButton()));
    }

    public void clickOnRemoveButton() {
        getRemoveButton().click();
    }

    public void waitForAddedProductsToBecomeInvisible() {
        wait
                .withMessage("Products are still visible.")
                .until(ExpectedConditions.invisibilityOfAllElements(getProductsAddedToTheCart()));
    }

    public WebElement getShoppingButton() {
        return driver.findElement(By.id("continue-shopping"));
    }

    public void waitUntilShoppingButtonIsVisible() {
        wait
                .withMessage("Button should be visible on the page.")
                .until(ExpectedConditions.visibilityOf(getShoppingButton()));
    }

    public void clickOnContinueShoppingButton() {
        getShoppingButton().click();
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(By.id("checkout"));
    }

    public void waitUntilCheckoutButtonIsVisible() {
        wait
                .withMessage("Button should be visible on the page.")
                .until(ExpectedConditions.visibilityOf(getCheckoutButton()));
    }

    public void clickOnCheckoutButton() {
        getCheckoutButton().click();
    }
}