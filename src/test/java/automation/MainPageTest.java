package automation;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class MainPageTest extends TestConditions{

    @Test
    public void logoIsVisible(){
        Assert.assertThat("LOGO IS NOT VISIBLE", mainPage.getLogo().isDisplayed(), is(true));
    }
    @Test
    public void checkOpeningSite(){
        String expectedURL = "http://automationpractice.com/index.php";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
    @Test
    public void openCategory(){
        mainPage.getTShirtCategory().click();
        String expectedURL = "http://automationpractice.com/index.php?id_category=5&controller=category";
        Assert.assertThat("Category T-shirt not found ", driver.getCurrentUrl(), is(expectedURL));
    }
    @Test
    public void authorization(){
        mainPage.getSingInBtn().click();
        mainPage.getEmail().sendKeys("bobmarleymetal1996@gmail.com");
        mainPage.sendTextInInputPassword("1234a");
        mainPage.getSubmitBtn().click();
    }
    @Test
    public void addGoodsToCart(){
        authorization();
        openCategory();
        builder.moveToElement(mainPage.getGoods()).perform();
        mainPage.getHoverOnGoods().click();
    }
    @Test
    public void checkGoodsInCart(){
        addGoodsToCart();
        driver.get("http://automationpractice.com/index.php?controller=order");
        Assert.assertThat("Cart is empty", mainPage.getGoadsThatWasAdded().isDisplayed(), is(true));
    }
}
