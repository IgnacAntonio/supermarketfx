package com.example.supermarketfx.Classes;

public class Allergens {
    private String allergenName;
    private AllergenType allergenType;

    public Allergens(AllergenType type) {
        if (type == null) {
            throw new RuntimeException("Allergene must not be null");
        }
    }

    public String getAllergenName() {
        return allergenName;
    }

    private void getName(AllergenType type) {
        switch (type) {
            case A -> allergenName = "Gluten";
            case B -> allergenName = "Krebstiere";
            case C -> allergenName = "Eier von Geflügel";
            case D -> allergenName = "Fisch";
            case E -> allergenName = "Erdnüsse";
            case F -> allergenName = "Sojabohnen";
            case G -> allergenName = "Milch von Säugetieren";
            case H -> allergenName = "Schalenfrüchte";
            case L -> allergenName = "Sellerie";
            case M -> allergenName = "Senf";
            case N -> allergenName = "Sesamsamen";
            case O -> allergenName = "Schwefeloxid und Sulfite";
            case P -> allergenName = "Lupinen";
            case R -> allergenName = "Weichtiere";
            default -> {
            }
        }
    }
}
