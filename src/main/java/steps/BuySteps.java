package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BuyPage;

public class BuySteps {

    private BuyPage buyPage = new BuyPage();

    @When("выполняем поиск по \"(.*)\"")
    public void search(String item){
        buyPage.fillField(buyPage.searchInput, item);
        buyPage.clickOnElement(buyPage.enterTheButtonSearch);
    }

    @Then("добавляем \"(.*)\" товаров в корзину")
    public void addToCard(int value){
        buyPage.scrollPage("//span[contains(text(), 'Бестселлеры')]");
        for(int i = 0; i < value; i++){
            buyPage.buttonsAdd.get(i).click();
        }
    }

}