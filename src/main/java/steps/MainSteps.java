package steps;

import cucumber.api.java.en.When;
import pages.MainPage;

public class MainSteps {

    private static final String login = "ivaan7845@gmail.com";
    private static final String pass = "qwerty123";

    MainPage mainPage = new MainPage();

    @When("авторизация")
    public void authorization(){
        mainPage.clickOnElement(mainPage.cart);
        mainPage.enterInPersonalArea.click();
        mainPage.clickOnElement(mainPage.enterEmail);
        mainPage.fillField(mainPage.emailField, login);
        mainPage.fillField(mainPage.passwordField, pass);
        mainPage.clickOnElement(mainPage.buttonComeIn);
        mainPage.waitPageLoader();
        mainPage.clickOnElement(mainPage.submit);
    }
}