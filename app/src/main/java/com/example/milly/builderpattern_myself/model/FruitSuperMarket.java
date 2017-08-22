package com.example.milly.builderpattern_myself.model;

/**
 * Created by milly on 2017/8/15.
 */

public class FruitSuperMarket extends SuperMarketProduct {

    @Override public int getPrice() {
        return 320;
    }

    @Override public int getCount() {
        return 20;
    }

    @Override public String getProductName() {
        return super.getProductName()+" Fruit";
    }
}
