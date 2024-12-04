package com.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By firstBookImage = By.cssSelector(".s-main-slot .s-result-item .s-image");
    private By secondBookImage = By.cssSelector(".s-main-slot .s-result-item .s-image");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods to click on books
    public void clickOnFirstBook() {
        WebElement firstBook = wait.until(ExpectedConditions.elementToBeClickable(firstBookImage));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstBook).click().perform();
    }

    public void clickOnSecondBook() {
        WebElement secondBook = wait.until(ExpectedConditions.elementToBeClickable(secondBookImage));
        Actions actions = new Actions(driver);
        actions.moveToElement(secondBook).click().perform();
    }
}
