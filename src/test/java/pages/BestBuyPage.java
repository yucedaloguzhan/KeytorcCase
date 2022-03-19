package pages;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public abstract class BestBuyPage {


    public BestBuyPage() {
        PageFactory.initElements(Driver.getDriver(), this);}

    public void verifyHomePage() {
        String homePageTitle=Driver.getDriver().getTitle();
        homePageTitle.contains("bestbuy");
    }


    @FindBy(xpath = "//span[@class='v-p-right-xxs line-clamp']")
    public WebElement accountButton;


    @FindBy(xpath = "//a[normalize-space()='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='fld-e']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='fld-p1']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitSignButton;


    public void LoginAndRegister()  {
        flag.click();
        accountButton.click();
        signInButton.click();
        emailBox.sendKeys(ConfigReader.getProperty("email"));
        passwordBox.sendKeys(ConfigReader.getProperty("password"));
        submitSignButton.click();
    }
    @FindBy(xpath = "//div[@lang='en']//img[@alt='United States']")
    public WebElement flag;

    @FindBy(xpath = "//input[@id='gh-search-input']")
    public WebElement searchBox;

    @FindBy(xpath = "//h1[@class='heading-2 v-m-top-l v-fw-light v-text-pure-white']")
    public WebElement samsungText;

    @FindBy(xpath = "//a[normalize-space()='Computing']//img[@alt='Laptop, tablet']")
    public WebElement computersSection;

    @FindBy(xpath = "//span[@class='header-search-icon']//*[name()='svg']")
    public WebElement searchButton;


    public void sendSamsung(){
        searchBox.sendKeys(ConfigReader.getProperty("BrandName"));
        searchButton.click();
        Assert.assertTrue(samsungText.isDisplayed());
        computersSection.click();}

    @FindBy(xpath = "//a[@aria-label='Results Page 2']")
    public WebElement buttonTwo;

    @FindBy(xpath = "//div[@class='left-side']")
    public WebElement secondPageAssertionText;

    public void secondPageAssertions(){
        buttonTwo.click();
        String actual=secondPageAssertionText.getText();
        String expected="25-48 of 265 items";
        actual.contains(expected);}

       @FindBy(xpath = "(//button[@class='c-button c-button-primary c-button-sm c-button-block c-button-icon c-button-icon-leading add-to-cart-button'])[3]")
          public WebElement favoriteAndSaveButton;

          public void addToFavorites() throws InterruptedException {
               Thread.sleep(3000);
               Actions actions=new Actions(Driver.getDriver());
               actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
               Thread.sleep(3000);
               actions.moveToElement(favoriteAndSaveButton).perform();
               favoriteAndSaveButton.click();
       }

       @FindBy(xpath = "//span[@class='cart-label']")
       public WebElement cartButton;

       public void clickTheFavorites(){
           ReusableMethods.scrollToElement(cartButton);
           cartButton.click();
           ReusableMethods.waitFor(1);
       }

       @FindBy(xpath = "//a[@class='cart-item__title focus-item-0']")
       public WebElement productInTheFavorites;


       public void assertionOfTheProduct(){

           Assert.assertTrue(productInTheFavorites.isDisplayed());
           ReusableMethods.waitFor(1);}

       @FindBy(xpath = "//button[@class='c-button-link cart-item__remove']")
        public WebElement deleteButton;

       public void deleteFromFavorites(){
           deleteButton.click();
       }

       @FindBy(xpath = "//h3[@class='zero-state-headline']")
       public WebElement checkingList;

       public void checkingIfTheListEmpty(){
           ReusableMethods.waitFor(1);
           String actual=checkingList.getText();
           String expected="Your list is currently empty";
           Assert.assertEquals(actual,expected);

       }
}

