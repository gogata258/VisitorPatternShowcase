package com.personal.vps.concretes.visitors;

import com.personal.vps.common.IVisitor;
import com.personal.vps.concretes.billables.DomesticProduct;
import com.personal.vps.concretes.billables.ImportProduct;

public class ImportTaxVisitor implements IVisitor {
    @Override
    public String getVisitorName() {
        return "Import Tax";
    }

    @Override
    public double Visit(DomesticProduct p) {
        return 0;
    }

    @Override
    public double Visit(ImportProduct p) {
        return (p.getProductType().getRate() * p.getPriceOfSelf());
    }
}
