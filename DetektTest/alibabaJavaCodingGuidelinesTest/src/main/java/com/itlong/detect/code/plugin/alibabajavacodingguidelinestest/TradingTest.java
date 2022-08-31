package com.itlong.detect.code.plugin.alibabajavacodingguidelinestest;

public class TradingTest {
    private float price = 10.0f;

    public void set_Price(float price) {
        this.price = price;
    }

    private boolean isCheap() {
        if (price > 100.0f)
            return false;
        else {
            return true;
        }
    }

}
