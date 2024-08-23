package com.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.example.entities.CatalogModel;
import com.example.utils.PropertiesHandler;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LazadaSearchPage extends LazadaBasePage {

    public SelenideElement catalogTitle = $("h1");
    public ElementsCollection catalogItemWrapperList = $$("[data-qa-locator='product-item']");
    public String catalogItemNameXpathSelector = "./div/div/div[2]/div[2]";
    public String catalogItemPriceXpathSelector = "./div/div/div[2]/div[3]";
    public String catalogItemSoldCountXpathSelector = "./div/div/div[2]/div[5]/span";
    public String catalogItemLocationXpathSelector = "./div/div/div[2]/div[5]/div";

    @Override
    public void open(String query) {
        String relativeUrl = String.format(PropertiesHandler.getWebProperty("search.relative.url"), query, query);

        super.open(relativeUrl);
    }

    public List<CatalogModel.Mods.Item> getCatalogItems() {
        List<CatalogModel.Mods.Item> catalogItems = new ArrayList<>();

        for (SelenideElement catalogItemWrapper : catalogItemWrapperList.asFixedIterable()) {
            CatalogModel.Mods.Item catalogItem = new CatalogModel.Mods.Item();

            catalogItem.setName(catalogItemWrapper.$(By.xpath(catalogItemNameXpathSelector)).text());
            catalogItem.setPriceShow(catalogItemWrapper.$(By.xpath(catalogItemPriceXpathSelector)).text());
            catalogItem.setItemSoldCntShow(catalogItemWrapper.$(By.xpath(catalogItemSoldCountXpathSelector)).text());
            catalogItem.setLocation(catalogItemWrapper.$(By.xpath(catalogItemLocationXpathSelector)).text());

            catalogItems.add(catalogItem);
        }

        return catalogItems;
    }
}
