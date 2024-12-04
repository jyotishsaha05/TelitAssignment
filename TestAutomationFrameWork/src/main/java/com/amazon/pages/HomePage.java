package com.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

   // private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By searchBar = By.id("twotabsearchtextbox");

    public HomePage(WebDriver driver) {
       // this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods for actions on the home page
    public void searchForBook(String bookName) {
        WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(searchBar));
        searchInput.clear();
        searchInput.sendKeys(bookName);
        searchInput.submit();  // Submit the search query
    }
}
