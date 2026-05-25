package com.example.tests;

import com.example.pages.GooglePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class GoogleTest {

    private final GooglePage googlePage;
    @Autowired
    private WebDriver driver;
    @Value("${app.base.url}")
    private String baseUrl;

    public GoogleTest(GooglePage googlePage) {
        this.googlePage = googlePage;
    }

    @Test
    @Tag("smoke")
    void searchGoogle() {
        googlePage.open(baseUrl);
        googlePage.search("Selenium Spring Boot");
        System.out.println(googlePage.getTitle());
        System.out.println("Base URL: " + baseUrl);
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @Test
    @Tag("ui")
    void searchGoogleWithSpecifcData() {
        googlePage.open(baseUrl);
        googlePage.search("UI Testing with selenium");
        System.out.println(googlePage.getTitle());
        System.out.println("Base URL: " + baseUrl);
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}