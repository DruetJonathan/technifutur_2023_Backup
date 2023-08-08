package com.example.projectspring.model.rocketLeague;

public enum ItemQuality {
    COMMON("Common"),
    UNCOMMON("Uncommon"),
    RARE("Rare"),
    VERY_RARE("Very Rare"),
    IMPORT("Import"),
    EXOTIC("Exotic"),
    BLACK_MARKET("Black Market"),
    PREMIUM("Premium"),
    LIMITED("Limited");

    private final String name;

    ItemQuality(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
