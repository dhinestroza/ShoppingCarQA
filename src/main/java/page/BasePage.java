package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Action actions;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));

    }

    public static void closeBrowser(){
        driver.quit();
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    public WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        find(locator).click();
    }

    public String getElement(String locator){
        return  find(locator).getText();
    }

    public void writeToElement(String locator,String text){
        find(locator).sendKeys(text);
    }

    public void selectNthElements(String locator,int quantity){
        List<WebElement> result = driver.findElements(By.xpath(locator));
        result.get(quantity).click();
    }

    public void allSelectElementsCheckbox(String locator){
        List<WebElement> result = driver.findElements(By.xpath(locator));
        for (WebElement check:result){
            if (!check.isSelected()){
                check.click();
            }
        }
    }

    public void selectedFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(valueToSelect);
    }



    public void isSelectedCheckbox(String locator){
        WebElement result = driver.findElement(By.xpath(locator));

        if (!result.isSelected()){
            result.click();

        }

    }

}