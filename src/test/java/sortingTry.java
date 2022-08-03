import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortingTry extends BasePage{
    static TestUtility utility;
    static String url1=ReadFromFiles.readConfigProperties("url1");
    static Sorting sorting;

    @BeforeClass(alwaysRun = true)
    public static void setBrowser(){
        setUpBrowser(url1);
        utility=new TestUtility(driver);
        sorting=new Sorting(driver);
    }
    @Test
    public void sorting(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        List<WebElement>beforefilterprice=driver.findElements(By.className("inventory_item_price"));

        List<Double> beforeFilterPriceList=new ArrayList<>();
        for (WebElement p:beforefilterprice){
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
        }

        Select dropDown=new Select(driver.findElement(By.className("product_sort_container")));
        dropDown.selectByVisibleText("Price (low to high)");

        List<WebElement>afterfilterprice=driver.findElements(By.className("inventory_item_price"));
        List<Double>afterFilterPriceList=new ArrayList<>();
        for (WebElement p:afterfilterprice){
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
        }
        Collections.sort(beforeFilterPriceList);
        //Collections.reverse(beforeFilterPriceList);

        Assert.assertEquals(beforeFilterPriceList,afterFilterPriceList);



    }
    }





