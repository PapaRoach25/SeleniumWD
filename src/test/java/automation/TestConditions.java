package automation;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.MainPage;

public class TestConditions {
    protected WebDriver driver;
    MainPage mainPage;
    Actions builder;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "C:/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        mainPage = new MainPage(driver);
        builder = new Actions(driver);
    }
    @After
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }
}
