package com.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By signInLink = By.id("nav-link-accountList");
    private By emailField = By.id("ap_email");
    private By continueButton = By.id("continue");
    private By passwordField = By.id("ap_password");
    private By signInButton = By.id("signInSubmit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods for actions on the login page
    public void openLoginPage() {
        driver.get("https://www.amazon.com");
        WebElement signInLinkElement = wait.until(ExpectedConditions.elementToBeClickable(signInLink));
        signInLinkElement.click();
    }

    public void login(String email, String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(emailField)).sendKeys(email);
        driver.findElement(continueButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField)).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public boolean isAccountLinkDisplayed() {
        WebElement accountLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-link-accountList")));
        return accountLink.isDisplayed();
    }
}
