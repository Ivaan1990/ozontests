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

    @Then("добавляем 5 товаров в корзину")
    public void addToCard(){
        buyPage.scrollPage("//span[contains(text(), 'Бестселлеры')]");
        for(int i = 0; i < 5; i++){
            buyPage.clickOnElement(buyPage.buttonsAdd.get(i));
        }
    }

}