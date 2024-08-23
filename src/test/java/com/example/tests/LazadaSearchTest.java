package com.example.tests;

import com.example.entities.CatalogModel;
import com.example.fixtures.LazadaSearchFixtures;
import com.example.steps.LazadaSearchSteps;
import org.junit.jupiter.api.Test;

public class LazadaSearchTest {

    static LazadaSearchSteps lazadaSearchSteps = new LazadaSearchSteps();
    static LazadaSearchFixtures lazadaSearchFixtures = new LazadaSearchFixtures();

    @Test
    public void successOpenSearchOnLazada() {
        String searchQuery = "coffee";

        lazadaSearchSteps.openSearchPage(searchQuery);
        lazadaSearchSteps.searchCatalogShouldBePresent(lazadaSearchFixtures.getCatalogModel(searchQuery));
    }
}
