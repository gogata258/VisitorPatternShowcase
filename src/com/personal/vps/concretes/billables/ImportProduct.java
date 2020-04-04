package com.personal.vps.concretes.billables;

import com.personal.vps.common.ProductType;
import com.personal.vps.common.AbstractProduct;

public class ImportProduct extends AbstractProduct {

    public ImportProduct(String name, double price, ProductType type) {
        super(name, price, type);
    }

    @Override
    public double getPriceOfSelf() {
        return this.purchasePrice;
    }
}
