import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductList {
    WebDriver driver;
    TestUtility utility;
    AddToCart addToCart;

    public ProductList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
        addToCart=new AddToCart(driver);

    }
    @FindBy (xpath = "//*[@id=\"__next\"]/div/main/div/div/div[5]/div/div[2]/div/div[1]/div")
    WebElement productListTable;

    @FindAll(
            @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/div/div[5]/div/div[2]/div/div[1]/div/div")

    )
    List<WebElement> productList;

    @FindAll(
            @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/div/div[5]/div/div[2]/div/div[1]/div/div/div/div[1]/p")
    )
    List<WebElement>bestStaler;

    public void ProductList(){
        int productSize=productList.size();
        utility.waitForElementPresent(productListTable);
        if (productList.size()==6)
            System.out.println("There is 6 items");
        else
            System.out.println("There is not 6 items. There is "+productSize+" items");
        Actions actions=new Actions(driver);
        actions.moveToElement(addToCart.firstArt).build().perform();
        utility.waitForElementPresent(addToCart.addToCartButton);
        addToCart.addToCartButton.isDisplayed();
        System.out.println("User displayed the (add to cart) bar");
        if (bestStaler.size()>1)
            System.out.println("There is some products have the bestseller flag");
        else
            System.out.println("here is NOT some products have the bestseller flag");

    }
}
