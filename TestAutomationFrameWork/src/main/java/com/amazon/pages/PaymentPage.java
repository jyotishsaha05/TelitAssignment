package com.amazon.pages;

//PaymentPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class PaymentPage {

 //private WebDriver driver;
 private WebDriverWait wait;

 // Constructor
 public PaymentPage(WebDriver driver) {
     //this.driver = driver;
     this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 }

 // Method to proceed to checkout
 public void clickProceedToCheckout() {
     WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("proceedToRetailCheckout")));
     proceedToCheckoutButton.click();
 }
 
 // Skip for now
 public void skipForNow() {
	 WebElement skip = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='kyc-xborder-radio-skip']/child::i[@class='a-icon a-icon-radio']")));
	 skip.click();
 }
 
 public void countinue() {
	 WebElement countinue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='kyc-xborder-continue-btn-container']/child::*//input[@type='submit']")));
	 countinue.click();   
 }

 
 
 // Method to enter payment details (e.g., credit card information)
 public void enterPaymentDetails(String cardNumber, String expirationDate, String securityCode) {
     WebElement cardNumberField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("creditCardNumber")));
     cardNumberField.sendKeys(cardNumber);

     WebElement expirationDateField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("creditCardExpirationDate")));
     expirationDateField.sendKeys(expirationDate);

     WebElement securityCodeField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("creditCardSecurityCode")));
     securityCodeField.sendKeys(securityCode);
 }

 // Method to select the billing address (if applicable)
 public void selectBillingAddress(String address) {
     WebElement addressField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("billingAddress")));
     addressField.sendKeys(address);
 }

 // Method to select a payment method (e.g., Credit Card, PayPal, etc.)
 public void selectPaymentMethod(String paymentMethod) {
     WebElement paymentMethodRadioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(paymentMethod)));
     paymentMethodRadioButton.click();
 }

 // Method to submit the payment
 public void submitPayment() {
     WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitPaymentButton")));
     submitButton.click();
 }

 // Method to verify the payment confirmation
 public boolean isPaymentSuccessful() {
     WebElement paymentConfirmationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("paymentConfirmationMessage")));
     return paymentConfirmationMessage.isDisplayed();
 }
}
