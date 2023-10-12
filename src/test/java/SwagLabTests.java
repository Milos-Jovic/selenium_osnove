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

    @Test(priority = 2, retryAnalyzer = SwagLabRetry.class)
    public void VerifySuccessfulLogin() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUserName(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "inventory.html",
                "Current url should be 'https://www.saucedemo.com/inventory.html' ");


    }
}