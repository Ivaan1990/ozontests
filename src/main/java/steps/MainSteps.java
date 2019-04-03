package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import util.DriverManager;

import static pages.BasePage.isPresent;

public class MainSteps {

    private static final String login = "ivaan7845@gmail.com";
    private static final String pass = "qwerty123";

    private MainPage mainPage = new MainPage();

    /**
     * @see #myAuth()
     */
    @When("авторизация")
    public void authorization(){
        myAuth();
        mainPage.waitPageLoader();
        mainPage.clickOnElement(mainPage.submit);
    }

    @When("разлогиниваемся из сервиса")
    public void logOut(){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 15);
        mainPage.clickOnElement(mainPage.userButton);
        wait.ignoring(NoSuchElementException.class).until((ExpectedCondition<Boolean>) driver ->
                !isPresent(By.xpath("//*[@class='modal-wrapper']")));
        mainPage.clickOnElement(mainPage.logoutButton);
    }

    /**
     * @see #myAuth()
     */
    @When("повторная авторизация")
    public void repeatAuth(){
        myAuth();
    }

    @Then("проверяем пустая ли корзина")
    public void checkEmptyCart(){
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), 40, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.emptyCart));
        Assert.assertEquals("В корзине остались заказы", "Корзина пуста", mainPage.emptyCart.getText());
    }

    private void myAuth(){
        mainPage.clickOnElement(mainPage.cart);
        mainPage.enterInPersonalArea.click();
        mainPage.clickOnElement(mainPage.enterEmail);
        mainPage.fillField(mainPage.emailField, login);
        mainPage.fillField(mainPage.passwordField, pass);
        mainPage.clickOnElement(mainPage.buttonComeIn);
    }
}