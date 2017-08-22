package com.example.milly.builderpattern_myself;

import com.example.milly.builderpattern_myself.interfaces.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milly on 2017/8/15.
 */

public class BigStore {
    private List<Product> items = new ArrayList<Product>();

    public void addItem(Product item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;

        for (Product item : items) {
            cost += item.getPrice();
        }
        return cost;
    }

    public void showItems(){

        for (Product item : items) {
            System.out.print("Item : " + item.getProductName());
            System.out.print(", Count : " + item.getCount());
            System.out.println(", Price : " + item.getPrice());
        }
    }
}
