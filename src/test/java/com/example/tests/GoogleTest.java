package com.example.tests;

import com.example.SpringSeleniumApplication;
import com.example.pages.GooglePage;
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

    public GoogleTest(GooglePage googlePage) {
        this.googlePage = googlePage;
    }
    @Autowired
    private WebDriver driver;

    @Value("${app.base.url}")
    private String baseUrl;

    @Test
    @Tag("smoke")
    void searchGoogle() {
        googlePage.open(baseUrl);
        googlePage.search("Selenium Spring Boot");
        System.out.println(googlePage.getTitle());
        System.out.println("Base URL: " + baseUrl);
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }
}