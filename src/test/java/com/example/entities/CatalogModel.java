package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogModel {

    private MainInfo mainInfo;
    private Mods mods;

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }

    public Mods getMods() {
        return mods;
    }

    public void setMods(Mods mods) {
        this.mods = mods;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MainInfo {

        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Mods {

        private List<Item> listItems;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Item {

            private String name;
            private String priceShow;
            private String itemSoldCntShow;
            private String location;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPriceShow() {
                return priceShow;
            }

            public void setPriceShow(String priceShow) {
                this.priceShow = priceShow;
            }

            public String getItemSoldCntShow() {
                return itemSoldCntShow;
            }

            public void setItemSoldCntShow(String itemSoldCntShow) {
                this.itemSoldCntShow = itemSoldCntShow;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }
        }

        public List<Item> getListItems() {
            return listItems;
        }

        public void setListItems(List<Item> listItems) {
            this.listItems = listItems;
        }
    }
}
