package com.itlong.detect.code.plugin.alibabajavacodingguidelinestest;

public class Computer {
    private int price = 5000;

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isExpensive() {
        if (price > 10000) return true;
        else {
            return false;
        }
    }
}
