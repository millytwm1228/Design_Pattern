package com.example.milly.builderpattern_myself.model;

import com.example.milly.builderpattern_myself.interfaces.Product;

/**
 * Created by milly on 2017/8/15.
 */

public abstract class SuperMarketProduct implements Product {

    @Override public String getProductName() {
        return "SuperMarket";
    }
}
