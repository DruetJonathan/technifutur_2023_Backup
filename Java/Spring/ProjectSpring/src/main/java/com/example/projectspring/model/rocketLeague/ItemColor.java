package com.example.projectspring.model.rocketLeague;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public enum ItemColor {
    NONE("None"),
    BLACK("Black"),
    BURNT_SIENNA("Burnt Sienna"),
    COBALT("Cobalt"),
    CRIMSON("Crimson"),
    FOREST_GREEN("Forest Green"),
    GOLD("Gold"),
    GREY("Grey"),
    LIME("Lime"),
    ORANGE("Orange"),
    PINK("Pink"),
    PURPLE("Purple"),
    SAFFRON("Saffron"),
    TITANIUM_WHITE("Titanium White");

    private final String value;

    ItemColor(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
