import org.apache.maven.surefire.api.runorder.Priority;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RunnerClass extends BasePage{
    static TestUtility utility;
    static String url=ReadFromFiles.readConfigProperties("url");
    static AddToCart addToCart;
    static ProductList productList;
    static Pagination pagination;
    static Sorting sorting;

    @BeforeClass(alwaysRun = true)
    public static void setBrowser(){
        setUpBrowser(url);
        utility=new TestUtility(driver);
        addToCart=new AddToCart(driver);
        productList=new ProductList(driver);
        pagination=new Pagination(driver);
        sorting=new Sorting(driver);

    }
    @Test(priority = 1)
    public void addToCartFeatures(){
        addToCart.addToCart();
    }

    @Test(priority = 2)
    public void ProductListFeatures(){
        productList.ProductList();
    }

    @Test(priority = 3)
    public void PaginationFeatures(){
        pagination.pagination();
    }
    @Test(priority = 4)
    public void SortingFeatures(){
        sorting.sortingAsc();

    }

//    @AfterClass
//    public void close() {
//        driver.close();
//        driver.quit();
//
//    }


}
