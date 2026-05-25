package com.example.tests;

import com.example.base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


class GoogleTest extends BaseTest {

    @Test
    @Tag("smoke")
    void searchGoogle() {
        googlePage.search("Selenium Spring Boot");
        System.out.println(driver.getTitle());
    }

    @Test
    @Tag("ui")
    void searchGoogleWithSpecificData() {
        googlePage.search("UI Testing with Selenium");
        System.out.println(driver.getCurrentUrl());
    }
}