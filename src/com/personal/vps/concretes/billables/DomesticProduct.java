package com.personal.vps.concretes.billables;

import com.personal.vps.common.ProductType;
import com.personal.vps.common.AbstractProduct;

public class DomesticProduct extends AbstractProduct {

    public DomesticProduct(String name, double price, ProductType type) {
        super(name, price, type);
    }

    @Override
    public double getPriceOfSelf() {
        return this.purchasePrice - (this.purchasePrice * 0.2d);
    }
}
