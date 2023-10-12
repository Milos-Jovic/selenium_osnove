import org.testng.Assert;
import org.testng.annotations.Test;

import retry.SwagLabRetry;

public class SwagLabTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = SwagLabRetry.class)
    public void VerifyErrorWhenUsernameIsMissing() {
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.geLoginErrorMessage(),
                "Epic sadface: Username is required",
                "Error");
    }

    @Test(priority = 2, retryAnalyzer = SwagLabRetry.class)
    public void VerifyErrorWhenPasswordIsMissing() {
        String username = "standard_user";
        loginPage.clearAndTypeUserName(username);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.geLoginErrorMessage(),
                "Epic sadface: Password is required",
                "Error");
    }

    @Test(priority = 3, retryAnalyzer = SwagLabRetry.class)
    public void verifySuccessfulLogin() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUserName(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "inventory.html",
                "Current url should be 'https://www.saucedemo.com/inventory.html' ");


    }

    @Test(priority = 4, retryAnalyzer = SwagLabRetry.class)
    public void addToCardButton() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUserName(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "inventory.html",
                "Current url should be 'https://www.saucedemo.com/inventory.html' ");
        inventoryPage.getProduct();
        inventoryPage.clickOnAdd();
        inventoryPage.waitForRemoveButtonToBeVisible();
    }

    @Test(priority = 5, retryAnalyzer = SwagLabRetry.class)
    public void chackTheTitlePage() {
        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
    }

    @Test(priority = 6, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatCartIconIsPresentOnCartPage() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrl();

        Assert.assertTrue(topNavPage.doesCartIconExist(),
                "Shopping cart icon should exist on the cart page.");

    }

    @Test(priority = 7, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatBurgerMenuButtonIsEnabled() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrl();

        Assert.assertTrue(topNavPage.isLeftNavButtonEnabled(),
                "Left navigation menu button should be enabled on the cart page.");

    }

    @Test(priority = 8, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatCartIconIsEnabled() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrl();

        Assert.assertTrue(topNavPage.isCartIconEnabled(),
                "Cart icon should be enabled on the cart page.");

    }

    @Test(priority = 9, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatBurgerMenuButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrl();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();

    }

    @Test(priority = 10, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatCartIconIsClickable() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        topNavPage.waitUntilCartIconIsClickable();

    }

    @Test(priority = 11, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatCartIconHasCorrectNumberOfAddedProducts() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();

        Assert.assertEquals(topNavPage.getNumberOfProductsInCart(), "",
                "Number of products in cart icon should be 0.");

    }

    @Test(priority = 12, retryAnalyzer = SwagLabRetry.class)
    public void VerifyTheSubHeaderTitleForCartPage() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();

        Assert.assertEquals(cartPage.getSubHeaderTitleText(), "Your Cart",
                "Sub title header for cart page should be 'Your Cart'.");

    }

    @Test(priority = 13, retryAnalyzer = SwagLabRetry.class)
    public void VerifyTotalNumberOfOptionsInLeftNavigationMenu() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrl();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();

        Assert.assertEquals(leftNavPage.getNumberOfOptionsInLeftNavMenu(), 4,
                "Left navigation menu should contain 4 options.");

    }

    @Test(priority = 14, retryAnalyzer = SwagLabRetry.class)
    public void VerifySpellingOfAllOptionsInLeftNavigationMenu() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrl();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();

        Assert.assertTrue(leftNavPage.checkSpellingOfAllOptionsInLeftNavMenu(),
                "Spelling of elements in left navigation manu is not valid.");

    }

    @Test(priority = 15, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatAllItemsOptionFromLeftNavigationMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrl();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();
        leftNavPage.clickOnAllItemsLink();

        Assert.assertEquals(inventoryPage.getSubTitleText(), "Products",
                "Sub title of inventory page should be 'Products'.");
    }

    @Test(priority = 16, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatAboutOptionFromLeftNavigationMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrl();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();
        leftNavPage.clickOnAboutLink();

    }

    @Test(priority = 17, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatLogoutOptionFromLeftNavigationMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrl();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();
        leftNavPage.clickOnLogoutButton();

    }

    @Test(priority = 18, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatResetAppOptionFromLeftNavigationMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();

        Assert.assertEquals(topNavPage.getNumberOfProductsInCart(), "1",
                "After reset the cart icon should be empty.");

        topNavPage.clickOnCart();
        cartPage.waitForUrl();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();
        leftNavPage.clickOnResetAppButton();

        Assert.assertEquals(topNavPage.getNumberOfProductsInCart(), "",
                "After reset the cart icon should be empty.");
    }

    @Test(priority = 19, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatExitButtonFromLeftNavigationMenuIsVisible() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrl();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();

    }

    @Test(priority = 20, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatExitButtonFromLeftNavigationMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrl();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();
        leftNavPage.clickOnExitButton();
        cartPage.waitForLeftNavMenuToBecomeInvisible();

    }
    @Test(priority = 21, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsAddedToTheCartAreVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
        topNavPage.clickOnCart();
        cartPage.waitForAddedProductsToBeVisible();

    }

    @Test(priority = 22, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsTitleAddedToTheCartIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
        topNavPage.clickOnCart();
        cartPage.waitForAddedProductsTitlesToBeVisible();

    }

    @Test(priority = 23, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsDescriptionAddedToTheCartIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
        topNavPage.clickOnCart();
        cartPage.waitForAddedProductsDescriptionsToBeVisible();

    }

    @Test(priority = 24, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsPriceAddedToTheCartIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
        topNavPage.clickOnCart();
        cartPage.waitForAddedProductsPricesToBeVisible();

    }

    @Test(priority = 25, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsQuantityIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
        topNavPage.clickOnCart();
        cartPage.waitForAddedProductsQuantityToBeVisibleOnThePage();

    }

    @Test(priority = 26, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsTitleIsClickable() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
        topNavPage.clickOnCart();
        cartPage.waitForItemsToBeClickable(0);

    }

    @Test(priority = 27, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsTitleIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();        topNavPage.clickOnCart();
        cartPage.waitForItemsToBeClickable(0);
        cartPage.clickOnItemsTitle(0);
        itemPage.waitUntilCurrentUrlContainsPageName();

    }

    @Test(priority = 28, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatRemoveButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
        topNavPage.clickOnCart();
        cartPage.waitUntilRemoveButtonIsVisible();

    }

    @Test(priority = 29, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatRemoveButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
        topNavPage.clickOnCart();
        cartPage.waitUntilRemoveButtonIsVisible();
        cartPage.clickOnRemoveButton();
        cartPage.waitForAddedProductsToBecomeInvisible();

    }

    @Test(priority = 30, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatContinueShoppingButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
        topNavPage.clickOnCart();
        cartPage.waitUntilShoppingButtonIsVisible();

    }

    @Test(priority = 31, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatContinueShoppingButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
        topNavPage.clickOnCart();
        cartPage.waitUntilShoppingButtonIsVisible();
        cartPage.clickOnContinueShoppingButton();

        Assert.assertEquals(inventoryPage.getSubTitleText(), "Products",
                "Should be redirected to the inventory page.");

    }

    @Test(priority = 32, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatCheckoutButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
        topNavPage.clickOnCart();
        cartPage.waitUntilCheckoutButtonIsVisible();

    }

    @Test(priority = 33, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatCheckoutButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAdd();
        topNavPage.clickOnCart();
        cartPage.waitUntilCheckoutButtonIsVisible();
        cartPage.clickOnCheckoutButton();
        checkoutPage.waitUntilUrlContainsPageName();

    }

//    @Test(priority = 34, retryAnalyzer = SwagLabRetry.class)
//    public void VerifyThatTwitterIconIsVisibleInTheFooter() {
//
//        loginPage.loginWIthValidCredentials();
//        topNavPage.clickOnCart();
//        footerPage.waitForUrl();
//
//    }
//    @Test(priority = 35, retryAnalyzer = SwagLabRetry.class)
//    public void VerifyThatFacebookIconIsVisibleInTheFooter() {
//
//        loginPage.loginWIthValidCredentials();
//        topNavPage.clickOnCart();
//        footerPage.waitForUrl();
//
//    }
//    @Test(priority = 36, retryAnalyzer = SwagLabRetry.class)
//    public void VerifyThatLinkedInIconIsVisibleInTheFooter() {
//
//        loginPage.loginWIthValidCredentials();
//        topNavPage.clickOnCart();
//        footerPage.waitForUrl();
//
//    }
//
//    @Test(priority = 37, retryAnalyzer = SwagLabRetry.class)
//    public void VerifyCopyRightNoticeMessageInFooter() {
//
//        loginPage.loginWIthValidCredentials();
//        topNavPage.clickOnCart();
//
//    }
}