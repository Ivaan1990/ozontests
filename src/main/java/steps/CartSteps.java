package steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.CartPage;
import util.DriverManager;

public class CartSteps {
    private CartPage cartPage = new CartPage();

    @Then("перейти в корзину")
    public void goInCart(){
        cartPage.scrollPage("//*[contains(@data-test-id, 'header-cart')]");
        cartPage.clickOnElement(cartPage.cart);
    }

    @Then("проверить добавленные товары")
    public void revisionGoods(){
        //Assert.assertEquals("В корзине недостаточно товаров");
    }

    @Then("удалить все товары из корзины")
    public void deleteAllFromCart(){
        cartPage.clickOnElement(cartPage.deleteChoisen);
        cartPage.clickOnElement(cartPage.confirmDelete);
        //todo в цикле проверять сколько элементов в коробке, если == 0, выходим из цикла
    }

}