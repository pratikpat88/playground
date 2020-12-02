package com.pratik.playground;

import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

class User {
    private long id;
    private String name;
    private String email;
    private Cart cart;
}

class Address {
}

class Cart {
    private Map<Product, Integer> productQuantityMap;
    // OR private List<Product> productList;
    private List<Discount> discountList;
    private Address shippingAddress;
    private Address billingAddress;

    public void addDiscount(Discount discount) {
    }

    // without tax, shipping and discounts
    public double getSubtotal() {
        double subtotal = 0.0;
        for (final Map.Entry<Product, Integer> productQuantityEntry : productQuantityMap.entrySet()) {
            final Product product = productQuantityEntry.getKey();
            final int quantity = productQuantityEntry.getValue();
            subtotal += (product.getPrice() * quantity);
        }
        return subtotal;
    }

    // with tax, shipping and discounts
    public double getTotal() {
        return 0;
    }

    public double getShippingCharge() {
        return 0;
    }

    public double getDiscountValue() {
        return 0;
    }

    public double getTax() {
        return 0;
    }
}

class Product {
    private long id;
    private String name;
    private String description;
    private double price;

    public double getPrice() {
        return price;
    }
}

interface Discount {
    double calculateDiscountValue(Cart cart);
}

class BXGYDiscount implements Discount {
    int buyCount;
    int getFreeCount;

    public BXGYDiscount(int buyCount, int getFreeCount) {
        this.buyCount = buyCount;
        this.getFreeCount = getFreeCount;
    }

    public static BXGYDiscount BOGO_DISCOUNT = new BXGYDiscount(1, 1);
    public static BXGYDiscount B3G1_DISCOUNT = new BXGYDiscount(3, 1);

    @Override
    public double calculateDiscountValue(Cart cart) {
        return 0;
    }
}

class PercentageDiscount implements Discount {
    private NavigableMap<Double, Double> thresholdPercentageMap;

    public PercentageDiscount() {
        thresholdPercentageMap = new TreeMap<>();
        thresholdPercentageMap.put(500.0, 5.0);
        thresholdPercentageMap.put(5_000.0, 7.0);
        thresholdPercentageMap.put(10_000.0, 10.0);
        thresholdPercentageMap.put(15_000.0, 20.0);
    }

    @Override
    public double calculateDiscountValue(Cart cart) {
        final double subtotal = cart.getSubtotal();
        double discountPercent = thresholdPercentageMap.floorKey(subtotal);
        return discountPercent / 100 * subtotal;
    }
}
