package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static utils.Constants.*;

public class LoginTest extends TestBase {

    @Test
    public void verifyLogin(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage.login();
        WebElement element = driver.findElement(By.id("sessionDropdown"));
        loginPage.waitForElementVisibility(element, 10);
        assertThat(element.isDisplayed()).isTrue();
      }


}
