package cucumber;

import constants.WebDriverConstants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class StepDefinitions {
    private static final String initialPassword = "<initial_password>";
    private static final String newPassword = "<new_password>";
    JavascriptExecutor js;
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty(WebDriverConstants.WEB_DRIVER_HTTP_FACTORY_KEY, WebDriverConstants.WEB_DRIVER_HTTP_FACTORY_VALUE);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
    }

    @After
    public void teardown() {
        driver.quit();
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(WebDriverConstants.MILLIS);
    }

    @Given("Internet connection")
    public void internet_connection() {
        // This step is just a precondition and doesn't require any action
    }

    @Given("Google Chrome Version {string}")
    public void google_chrome_version(String ignoredVersion) {
        // This step is just a precondition and doesn't require any action
    }

    @Given("At least one product in the shopping cart")
    public void product_in_shopping_cart() throws InterruptedException {
        // Navigate to the website and add a product to the shopping cart
        driver.get("https://www.douglas.ro/");
        sleep();
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        WebElement shadowHost = wait.until(driver -> driver.findElement(By.cssSelector("#usercentrics-root")));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        shadowRoot.findElement(By.cssSelector("#uc-center-container > div.sc-cCjUiG.gHlwwJ > div > div > div > button:nth-child(2)")).click();
        sleep();
        driver.findElement(By.xpath("//div[@id='tns1-item2']/a/span")).click();
        sleep();
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div/div/div/div/div/div/div/ul/li/ul/li[2]/a")).click();
        sleep();
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[1]/div/div/div/div[1]/div/div/div/div/div/div/div/div/ul/li/ul/li[2]/ul/li[1]/a")).click();
        sleep();
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[3]/a")).click();
        sleep();
        driver.findElement(By.xpath("//*[@id=\"productDetailPageBuyProductForm\"]/div/div/button")).click();
        sleep();
        driver.findElement(By.cssSelector("body > div.offcanvas.is-right.cart-offcanvas.is-open > button")).click();
        sleep();
    }

    @When("Click on the \"Shopping cart\" button")
    public void click_shopping_cart_button() throws InterruptedException {
        WebElement shoppingCartButton = driver.findElement(By.cssSelector("body > header > div.container > div > div.col-auto.col-md-auto.order-5.e-header-cart-col > div > a"));
        shoppingCartButton.click();
        sleep();
    }

    @When("Click on the \"View shopping cart\" link")
    public void click_view_shopping_cart_link() throws InterruptedException {
        WebElement viewShoppingCartLink = driver.findElement(By.linkText("Vizualizare coș de cumpărături"));
        viewShoppingCartLink.click();
        sleep();
    }

    @When("Click on the \"Quantity\" select box")
    public void click_quantity_select_box() throws InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cantitate'])[2]/following::div[4]")).click();
        sleep();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cantitate'])[2]/following::span[6]")).click();
        sleep();
    }

    @When("Select the option {string}")
    public void select_option(String option) throws InterruptedException {
        new Select(driver.findElement(By.id("quantity-8007c96bb0374801923da23baea5d4ee"))).selectByVisibleText(option);
        sleep();
    }

    @Then("The quantity of the product in the shopping cart has been modified")
    public void verify_quantity_modified() throws InterruptedException {
        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[1]/div[1]/div[1]/div/div/div")).getText().trim(), "Coșul de cumpărături actualizat");
        sleep();
    }

    @Given("Homepage of the website {string}")
    public void homepageOfTheWebsite(String website) throws InterruptedException {
        driver.get(website);
        sleep();
    }

    @Then("Click account icon")
    public void clickAccountIcon() throws InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Livrare'])[1]/following::*[name()='svg'][3]")).click();
        sleep();
    }

    @Then("Click email")
    public void clickEmail() throws InterruptedException {
        driver.findElement(By.id("Email")).click();
        sleep();
        driver.findElement(By.id("Email")).clear();
        sleep();
    }

    @Then("Complete email with value")
    public void completeEmailWithValue() throws InterruptedException {
        driver.findElement(By.id("Email")).sendKeys("someone@example.com");
        sleep();
    }

    @Then("Click password")
    public void clickPassword() throws InterruptedException {
        driver.findElement(By.id("Password")).click();
        sleep();
        driver.findElement(By.id("Password")).clear();
        sleep();
    }

    @Then("Complete password with value")
    public void completePasswordWithValue() throws InterruptedException {
        driver.findElement(By.id("Password")).sendKeys(initialPassword);
        sleep();
    }

    @Then("Click login button")
    public void clickLoginButton() throws InterruptedException {
        driver.findElement(By.name("button")).click();
        sleep();
    }

    @Then("Click tab contact details")
    public void clickTabDateDeContact() throws InterruptedException {
        driver.findElement(By.linkText("Date de contact")).click();
        sleep();
    }

    @Then("Click text change password")
    public void clickTextSchimbaParola() throws InterruptedException {
        driver.findElement(By.linkText("Schimbă parola")).click();
        sleep();
    }

    @Then("Complete password with old password")
    public void completePasswordWithOldPassword() throws InterruptedException {
        driver.findElement(By.id("Password")).click();
        sleep();
        driver.findElement(By.id("Password")).clear();
        sleep();
        driver.findElement(By.id("Password")).sendKeys(initialPassword);
        sleep();
    }

    @Then("Complete new password")
    public void completeNewPassword() throws InterruptedException {
        driver.findElement(By.id("NewPassword")).click();
        sleep();
        driver.findElement(By.id("NewPassword")).clear();
        sleep();
        driver.findElement(By.id("NewPassword")).sendKeys(newPassword);
        sleep();
    }

    @Then("Confirm new password")
    public void confirmNewPassword() throws InterruptedException {
        driver.findElement(By.id("ConfirmPassword")).click();
        sleep();
        driver.findElement(By.id("ConfirmPassword")).clear();
        sleep();
        driver.findElement(By.id("ConfirmPassword")).sendKeys(newPassword);
        sleep();
    }

    @Then("Click button confirm")
    public void clickButtonConfirm() throws InterruptedException {
        driver.findElement(By.id("target")).click();
        sleep();
        driver.findElement(By.cssSelector("button.sc-ftTHYK.kpgNGm > svg > polygon")).click();
        sleep();
    }

    @Then("Accept cookies")
    public void acceptCookies() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='modals']/div/div/div[3]/div/button[2]/div/span")).click();
        sleep();
    }

    @Then("Click search")
    public void clickSearch() throws InterruptedException {
        driver.findElement(By.id("fulltext-desktop")).click();
        sleep();
    }

    @Then("Clear search")
    public void clearSearch() throws InterruptedException {
        driver.findElement(By.id("fulltext-desktop")).clear();
        sleep();
    }

    @Then("Type {string}")
    public void type(String search) throws InterruptedException {
        driver.findElement(By.id("fulltext-desktop")).sendKeys(search);
        sleep();
    }

    @Then("Submit search")
    public void search() throws InterruptedException {
        driver.findElement(By.xpath("//main[@id='app']/div/div/div[3]/div/div[2]/form/div[2]/div[2]/button/div/span")).click();
        sleep();
    }

    @Then("Select perfume")
    public void selectParfume() throws InterruptedException {
        driver.findElement(By.id("pCI174")).click();
        sleep();
    }

    @Then("Select quantity")
    public void selectQuantity() throws InterruptedException {
        driver.findElement(By.xpath("//main[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[3]/div[2]/div/div[4]/div/div/div[2]/a/div[4]")).click();
        sleep();
    }

    @Then("Add to cart")
    public void addToCart() throws InterruptedException {
        driver.findElement(By.xpath("//main[@id='app']/div/div[2]/div[2]/div/div/div[2]/div[6]/button/div/span")).click();
        sleep();
    }

    @Then("Close modal")
    public void closeModal() throws InterruptedException {
        driver.findElement(By.cssSelector("div.position-absolute.right-3.top-3 > button.base-button.icon-button.medium.shadow > div.d-flex.align-items-center.justify-content-center > svg.icon > use")).click();
        sleep();
    }

    @Then("Click cart")
    public void clickCart() throws InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Viva club'])[1]/following::*[name()='svg'][2]")).click();
        sleep();
    }

    @Then("Select transport")
    public void selectTransport() throws InterruptedException {
        driver.findElement(By.xpath("//main[@id='app']/div/div[2]/div/div/div[5]/div/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/div/div")).click();
        sleep();
    }

    @Then("Select payment")
    public void selectPayment() throws InterruptedException {
        driver.findElement(By.xpath("//main[@id='app']/div/div[2]/div/div/div[5]/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div")).click();
        sleep();
    }

    @Then("Click firstname field")
    public void clickFirstNameField() throws InterruptedException {
        driver.findElement(By.id("delivery-firstname")).click();
        sleep();
    }

    @Then("Clear firstname field")
    public void clearFirstNameField() throws InterruptedException {
        driver.findElement(By.id("delivery-firstname")).clear();
        sleep();
    }

    @Then("Fill firstname field")
    public void fillFirstNameField() throws InterruptedException {
        driver.findElement(By.id("delivery-firstname")).sendKeys("<delivery_firstname>");
        sleep();
    }

    @Then("Click lastname field")
    public void clickLastNameField() throws InterruptedException {
        driver.findElement(By.id("delivery-lastname")).click();
        sleep();
    }

    @Then("Clear lastname field")
    public void clearLastNameField() throws InterruptedException {
        driver.findElement(By.id("delivery-lastname")).clear();
        sleep();
    }

    @Then("Fill lastname field")
    public void fillLastNameField() throws InterruptedException {
        driver.findElement(By.id("delivery-lastname")).sendKeys("<delivery_lastname>");
        sleep();
    }

    @Then("Click address field")
    public void clickAddressField() throws InterruptedException {
        driver.findElement(By.id("delivery-street")).click();
        sleep();
    }

    @Then("Clear address field")
    public void clearAddressField() throws InterruptedException {
        driver.findElement(By.id("delivery-street")).clear();
        sleep();
    }

    @Then("Fill address field")
    public void fillAddressField() throws InterruptedException {
        driver.findElement(By.id("delivery-street")).sendKeys("<delivery_street>");
        sleep();
    }

    @Then("Click area field")
    public void clickAreaField() throws InterruptedException {
        driver.findElement(By.id("delivery-area")).click();
        sleep();
    }

    @Then("Clear area field")
    public void clearAreaField() throws InterruptedException {
        driver.findElement(By.id("delivery-area")).clear();
        sleep();
    }

    @Then("Fill area field")
    public void fillAreaField() throws InterruptedException {
        driver.findElement(By.id("delivery-area")).sendKeys("<delivery_area>");
        sleep();
    }

    @Then("Select area")
    public void selectArea() throws InterruptedException {
        driver.findElement(By.xpath("//main[@id='app']/div/div[2]/div/div/div[5]/div/div/div[3]/div/div/div[2]/div/div/div[4]/div/div[2]/div/div/div/div/div/div/div/div")).click();
        sleep();
    }

    @Then("Click city field")
    public void clickCityField() throws InterruptedException {
        driver.findElement(By.id("delivery-city")).click();
        sleep();
    }

    @Then("Clear city field")
    public void clearCityField() throws InterruptedException {
        driver.findElement(By.id("delivery-city")).clear();
        sleep();
    }

    @Then("Fill city field")
    public void fillCityField() throws InterruptedException {
        driver.findElement(By.id("delivery-city")).sendKeys("<delivery_city>");
        sleep();
    }

    @Then("Select city")
    public void selectCity() throws InterruptedException {
        driver.findElement(By.xpath("//main[@id='app']/div/div[2]/div/div/div[5]/div/div/div[3]/div/div/div[2]/div/div/div[5]/div/div[2]/div/div/div[4]/div/div/div/div[2]/div/div/div/div")).click();
        sleep();
    }

    @Then("Click postal code field")
    public void clickPostalCodeField() throws InterruptedException {
        driver.findElement(By.id("delivery-zip-code")).click();
        sleep();
    }

    @Then("Clear postal code field")
    public void clearPostalCodeField() throws InterruptedException {
        driver.findElement(By.id("delivery-zip-code")).clear();
        sleep();
    }

    @Then("Fill postal code field")
    public void fillPostalCodeField() throws InterruptedException {
        driver.findElement(By.id("delivery-zip-code")).sendKeys("<delivery_zip_code>");
        sleep();
    }

    @Then("Click phone field")
    public void clickPhoneField() throws InterruptedException {
        driver.findElement(By.id("delivery-phone")).click();
        sleep();
    }

    @Then("Clear phone field")
    public void clearPhoneField() throws InterruptedException {
        driver.findElement(By.id("delivery-phone")).clear();
        sleep();
    }

    @Then("Fill phone field")
    public void fillPhoneField() throws InterruptedException {
        driver.findElement(By.id("delivery-phone")).sendKeys("<delivery_phone>");
        sleep();
    }

    @Then("Click email field")
    public void clickEmailField() throws InterruptedException {
        driver.findElement(By.id("delivery-email")).click();
        sleep();
    }

    @Then("Clear email field")
    public void clearEmailField() throws InterruptedException {
        driver.findElement(By.id("delivery-email")).clear();
        sleep();
    }

    @Then("Fill email field")
    public void fillEmailField() throws InterruptedException {
        driver.findElement(By.id("delivery-email")).sendKeys("<delivery_email>");
        sleep();
    }

    @Then("Click send command")
    public void clickSendCommand() throws InterruptedException {
        driver.findElement(By.xpath("//main[@id='app']/div/div[2]/div/div/div[5]/div/div[2]/div/div[2]/div/div[2]/button/div")).click();
        sleep();
    }

}
