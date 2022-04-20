package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

abstract class TestBase {

    protected WebDriver driver;
    @BeforeSuite
    public void setupSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
     }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

}
