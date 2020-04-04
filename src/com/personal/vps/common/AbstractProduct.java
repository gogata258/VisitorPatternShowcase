package com.personal.vps.common;

public abstract class AbstractProduct {
    protected ProductType productType;
    protected double purchasePrice = 0;
    protected String name;

    public AbstractProduct(String name, double price, ProductType type) {
        this.productType = type;
        this.purchasePrice = price;
        this.name = name;
    }

    public abstract double getPriceOfSelf();

    public ProductType getProductType() {
        return this.productType;
    }

    public String getProductName() {
        return this.name;
    }

}
