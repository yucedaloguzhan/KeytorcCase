package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BestBuyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class BestBuyStepDefinitions extends BestBuyPage {


    @Given("User goes to BestBuy home page")
    public void userGoesToBestBuyHomePage() {
        Driver.getDriver().get(ConfigReader.getProperty("BestBuyUrl"));
    }

    @Then("User verify that home page is present")
    public void userVerifyThatHomePageIsPresent() {Driver.getDriver().manage().deleteAllCookies();verifyHomePage();}

    @Then("User open login page and register with a user")
    public void user_open_login_page_and_register_with_a_user() {
        LoginAndRegister();
    }

    @And("User type samsung in the Search box click the Search button")
    public void userTypeSamsungInTheSearchBoxClickTheSearchButton() {
        sendSamsung();
    }

    @Then("User will confirm that there is a result for samsung")
    public void userWillConfirmThatThereIsAResultForSamsung() {secondPageAssertions();}

    @And("User click page two, and confirm that page two is displayed")
    public void userClickPageTwoAndConfirmThatPageTwoIsDisplayed() {secondPageAssertions();}

    @Then("User Click favorites button third product from the top")
    public void userClickFavoritesButtonThirdProductFromTheTop() throws InterruptedException {addToFavorites();}

    @And("User Click my favorites button")
    public void userClickMyFavoritesButton() {
        clickTheFavorites();
    }

    @Then("User will confirm that there is the product that was tracked on the previous page")
    public void user_will_confirm_that_there_is_the_product_that_was_tracked_on_the_previous_page() {assertionOfTheProduct();}

    @And("User press Remove button")
    public void userPressRemoveButton() {
        deleteFromFavorites();
    }

    @Then("User will confirm that product is no longer in the favorites.")
    public void user_will_confirm_that_product_is_no_longer_in_the_favorites() {checkingIfTheListEmpty();}


}
