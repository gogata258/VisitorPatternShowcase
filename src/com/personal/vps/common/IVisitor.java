package com.personal.vps.common;

import com.personal.vps.concretes.billables.DomesticProduct;
import com.personal.vps.concretes.billables.ImportProduct;

public interface IVisitor {
    public String getVisitorName();
    public double Visit(DomesticProduct p);
    public double Visit(ImportProduct p);
}
