package p05_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class SwagLabsTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://www.saucedemo.com";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(baseUrl);

    }

            @Test(priority = 1, retryAnalyzer = SwagLabsRetry.class)
            public void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Error message is not displayed when username is missing.")
                .until(ExpectedConditions
                        .textToBePresentInElementLocated(
                                By.cssSelector(".error-message-container h3"),
                                "Username is required"));
    }

            @Test(priority = 2, retryAnalyzer = SwagLabsRetry.class)
            public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
        String username = "standard_user";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Error message is not displayed when password is missing.")
                .until(ExpectedConditions
                        .textToBePresentInElementLocated(
                                By.cssSelector(".error-message-container h3"),
                                "Password is required"));
    }


            @Test(priority = 3, retryAnalyzer = SwagLabsRetry.class)
            public void verifyErrorIsDisplayedWhenCredentialsAreWrong() {
        String username = "standard_user";
        String password = "invalidpassword";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Error message is not displayed when password is missing.")
                .until(ExpectedConditions
                        .textToBePresentInElementLocated(
                                By.cssSelector(".error-message-container h3"),
                                "Username and password do not match any user in this service"));
    }



            @Test (priority = 4, retryAnalyzer = SwagLabsRetry.class)
            public void verifyErrorIsDisplayedWhenUserIsLocked() {
        String username = "locked_out_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait.withMessage("Error Message did not show.")
                .until(ExpectedConditions.textToBePresentInElementLocated(By.className("error-message-container"),
                        "Epic sadface: Sorry, this user has been locked out."));

    }


            @Test(priority = 5, retryAnalyzer = SwagLabsRetry.class)
            public void verifySuccessfulLogin() {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();


        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");

        driver.findElement(By.id("react-burger-menu-btn")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("bm-menu-wrap")));

        boolean logoutExists =
                !driver.findElements(By.id("logout_sidebar_link")).isEmpty();

        Assert.assertTrue(logoutExists, "Logout should exists.");

        driver.findElement(By.id("logout_sidebar_link")).click();

        boolean loginFormExists =
                !driver.findElements(By.className("login_wrapper")).isEmpty();

        Assert.assertTrue(
                loginFormExists, "Should be redirected to login page after logout.");

    }
             @Test
            (priority = 6, retryAnalyzer = SwagLabsRetry.class)
    public void addingProductsToCart() {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);
        driver.findElement(By.id("login-button"))
                .click();
        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");

        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        WebElement product = null;
        String productName = "Sauce Labs Backpack";
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equals(productName)) {
                product = products.get(i);
            }
        }
        new Actions(driver)
                .scrollToElement(product)
                .perform();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remove-sauce-labs-backpack")));


        Assert.assertTrue(driver.findElement(By.className("shopping_cart_badge"))
                        .getText().equals("1"),
                "Number of products has not increased.");
    }


            @Test
            (priority = 7, retryAnalyzer = SwagLabsRetry.class)
    public void viewingProductDetails() {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);
        driver.findElement(By.id("login-button"))
                .click();
                Assert.assertEquals(
                        driver.getCurrentUrl(),
                        baseUrl + "/inventory.html",
                        "Should be redirected to inventory page after login.");

        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        WebElement product = null;
        String productName = "Sauce Labs Backpack";

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equals(productName)) {
                product = products.get(i);
            }
        }
        new Actions(driver)
                .scrollToElement(product)
                .perform();

        driver.findElement(By.className("inventory_item_name"))
                .click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_details_container")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_img")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_desc")));

        Assert.assertFalse(driver.findElement(By.className("inventory_details_desc"))
                        .getText().isEmpty(), "Box is empty.");

        Assert.assertFalse(driver.findElement(By.className("inventory_details_price"))
                        .getText().isEmpty(), "Price is not shown.");

        Assert.assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed(),
                "Button did not show.");

    }

            @Test
            (priority = 8, retryAnalyzer = SwagLabsRetry.class)
             public void removingProductsFromCart() {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);
        driver.findElement(By.id("login-button"))
                .click();
                Assert.assertEquals(
                        driver.getCurrentUrl(),
                        baseUrl + "/inventory.html",
                        "Should be redirected to inventory page after login.");

        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        WebElement product = null;
        String productName = "Sauce Labs Backpack";

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equals(productName)) {
                product = products.get(i);
            }
        }
        new Actions(driver)
                .scrollToElement(product)
                .perform();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

                Assert.assertTrue(driver.findElement(By.className("shopping_cart_badge"))
                                .getText().equals("1"),
                        "Number of products has not increased.");
        driver.findElement(By.className("shopping_cart_link"))
                .click();

        Assert.assertEquals(productName,
                driver.findElement(By.className("inventory_item_name")).getText(),
                "Product " + productName + " is not shown.");

        driver.findElement(By.id("remove-sauce-labs-backpack"))
                .click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("inventory_item_name")));

    }


             @Test
            (priority = 9, retryAnalyzer = SwagLabsRetry.class)
    public void productCheckout() {
        String username = "standard_user";
        String password = "secret_sauce";
        String checkoutName = "Pera";
        String checkoutLastName = "Peric";
        String checkoutZip = "18000";

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

                 Assert.assertEquals(
                         driver.getCurrentUrl(),
                         baseUrl + "/inventory.html",
                         "Should be redirected to inventory page after login.");

        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        WebElement product = null;
        String productName = "Sauce Labs Backpack";
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equals(productName)) {
                product = products.get(i);
            }
        }
        new Actions(driver)
                .scrollToElement(product)
                .perform();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();
                 Assert.assertTrue(driver.findElement(By.className("shopping_cart_badge"))
                                 .getText().equals("1"),
                         "Number of products has not increased.");
                 driver.findElement(By.className("shopping_cart_link"))
                         .click();

        Assert.assertTrue(driver.findElement(By.className("inventory_item_name"))
                        .getText().equals(productName),
                "Product " + productName + " is not shown in the cart.");

        driver.findElement(By.id("checkout"))
                .click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("checkout_info")));
        driver.findElement(By.id("first-name"))
                .sendKeys(checkoutName);
        driver.findElement(By.id("last-name"))
                .sendKeys(checkoutLastName);
        driver.findElement(By.id("postal-code"))
                .sendKeys(checkoutZip);

        driver.findElement(By.id("continue"))
                .click();

        Assert.assertTrue(driver.findElement(By.className("inventory_item_name"))
                        .getText().equals(productName),
                "Product " + productName + " is not shown.");

        Assert.assertTrue(driver.findElement(By.className("summary_subtotal_label"))
                        .getText().contains("20"),
                "Price these not match");

        driver.findElement(By.id("finish"))
                .click();
    }


            @Test
            (priority = 10, retryAnalyzer = SwagLabsRetry.class)
    public void validateSocialLinksInFooter() throws IOException {
                String username = "standard_user";
                String password = "secret_sauce";

                driver.findElement(By.id("user-name"))
                        .sendKeys(username);
                driver.findElement(By.id("password"))
                        .sendKeys(password);
                driver.findElement(By.id("login-button"))
                        .click();
                Assert.assertEquals(
                        driver.getCurrentUrl(),
                        baseUrl + "/inventory.html",
                        "Should be redirected to inventory page after login.");

                WebElement footer = driver.findElement(By.className("footer"));
                    new Actions(driver).scrollToElement(footer).perform();

                List<WebElement> links = driver.findElements(By.cssSelector(".social a"));

                for (int i = 0; i < links.size(); i++) {

                        URL urls = new URL(links.get(i).getAttribute("src"));
                        String URL = links.get(i).getAttribute("src");
                        HttpURLConnection http = (HttpURLConnection) urls.openConnection();
                        int statusCode = http.getResponseCode();

                    Assert.assertTrue(statusCode >= 200 && statusCode <  400,
                            URL + "Status Code is not between 200 and 400.");
                }

            }


    @AfterMethod
    public void afterMethod() {

        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

