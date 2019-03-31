package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//*[contains(@data-test-id, 'header-cart')]")
    public WebElement cart;

    @FindBy(xpath = "//*[@class='header-btn hack m-delete button default']")
    public WebElement deleteChoisen;

    @FindBy(xpath = "//*[@data-test-id='checkcart-confirm-modal-confirm-button']")
    public WebElement confirmDelete;

}