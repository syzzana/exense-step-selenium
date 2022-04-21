package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.TabsMenuPage;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static utils.Constants.BASE_URL;

public class TabsMenuTest extends TestBase {

    private String[] tabs = new String[]{"Plans", "Keywords", "Parameters", "Executions", "Scheduler", "Grid", "Admin"};
    private String[] visibleElements = new String[]{"New plan", "New keyword", "New parameter", "Execution list", "New task", "Agents", "Add user"};

    @Before
    public void authenticate() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(BASE_URL);
        loginPage.login();
    }

    @Test
    public void validateTabsMenu() {
        TabsMenuPage tabsMenuPage = new TabsMenuPage(driver);
        driver.get(BASE_URL);
        for (int i = 0, j = 0; i < tabs.length && j < visibleElements.length; i++, j++) {
            tabsMenuPage.goThroughTab(tabs[i]);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebElement element = tabsMenuPage.findElementByText(visibleElements[j]);
            tabsMenuPage.waitForElementVisibility(element, 10);
            assertThat(element.isDisplayed()).isTrue();
        }
    }
}
