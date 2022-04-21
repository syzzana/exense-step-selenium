package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TabsMenuPage extends AbstractPage {

    public TabsMenuPage(WebDriver driver) {
        super(driver);
    }

    public void goThroughTab(String tab) {
        waitForElementToBeClickable(By.xpath("//*[contains(text(),'" + tab + "')]"), 10);
        findElementByText(tab).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
