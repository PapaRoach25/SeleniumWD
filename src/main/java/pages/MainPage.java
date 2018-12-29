package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(css = "img.logo.img-responsive")
    WebElement logo;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    WebElement tShirtCategory;

    @FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
    WebElement singInBtn;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "SubmitLogin")
    WebElement submitBtn;

    @FindBy(css = "#center_column > ul > li")
    WebElement goods;

    @FindBy(css = "#center_column > ul > li > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
    WebElement hoverOnGoods;

    @FindBy(id = "product_1_1_0_127359")
    WebElement goadsThatWasAdded;

    public MainPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getTShirtCategory() {
        return tShirtCategory;
    }

    public WebElement getSingInBtn() {
        return singInBtn;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getEmail() {
        return email;
    }
    public WebElement getGoods() {
        return goods;
    }
    public WebElement getHoverOnGoods() {
        return hoverOnGoods;
    }
    public WebElement getGoadsThatWasAdded() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("product_1_1_0_127359")));
        return goadsThatWasAdded;
    }
    public void sendTextInInputPassword(String textPassword){
        password.sendKeys(textPassword);
    }

}
