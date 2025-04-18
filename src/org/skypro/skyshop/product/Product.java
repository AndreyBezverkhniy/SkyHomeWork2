package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Empty product name is forbidden");
        }
        this.name = name;
    }

    @Override
    public String getSearchableName() {
        return name;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getSearchableType() {
        return "PRODUCT";
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
}
