package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverManager;

import java.util.List;

public class BuyPage extends BasePage {

    @FindBy(xpath = "//input[@data-test-id='header-search-input']")
    public WebElement searchInput;

    @FindBy(xpath = "//*[contains(@class, 'search-button-wrap')]")
    public WebElement enterTheButtonSearch;

    @FindBy(xpath = "//*[@class='button blue enlarged buy-text-button']")
    public List<WebElement> buttonsAdd;

    public void waitPageLoader(){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 15);
        wait.ignoring(NoSuchElementException.class).until((ExpectedCondition<Boolean>) driver ->
                !BasePage.isPresent(By.xpath("//*[@class='sticky-button']")));
    }
}
