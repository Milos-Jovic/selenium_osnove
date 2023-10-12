package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookPage extends BasicPage{

    public FacebookPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void switchToNewTab () {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }
    public void waitForUrl() {
        wait
                .withMessage("Url of the page should contain 'facebook'.")
                .until(ExpectedConditions.urlContains("facebook"));
    }

}
