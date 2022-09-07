package com.itlong.detect.code.alibabajavacodingguidelinestest;

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 *
 * @author HuQingHui
 * @date 2022/8/31
 */
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
