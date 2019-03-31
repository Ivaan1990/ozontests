package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[contains(@data-test-id, 'header-cart')]")
    public WebElement cart;

    @FindBy(xpath = "//*[contains(text(), 'войдите')]")
    public WebElement enterInPersonalArea;

    @FindBy(xpath = "//*[contains(text(), 'Войти по почте')]")
    public WebElement enterEmail;

    @FindBy(xpath = "//*[contains(@data-test-id, 'emailField')]")
    public WebElement emailField;

    @FindBy(xpath = "//*[contains(@data-test-id, 'passwordField')]")
    public WebElement passwordField;

    @FindBy(xpath = "//*[contains(@data-test-id, 'loginFormSubmitButton')]")
    public WebElement buttonComeIn;

    @FindBy(xpath = "//*[@class='empty-cart-btn button blue large']")
    public WebElement submit;

    @FindBy(xpath = "//*[@data-test-id='header-my-ozon-icon']")
    public WebElement userButton;

    @FindBy(xpath = "//span[@data-test-id='header-my-ozon-logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//*[@class='cart-title']")
    public WebElement emptyCart;

}