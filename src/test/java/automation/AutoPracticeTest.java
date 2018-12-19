package automation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.is;

public class AutoPracticeTest {
    private WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "C:/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

    }
    @Test
    public void  logoIsVisible(){
        String css = "img.logo.img-responsive";
        WebElement logo = driver.findElement(By.cssSelector(css));
        Assert.assertThat("LOGO IS NOT VISIBLE", logo.isDisplayed(), is(true));
    }
    @Test
    public void checkOpeningSite(){
        String actualURL = driver.getCurrentUrl();
        String excpectedURL = "http://automationpractice.com/index.php";
        Assert.assertEquals(actualURL, excpectedURL);
    }
    @Test
    public void openCategory(){
        String css = "#block_top_menu > ul > li:nth-child(3) > a";
        WebElement category = driver.findElement(By.cssSelector(css));
        category.click();
        String actualURL = driver.getCurrentUrl();
        String excpectedURL = "http://automationpractice.com/index.php?id_category=5&controller=category";
        Assert.assertThat("error", actualURL, is(excpectedURL));
    }
    @After
    public void tearDown(){
        driver.close();
    }

}
