package com.example.base;

import com.example.pages.GooglePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseTest {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected GooglePage googlePage;

    @Value("${app.base.url}")
    protected String baseUrl;

    @BeforeEach
    void setup() {
        googlePage.open(baseUrl);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}