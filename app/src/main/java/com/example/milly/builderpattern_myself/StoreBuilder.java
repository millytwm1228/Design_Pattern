package com.example.milly.builderpattern_myself;

import com.example.milly.builderpattern_myself.model.CookieSuperMarket;
import com.example.milly.builderpattern_myself.model.FruitSuperMarket;

/**
 * Created by milly on 2017/8/15.
 */

public class StoreBuilder {

    public BigStore prepareStoreProduct (){
        BigStore meal = new BigStore();
        meal.addItem(new FruitSuperMarket());
        meal.addItem(new CookieSuperMarket());
        return meal;
    }

    public BigStore prepareNonVegMeal (){
        BigStore meal = new BigStore();
        //meal.addItem(new ChickenBurger());
        //meal.addItem(new Pepsi());
        return meal;
    }
}