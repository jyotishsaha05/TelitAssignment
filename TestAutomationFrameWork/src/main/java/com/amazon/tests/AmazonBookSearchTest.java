package com.amazon.tests;

import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.PaymentPage;
import com.amazon.pages.SearchResultsPage;
import com.amazon.utils.FileUtils;
import com.amazon.utils.UserCredentials;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBookSearchTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private SearchResultsPage searchResultsPage;
    private CartPage cartPage;
    private WebDriverWait wait;
    private PaymentPage paymentPage;
    
    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        WebDriverManager.chromedriver().setup();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");
            driver = new EdgeDriver(options);
        }
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        driver = new ChromeDriver(options);

        // Initialize page objects
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        cartPage = new CartPage(driver);
        paymentPage = new PaymentPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Initialize WebDriverWait with a timeout of 10 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void testValidLogin() {
        loginPage.openLoginPage();
        // Read credentials from the JSON file
        UserCredentials credentials = null;
		try {
			credentials = FileUtils.readUserCredentialsFromJson("data/test_data.json");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (credentials != null) {
            // Use the credentials in your login
            loginPage.login(credentials.getUserid(), credentials.getPassword());
        } else {
            System.out.println("Failed to read user credentials from JSON");
        }
        // Assert that the account link is displayed after successful login
        Assert.assertTrue(loginPage.isAccountLinkDisplayed(), "Login failed! Account link is not displayed.");
    }

    @Test(priority = 2)
    public void testSearchAndAddFirstBookToCart() {

        // Search for the first book and add it to the cart
        homePage.searchForBook("Think and Grow Rich");
        searchResultsPage.clickOnFirstBook();

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        addToCartButton.click();

        WebElement cartConfirmation = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sw-gtc")));
        Assert.assertTrue(cartConfirmation.isDisplayed(), "Think and Grow Rich was not added to the cart.");
    }

    @Test(priority = 3)
    public void testSearchAndAddSecondBookToCart() {
        //driver.get("https://www.amazon.com");

        // Search for the second book and add it to the cart
        homePage.searchForBook("Rich Dad Poor Dad");
        searchResultsPage.clickOnSecondBook();

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        addToCartButton.click();

        WebElement cartConfirmation = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sw-gtc")));
        Assert.assertTrue(cartConfirmation.isDisplayed(), "Rich Dad Poor Dad was not added to the cart.");
    }

    @Test(priority = 4)
    public void testVerifyCartItemCount() {
        // Go to the cart to verify both items are added
        cartPage.clickOnCartIcon();

        // Verify the cart contains exactly 2 items
        Assert.assertEquals(cartPage.getCartItemCount(), 2, "Cart does not contain exactly 2 items.");
    }

    @Test(priority = 5)
    public void testProceedToCheckout() {
        // Proceed to checkout after verifying cart
        paymentPage.clickProceedToCheckout();

        // Add assertions for payment page if necessary, for example:
        // Assert.assertTrue(paymentPage.isPaymentPageLoaded(), "Payment page not loaded.");
        paymentPage.skipForNow();
        paymentPage.countinue();
        
        
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
           // driver.quit();
        }
    }
}
