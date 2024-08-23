package com.example.pages;

import com.codeborne.selenide.Selenide;
import com.example.utils.PropertiesHandler;

public class LazadaBasePage {

    public void open(String relativeUrl) {
        Selenide.open(String.format("%s%s", PropertiesHandler.getWebProperty("base.url"), relativeUrl));
    }
}
