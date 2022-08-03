import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pagination {
    WebDriver driver;
    TestUtility utility;
    ProductList productList;
    AddToCart addToCart;


    @FindBy(xpath = "//*[@class='PaginationIndicatorstyle__Ol-urm45v-0 hRXIFn']/li[8]")
    WebElement nextArrow;

    @FindBy(xpath = "//*[@class='PaginationIndicatorstyle__Ol-urm45v-0 hRXIFn']/li[1]")
    WebElement preArrow;

    @FindBy(xpath = "//*[@class='PaginationIndicatorstyle__Ol-urm45v-0 hRXIFn']/li[2]")
    WebElement page1;

    @FindBy(xpath = "//*[@class='PaginationIndicatorstyle__Ol-urm45v-0 hRXIFn']/li[7]")
    WebElement page6;

    public Pagination(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
        productList=new ProductList(driver);
        addToCart=new AddToCart(driver);

    }
    public void pagination(){
        utility.waitForElementPresent(productList.productListTable);
        int productSize=productList.productList.size();
        if (productList.productList.size()==6)
            System.out.println("There is 6 products on one page");
        else
            System.out.println("There is not 6 products on one page,there is "+productSize+" products on one page");
        utility.waitForElementPresent(nextArrow);
        nextArrow.click();
        utility.waitForElementPresent(preArrow);
        if (preArrow.isDisplayed())
            System.out.println("page changed");
        else
            System.out.println("page do NOT changed");
        utility.waitForElementPresent(page1);
        page1.click();
        if (preArrow.isDisplayed())
            System.out.println("User see 'prev' arrow on the first page");
        else
            System.out.println("User does not see 'prev' arrow on the first page");
        page6.click();
        if (nextArrow.isDisplayed())
            System.out.println("User see 'next' arrow on the last page");
        else
            System.out.println("User does not see 'next' arrow on the last page");

//These two elements('pre'arrow and 'next'arrow) may be wrong, I did manual test it was correct when I automatized it gave wrong



    }



}
