package com.personal.vps;

import com.personal.vps.common.AbstractProduct;
import com.personal.vps.common.IVisitor;
import com.personal.vps.common.ProductType;
import com.personal.vps.concretes.billables.DomesticProduct;
import com.personal.vps.concretes.billables.ImportProduct;
import com.personal.vps.concretes.visitors.EndClientSaleTaxVisitor;
import com.personal.vps.concretes.visitors.ImportTaxVisitor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Example1();
        Example2();
        Example3();
    }

    //this might be a more plausable usage as well (Same just imagine we are buying stuff in the store and seeing the receipt)
    private static void Example3() {
        IVisitor itv = new EndClientSaleTaxVisitor();

        ArrayList<DomesticProduct> cart = new ArrayList<>();
        cart.add(new DomesticProduct("Soda 500ml x24", 26, ProductType.Food));
        cart.add(new DomesticProduct("JB 700ml x12", 270, ProductType.Alcohol));
        cart.add(new DomesticProduct("Chairs 4x Set", 210, ProductType.Furniture));
        cart.add(new DomesticProduct("Ski Set SpeedMaster", 312, ProductType.Other));
        cart.add(new DomesticProduct("Rakia 700ml x12", 245, ProductType.Alcohol));

        //this is to see the list in detail
        cart.stream().forEach(p -> {
            System.out.println("Product: " + p.getProductName());
            System.out.println("Price: " + p.getPriceOfSelf());
            System.out.println("Tax: " + itv.Visit(p));
            System.out.println();
        });

        double totalTax, subTotal;
        totalTax = cart.stream().map(itv::Visit).mapToDouble(t -> t).sum();
        System.out.println("Total tax owned: " + totalTax);
        subTotal = cart.stream().mapToDouble(p -> p.getPriceOfSelf()).sum();
        System.out.println("Subtotal of goods: " + subTotal);
        System.out.println("Total after tax: " + (subTotal + totalTax));
    }

    //this might be a more plausable usage
    private static void Example2() {
        IVisitor itv = new ImportTaxVisitor();

        ArrayList<ImportProduct> importedGoods = new ArrayList<>();
        importedGoods.add(new ImportProduct("Soda 500ml x24", 26, ProductType.Food));
        importedGoods.add(new ImportProduct("JB 700ml x12", 270, ProductType.Alcohol));
        importedGoods.add(new ImportProduct("Chairs 4x Set", 210, ProductType.Furniture));
        importedGoods.add(new ImportProduct("Ski Set SpeedMaster", 312, ProductType.Other));
        importedGoods.add(new ImportProduct("Rakia 700ml x12", 245, ProductType.Alcohol));

        //this is to see the list in detail
        importedGoods.stream().forEach(p -> {
            System.out.println("Product: " + p.getProductName());
            System.out.println("Price of self: " + p.getPriceOfSelf());
            System.out.println("Tax of product: " + itv.Visit(p));
            System.out.println();
        });

        double totalTax, subTotal;
        totalTax = importedGoods.stream().map(itv::Visit).mapToDouble(t -> t).sum();
        System.out.println("Total tax owned: " + totalTax);
        subTotal = importedGoods.stream().mapToDouble(p -> p.getPriceOfSelf()).sum();
        System.out.println("Subtotal of goods: " + subTotal);
        System.out.println("Total after tax: " + (subTotal + totalTax));
    }

    //This will probably never be used in production but it does illustrate the point
    private static void Example1() {
        ArrayList<IVisitor> visitors = new ArrayList<>();
        visitors.add(new ImportTaxVisitor());
        visitors.add(new EndClientSaleTaxVisitor());

        ArrayList<AbstractProduct> set = new ArrayList<>();
        set.add(new ImportProduct("Soda 500ml x24", 26, ProductType.Food));
        set.add(new ImportProduct("JB 700ml x12", 270, ProductType.Alcohol));
        set.add(new ImportProduct("Chairs 4x Set", 210, ProductType.Furniture));
        set.add(new DomesticProduct("Ski Set SpeedMaster", 312, ProductType.Other));
        set.add(new DomesticProduct("Rakia 700ml x12", 245, ProductType.Alcohol));

        set.stream().forEach(p -> {
            visitors.stream().forEach(v -> {
                System.out.println("Visitor: " + v.getVisitorName());
                System.out.println("Product: " + p.getProductName());
                System.out.println("Price of self: " + p.getPriceOfSelf());
                if (p instanceof DomesticProduct)
                    System.out.println("Tax: " + v.Visit((DomesticProduct) p));
                else if (p instanceof ImportProduct)
                    System.out.println("Tax: " + v.Visit((ImportProduct) p));
                else System.out.println("unable to cast product to a concrete type. Why is java so fucked up!!!");
                System.out.println();
            });
        });
    }
}
