package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickOnElement(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), 40, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void scrollPage(String xPath){
        ((JavascriptExecutor)DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView();", DriverManager.getDriver()
                        .findElement(By.xpath(xPath)));
    }

    public void waitPageLoader(){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 15);
        wait.ignoring(NoSuchElementException.class).until((ExpectedCondition<Boolean>) driver ->
                !isPresent(By.xpath("//*[@class='modal-container']")));
    }

    public static boolean isPresent(By locator){
        try {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return DriverManager.getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        } finally {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
    }

    public void fillField(WebElement element, String value){
        clickOnElement(element);
        element.clear();
        element.sendKeys(value);
    }

}