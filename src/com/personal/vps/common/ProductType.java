package com.personal.vps.common;

public enum ProductType {
    ComputerPart(0.07d),
    Cloths(0.03d),
    Food(0.03d),
    Alcohol(0.13d),
    Furniture(0.11d),
    Other(0.21d);

    private final double rate;

    private ProductType(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return this.rate;
    }
}
