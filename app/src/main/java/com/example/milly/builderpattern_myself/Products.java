package com.example.milly.builderpattern_myself;

import com.example.milly.builderpattern_myself.interfaces.Product;
import com.example.milly.builderpattern_myself.model.SuperMarketProduct;

/**
 * Created by milly on 2017/8/15.
 */

public class Products extends SuperMarketProduct{

    private final int price;//must
    private final String productName;//must
    private final String type;//optional
    private final String description;//optional
    private final String source;//optional

    private Products(ProductBuilder builder){
        this.price = builder.price;
        this.productName = builder.productName;
        this.type = builder.type;
        this.description = builder.description;
        this.source = builder.source;
    }

    public int getPrice() {
        return price;
    }

    @Override public int getCount() {
        return 0;
    }

    public String getProductName() {
        return productName;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getSource() {
        return source;
    }

    public static class ProductBuilder{
        private final int price;
        private final String productName;
        private String type;
        private String description;
        private String source;

        public ProductBuilder(int price,String productName){
            this.price = price;
            this.productName = productName;
        }

        public ProductBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public ProductBuilder setDescription(String description) {
            this.description = description;
            return this;

        }


        public ProductBuilder setSource(String source) {
            this.source = source;
            return this;

        }

        public Products build(){
            Products products = new Products(this);

            if (products.getProductName().isEmpty()){
                throw  new IllegalStateException("產品名稱不可為空!");
            }
            return products;
        }
    }

}
