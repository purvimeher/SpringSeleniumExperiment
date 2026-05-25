package com.example.tests;

import com.example.SpringSeleniumApplication;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringSeleniumApplication.class)
class GoogleTest {

    @Autowired
    private WebDriver driver;

    @Value("${app.base.url}")
    private String baseUrl;

    @Test
    void openGoogle() {
        driver.get(baseUrl);
        System.out.println(driver.getTitle());
    }
}