package com.example.supermarketfx.Classes;


import java.util.*;

public class FoodProduct extends Product {

    private LinkedList<Allergens> allergens = new LinkedList<>();

    public FoodProduct(String name, int quantity, int price, int barcode) {
        super(name, quantity, price, barcode);
    }

    public LinkedList<Allergens> getAllergens() {
        return allergens;
    }

    public void addAllergens(Allergens allergens) {
        if (allergens == null) {
            System.out.println("Allergen can't be null");
            return;
        } else {
            this.allergens.add(allergens);
        }
    }

    public void deleteAllergens(Allergens allergens) {
        for (Allergens a : this.allergens) {
            if (a.equals(allergens)) {
                this.allergens.remove(a);
                return;
            }
        }
    }

public boolean containsAllergen(LinkedList<Allergens> allergens) {
    boolean isContained = true;
    for (Allergens a : allergens) {
        if (!this.allergens.contains(a)) {
            isContained = false;
            break;
        }
    }
    return isContained;
}
}
