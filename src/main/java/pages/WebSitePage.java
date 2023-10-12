package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebSitePage extends BasicPage{
    public WebSitePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public String getPageUrl () {
        return driver.getCurrentUrl();
    }
}
