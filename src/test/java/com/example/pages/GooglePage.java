package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class GooglePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By searchBox = By.name("q");
    private final By acceptButton = By.xpath("//button[contains(.,'Accept all') or contains(.,'I agree')]");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(String baseUrl) {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        acceptCookiesIfPresent();
    }

    public void search(String text) {
        WebElement box = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        box.click();
        box.clear();
        box.sendKeys(text);
        box.sendKeys(Keys.ENTER);
    }

    private void acceptCookiesIfPresent() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
            button.click();
        } catch (Exception ignored) {
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }
}