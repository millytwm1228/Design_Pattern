package com.example.milly.builderpattern_myself.model;

/**
 * Created by milly on 2017/8/15.
 */

public class CookieSuperMarket extends SuperMarketProduct {

    @Override public int getPrice() {
        return 260;
    }

    @Override public int getCount() {
        return 10;
    }

    @Override public String getProductName() {
        return super.getProductName()+" Cookie";
    }
}
