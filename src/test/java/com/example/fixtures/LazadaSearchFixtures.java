package com.example.fixtures;

import com.codeborne.selenide.Selenide;
import com.example.entities.CatalogModel;
import com.example.utils.PropertiesHandler;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.openqa.selenium.Cookie;

import java.util.HashMap;
import java.util.Set;

public class LazadaSearchFixtures {

    @Step
    public CatalogModel getCatalogModel(String searchQuery) {
        Set<Cookie> cookies = Selenide.webdriver().driver().getWebDriver().manage().getCookies();
        HashMap<String, String> cookiesMap = new HashMap<>();

        for (Cookie cookie : cookies) {
            cookiesMap.put(cookie.getName(), cookie.getValue());
        }

        return RestAssured.given()
                .log().all()
                .baseUri(PropertiesHandler.getApiProperty("base.url"))
                .header("Content-Type", "application/json; charset=utf-8")
                .cookies(cookiesMap)
                .queryParams(new HashMap<String, String>() {{
                    put("ajax", "true");
                    put("catalog_redirect_tag", "true");
                    put("isFirstRequest", "true");
                    put("page", "1");
                    put("q", searchQuery);
                }})
                .get(String.format(PropertiesHandler.getApiProperty("catalog.uri"), searchQuery))
                .as(CatalogModel.class);
    }
}
