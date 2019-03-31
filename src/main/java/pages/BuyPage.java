package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BuyPage extends BasePage {

    @FindBy(xpath = "//input[@data-test-id='header-search-input']")
    public WebElement searchInput;

    @FindBy(xpath = "//*[contains(@class, 'search-button-wrap')]")
    public WebElement enterTheButtonSearch;

    @FindBy(xpath = "//*[@class='button blue enlarged buy-text-button']")
    public List<WebElement> buttonsAdd;
}
