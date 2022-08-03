import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
    WebDriver driver;
    TestUtility utility;

    public Sorting(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
    @FindAll(
            @FindBy(className = "ProductCardstyle__Price-sc-5v39a6-5 cjBejL")
    )
    List<WebElement> FilterPrice;

    @FindBy(xpath = "//*[@class=\"SortingSelectstyle__SortingSelectWrapper-sc-1r760yq-0 gcZyvG\"]/select")
    WebElement dropDownList;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/div/div[4]/div/div[2]/div/button")
    WebElement sortButton;

    public void sortingAsc(){
        List<Double>beforeFilterPriceList=new ArrayList<>();
        for (WebElement p:FilterPrice){
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
        }
        Select dropDown=new Select(dropDownList);
        dropDown.selectByVisibleText("Price");
        sortButton.click();
        List<Double>afterFilterPriceList=new ArrayList<>();
        for (WebElement p:FilterPrice){
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
        }
        Collections.sort(beforeFilterPriceList);
        Collections.reverse(beforeFilterPriceList);

        Assert.assertEquals(beforeFilterPriceList,afterFilterPriceList);



    }
}
