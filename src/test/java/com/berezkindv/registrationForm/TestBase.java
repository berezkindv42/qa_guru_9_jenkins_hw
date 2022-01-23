package com.berezkindv.registrationForm;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAllMethod() {
        Configuration.baseUrl = "https://demoqa.com";
    }
}
