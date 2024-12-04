package com.amazon.pages;

// CartPage.java
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    //private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public CartPage(WebDriver driver) {
       // this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Method to click on the Cart icon
    public void clickOnCartIcon() {
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-cart")));
        cartIcon.click();
    }

    // Method to get the cart item count
    public int getCartItemCount() {
        WebElement cartCount = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-cart-count")));
        return Integer.parseInt(cartCount.getText());
    }
}
