package com.personal.vps.concretes.visitors;

import com.personal.vps.concretes.billables.DomesticProduct;
import com.personal.vps.concretes.billables.ImportProduct;
import com.personal.vps.common.IVisitor;

public class EndClientSaleTaxVisitor implements IVisitor {
    @Override
    public String getVisitorName() {
        return "End Client Sale Tax";
    }

    @Override
    public double Visit(DomesticProduct p) {
        return p.getPriceOfSelf() * 0.2;
    }

    @Override
    public double Visit(ImportProduct p) {
        return p.getPriceOfSelf() * 0.2;
    }
}
