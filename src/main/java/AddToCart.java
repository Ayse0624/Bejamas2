
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
    WebDriver driver;
    TestUtility utility;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
    @FindBy(xpath="//*[@id=\"__next\"]/div/div/div/div[2]/button/span")
    WebElement counterBadge;

    @FindBy(xpath = "//*[@class=\"style__Main-c50g3c-1 hyxNsn\"]/div/div/div[5]/div/div[2]/div/div[1]/div/div[1]/div/div[1]/button")
    WebElement addToCartButton;

    @FindBy(xpath="//*[@id=\"__next\"]/div/main/div/div/div[5]/div/div[2]/div/div[1]/div/div[1]/div/div[1]")
    WebElement firstArt;

    @FindBy(xpath = "//*[@class=\"style__Row-sc-4ctdae-2 hcCKLP ShoppingCartstyle__ShoppingCartWrapper-sc-1xombtx-0 dMjapL\"]")
    WebElement dropDownList;

    @FindBy(xpath = "//*[@class=\"style__Row-sc-4ctdae-2 hcCKLP ShoppingCartstyle__ShoppingCartWrapper-sc-1xombtx-0 dMjapL\"]/div[3]/button")
    WebElement clearButton;


    public void addToCart(){
        utility.waitForElementPresent(counterBadge);
        if (counterBadge.isDisplayed())
            System.out.println("user can see counter badge before add to cart");
        else
            System.out.println("user can not see counter badge");
        Actions actions=new Actions(driver);
        actions.moveToElement(firstArt).build().perform();
        utility.waitForElementPresent(addToCartButton);
        addToCartButton.click();
        System.out.println("add to cart successfully");
        utility.waitForElementPresent(dropDownList);
        dropDownList.isDisplayed();
        System.out.println("view product in dropdown list successfully");
        utility.waitForElementPresent(clearButton);
        clearButton.click();
        System.out.println("clear dropdown list successfully");
    }



}

