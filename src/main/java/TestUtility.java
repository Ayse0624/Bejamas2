import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtility {
    WebDriver driver;

    public TestUtility(WebDriver driver) {
        this.driver = driver;
    }
    public void sleep(int seconds){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait=new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
