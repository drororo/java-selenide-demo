package com.example.configs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;

import java.util.logging.Level;

public class SelenideConfig {

    public static void configureSelenide() {
        Configuration.pageLoadStrategy = "none";

        SelenideLogger.addListener(
                "AllureSelenide", new AllureSelenide()
                        .screenshots(true)
                        .includeSelenideSteps(false)
                        .enableLogs(LogType.BROWSER, Level.ALL)
        );
    }
}
