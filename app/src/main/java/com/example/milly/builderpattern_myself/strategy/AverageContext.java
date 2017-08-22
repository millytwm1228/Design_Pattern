package com.example.milly.builderpattern_myself.strategy;

/**
 * Created by milly on 2017/8/22.
 */

public class AverageContext {

    private AverageStrategy averageStrategy;

    public AverageContext(AverageStrategy averageStrategy) {
        this.averageStrategy = averageStrategy;
    }

    public void calculateResult(){
        this.averageStrategy.calculateAverageStrategy();
    }
}
