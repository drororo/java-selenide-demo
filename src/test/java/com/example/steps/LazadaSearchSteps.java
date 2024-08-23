package com.example.steps;

import com.codeborne.selenide.Condition;
import com.example.entities.CatalogModel;
import com.example.pages.LazadaSearchPage;
import io.qameta.allure.Step;

import java.util.List;

import static com.example.utils.TextHandler.getText;
import static org.assertj.core.api.Assertions.assertThat;

public class LazadaSearchSteps {

    private static final LazadaSearchPage lazadaSearchPage = new LazadaSearchPage();

    @Step
    public void openSearchPage(String searchQuery) {
        lazadaSearchPage.open(searchQuery);
    }

    @Step
    public void searchCatalogShouldBePresent(CatalogModel catalogModel) {
        searchCatalogTitleShouldBePresent(catalogModel);
        searchCatalogItemsShouldBePresent(catalogModel);
    }

    @Step
    public void searchCatalogTitleShouldBePresent(CatalogModel catalogModel) {
        lazadaSearchPage.catalogTitle.shouldHave(Condition.text(catalogModel.getMainInfo().getTitle()));
    }

    @Step
    public void searchCatalogItemsShouldBePresent(CatalogModel catalogModel) {
        List<CatalogModel.Mods.Item> expectedCatalogItems = catalogModel.getMods().getListItems();
        List<CatalogModel.Mods.Item> actualCatalogItems = lazadaSearchPage.getCatalogItems();

        for (int i = 0; i < expectedCatalogItems.size(); i++) {
            searchCatalogItemNameShouldBePresent(expectedCatalogItems.get(i), actualCatalogItems.get(i));
            searchCatalogItemPriceShouldBePresent(expectedCatalogItems.get(i), actualCatalogItems.get(i));
            searchCatalogItemSoldCountShouldBePresent(expectedCatalogItems.get(i), actualCatalogItems.get(i));
            searchCatalogItemLocationShouldBePresent(expectedCatalogItems.get(i), actualCatalogItems.get(i));
        }
    }

    @Step
    public void searchCatalogItemNameShouldBePresent(
            CatalogModel.Mods.Item expectedCatalogItem,
            CatalogModel.Mods.Item actualCatalogItem
    ) {
        assertThat(actualCatalogItem.getName()).isEqualTo(expectedCatalogItem.getName());
    }

    @Step
    public void searchCatalogItemPriceShouldBePresent(
            CatalogModel.Mods.Item expectedCatalogItem,
            CatalogModel.Mods.Item actualCatalogItem
    ) {
        assertThat(actualCatalogItem.getPriceShow()).isEqualTo(expectedCatalogItem.getPriceShow());
    }

    @Step
    public void searchCatalogItemSoldCountShouldBePresent(
            CatalogModel.Mods.Item expectedCatalogItem,
            CatalogModel.Mods.Item actualCatalogItem
    ) {
        assertThat(actualCatalogItem.getItemSoldCntShow()).isEqualTo(expectedCatalogItem.getItemSoldCntShow());
    }

    @Step
    public void searchCatalogItemLocationShouldBePresent(
            CatalogModel.Mods.Item expectedCatalogItem,
            CatalogModel.Mods.Item actualCatalogItem
    ) {
        assertThat(actualCatalogItem.getLocation()).isEqualTo(expectedCatalogItem.getLocation());
    }
}
