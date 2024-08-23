package com.example.tests;

import com.example.configs.SelenideConfig;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        SelenideConfig.configureSelenide();
    }
}
